package com.caxerx.mc.commandscorll;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

public class DatabaseTest {
    @Test
    public static void databaseTest() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setPoolName("AuthMeSQLitePool");
        config.setDriverClassName("org.sqlite.JDBC");
        config.setJdbcUrl("jdbc:sqlite:dd.db");
        config.setConnectionTestQuery("CREATE TABLE IF NOT EXISTS UsageLog(player_name VARCHAR(100) NOT NULL, player_uuid VARCHAR(36) NOT NULL, scroll_name VARCHAR(100) NOT NULL, use_time TIMESTAMP NOT NULL, location_x NUMBER(10) NOT NULL, location_y NUMBER(10) NOT NULL, location_z NUMBER(10) NOT NULL);");
        config.setMaxLifetime(60000); // 60 Sec
        config.setIdleTimeout(45000); // 45 Sec
        config.setMaximumPoolSize(50); // 50 Connections (including idle connections)
        HikariDataSource ds = new HikariDataSource(config);
        Connection co = ds.getConnection();
        PreparedStatement ps = co.prepareStatement("INSERT INTO UsageLog VALUES(?,?,?,?);");
        ps.setString(1, "dick");
        ps.setString(2, UUID.randomUUID().toString());
        ps.setString(3, "monoscope");
        ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        ps.execute();
        ps.close();
        co.close();
    }
}
