package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao.ChangeRoleRequestDAO;
import model.entity.ChangeRoleRequest;
import model.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLChangeRoleRequestDAO implements ChangeRoleRequestDAO {
    private final int RECORDS_PER_PAGE = 10;
    private static final Logger LOGGER = LogManager.getLogger(MySQLChangeRoleRequestDAO.class);
    private static MySQLChangeRoleRequestDAO instance = new MySQLChangeRoleRequestDAO();

    static MySQLChangeRoleRequestDAO getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createChangeRoleRequest(int passengerId, String text) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.CREATE_CHANGE_ROLE_REQUEST)) {
            preparedStatement.setInt(1, passengerId);
            preparedStatement.setString(2, text);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't create change role request.";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ChangeRoleRequest> getAllChangeRoleRequests(int currentPage) {
        String query = paginate(currentPage);

        ChangeRoleRequest changeRoleRequest = null;
        List<ChangeRoleRequest> changeRoleRequests = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int passengerId = resultSet.getInt("user_id");
                String text = resultSet.getString("text");
                changeRoleRequest = new ChangeRoleRequest(passengerId, text);
                changeRoleRequest.setId(resultSet.getInt("id"));
                changeRoleRequests.add(changeRoleRequest);
            }
        } catch (SQLException e) {
            String errorText = "can't get all change role requests.";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return changeRoleRequests;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteChangeRoleRequest(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.DELETE_CHANGE_ROLE_REQUEST)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't delete change role request";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
    }

    private String paginate(int currentPage) {
        String query = "SELECT * FROM change_role_requests LIMIT ";
        switch (currentPage) {
            case 1:
                query += RECORDS_PER_PAGE;
                break;
            default:
                query += (currentPage - 1) * RECORDS_PER_PAGE + ", " + RECORDS_PER_PAGE;
                break;
        }
        return query;
    }
}
