package springboot.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfiguration {
    private String username = "postgres";
    private String password = "lahatra2004";
    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/appointment",
          username,
          password
        );
    }
}
