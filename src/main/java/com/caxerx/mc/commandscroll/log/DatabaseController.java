package com.caxerx.mc.commandscroll.log;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DatabaseController {
    private HikariDataSource hikariDataSource;

    public DatabaseController(File databaseFile) {
        HikariConfig config = new HikariConfig();
        config.setPoolName("CommandScrollPool");
        config.setDriverClassName("org.sqlite.JDBC");
        config.setJdbcUrl("jdbc:sqlite:" + databaseFile);
        config.setConnectionTestQuery("CREATE TABLE IF NOT EXISTS UsageLog(player_name VARCHAR(100) NOT NULL, player_uuid VARCHAR(36) NOT NULL, scroll_name VARCHAR(36) NOT NULL, use_time TIMESTAMP NOT NULL, world VARCHAR(36) NOT NULL, location_x NUMBER(10) NOT NULL, location_y NUMBER(10) NOT NULL, location_z NUMBER(10) NOT NULL);");
        config.setMaxLifetime(60000); // 60 Sec
        config.setIdleTimeout(45000); // 45 Sec
        config.setMaximumPoolSize(50); // 50 Connections (including idle connections)
        hikariDataSource = new HikariDataSource(config);
    }

    public void addLog(String player, String uuid, String scroll, long useTime, String world, int x, int y, int z) {
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = hikariDataSource.getConnection();
            ps = connection.prepareStatement("INSERT INTO UsageLog VALUES(?,?,?,?,?,?,?,?);");
            ps.setString(1, player);
            ps.setString(2, uuid);
            ps.setString(3, scroll);
            ps.setTimestamp(4, new Timestamp(useTime));
            ps.setString(5, world);
            ps.setInt(6, x);
            ps.setInt(7, y);
            ps.setInt(8, z);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error in add sql log");
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
                //ignore
            }
            try {
                connection.close();
            } catch (Exception e) {
                //ignore
            }

        }


    }
}
