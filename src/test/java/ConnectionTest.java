import model.dao.connection.ConnectionPool;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

public class ConnectionTest {
    @Test
    public void testConnection() throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        assertTrue(connection.isValid(1));
    }
}
