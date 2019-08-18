package model.dao.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool connectionPool = null;
    private static BasicDataSource basicDataSource = new BasicDataSource();
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    /**
        method for getting connection pool instance
     @return connection pool instance
     */
    public static ConnectionPool getConnectionPoolInstance() {
        if(connectionPool == null) {
            synchronized (ConnectionPool.class) {
                if(connectionPool == null) {
                    connectionPool = new ConnectionPool();
                }
            }
        }
        return connectionPool;
    }

    /**
     * method for getting connection
     * @return connection
     */
    public static Connection getConnection() {
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/Railway_ticket_booking_system?serverTimezone=UTC");
        basicDataSource.setUsername(getProperty("username"));
        basicDataSource.setPassword(getProperty("password"));
        basicDataSource.setMinIdle(Integer.parseInt(getProperty("minIdle")));
        basicDataSource.setMaxIdle(Integer.parseInt(getProperty("maxIdle")));
        basicDataSource.setMaxOpenPreparedStatements(Integer.parseInt(getProperty("maxOpenPreparedStatements")));
        try {
            return basicDataSource.getConnection();
        } catch (SQLException e) {
            String errorText = "can't get connection to database";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
        return null;
    }

    private static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
//?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC
}
