package model.dao.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static ConnectionPool connectionPool = null;
    private static BasicDataSource basicDataSource = new BasicDataSource();

    public static ConnectionPool getConnectionPoolInstance() {
        if(connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public static Connection getConnection() {
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/Railway_ticket_booking_system?serverTimezone=UTC");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(10);
        basicDataSource.setMaxOpenPreparedStatements(10);
        try {
            return basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC
}
