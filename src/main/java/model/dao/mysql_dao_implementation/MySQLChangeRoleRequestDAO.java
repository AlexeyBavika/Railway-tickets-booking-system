package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao.ChangeRoleRequestDAO;
import model.entity.ChangeRoleRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLChangeRoleRequestDAO implements ChangeRoleRequestDAO {
    private static final Logger LOGGER = LogManager.getLogger(MySQLChangeRoleRequestDAO.class);
    private static MySQLChangeRoleRequestDAO instance = new MySQLChangeRoleRequestDAO();

    static MySQLChangeRoleRequestDAO getInstance() {
        return instance;
    }

    @Override
    public void createChangeRoleRequest(int passengerId, String text) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO change_role_requests (user_id, text) VALUES (?, ?)")) {
            preparedStatement.setInt(1, passengerId);
            preparedStatement.setString(2, text);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't create change role request.";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
    }

    @Override
    public List<ChangeRoleRequest> getAllChangeRoleRequests() {
        ChangeRoleRequest changeRoleRequest = null;
        List<ChangeRoleRequest> changeRoleRequests = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM change_role_requests")) {
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
            e.printStackTrace();
        }
        return changeRoleRequests;
    }

    @Override
    public void deleteChangeRoleRequest(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM change_role_requests WHERE change_role_requests.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't delete change role request";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
    }
}
