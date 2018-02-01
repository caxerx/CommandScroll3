package com.caxerx.mc.commandscroll.logging;

import com.caxerx.mc.commandscroll.logging.query.QueryResult;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.NonNull;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {
    private HikariDataSource hikariDataSource;
    private static DatabaseController instance;

    public DatabaseController(@NonNull File databaseFile) {
        HikariConfig config = new HikariConfig();
        config.setPoolName("CommandScrollPool");
        config.setDriverClassName("org.sqlite.JDBC");
        config.setJdbcUrl("jdbc:sqlite:" + databaseFile);
        config.setConnectionTestQuery("CREATE TABLE IF NOT EXISTS UsageLog(player_name VARCHAR(100) NOT NULL, player_uuid VARCHAR(36) NOT NULL, scroll_name VARCHAR(36) NOT NULL, use_time TIMESTAMP NOT NULL, world VARCHAR(36) NOT NULL, location_x NUMBER(10) NOT NULL, location_y NUMBER(10) NOT NULL, location_z NUMBER(10) NOT NULL);");
        config.setMaxLifetime(60000); // 60 Sec
        config.setIdleTimeout(45000); // 45 Sec
        config.setMaximumPoolSize(50); // 50 Connections (including idle connections)
        hikariDataSource = new HikariDataSource(config);
        instance = this;
    }

    public static DatabaseController getInstance() {
        return instance;
    }

    public void addLog(@NonNull String uuid, @NonNull String player, @NonNull String scroll, long useTime, @NonNull String world, int x, int y, int z) {
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = hikariDataSource.getConnection();
            ps = connection.prepareStatement("INSERT INTO UsageLog VALUES(?,?,?,?,?,?,?,?);");
            ps.setString(1, uuid);
            ps.setString(2, player);
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

    public List<QueryResult> queryLog(@NonNull String statement) {
        Connection connection = null;
        Statement connectionStatement = null;
        ArrayList<QueryResult> results = new ArrayList<>();
        try {
            connection = hikariDataSource.getConnection();
            connectionStatement = connection.createStatement();
            ResultSet queryResult = connectionStatement.executeQuery(statement);
            while (queryResult.next()) {
                String player = queryResult.getString("player_name");
                String scroll = queryResult.getString("scroll_name");
                String world = queryResult.getString("world");
                int x = queryResult.getInt("location_x");
                int y = queryResult.getInt("location_y");
                int z = queryResult.getInt("location_z");
                long time = queryResult.getTimestamp("use_time").getTime();
                results.add(new QueryResult(player, scroll, world, x, y, z, time));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connectionStatement.close();
            } catch (Exception e) {
                //ignore
            }
            try {
                connection.close();
            } catch (Exception e) {
                //ignore
            }
        }
        return results;
    }
}
