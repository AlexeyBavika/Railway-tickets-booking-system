package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao.UserDAO;
import model.entity.User;
import model.exception.DAOException;
import model.service.PaginationService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAO implements UserDAO {
    private static final Logger LOGGER = LogManager.getLogger(MySQLUserDAO.class);

    private static MySQLUserDAO instance = new MySQLUserDAO();

    static MySQLUserDAO getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User createUser(User user) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.CREATE_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            preparedStatement.setString(4, hashedPassword);
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setInt(6, user.getRoleId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't create user";
            LOGGER.error(errorText);
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUser(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.DELETE_USER)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't delete user";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllUsers(int currentPage) {
        String query = PaginationService.getInstance().paginate(currentPage, "users");

        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                int roleId = resultSet.getInt("role_id");
                User user = new User(name, surname, email, password, phone, roleId);
                user.setId(resultSet.getInt("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            String errorText = "can't get all users";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return users;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUserRole(int id, int roleId) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.UPDATE_USER_ROLE)) {
            preparedStatement.setInt(1, roleId);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't update user role";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAllEmails() {
        List<String> emails = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_ALL_USER_EMAILS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                emails.add(email);
            }
        } catch (SQLException e) {
            String errorText = "can't get all emails";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return emails;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAllPhones() {
        List<String> phones = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_ALL_USER_PHONES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String phone = resultSet.getString("phone");
                phones.add(phone);
            }
        } catch (SQLException e) {
            String errorText = "can't get all phones";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return phones;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getUserRoleId(User user) {
        int userRoleId = 0;
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_USER_ROLE_ID)) {
            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userRoleId = resultSet.getInt("role_id");
            }
        } catch (SQLException e) {
            String errorText = "can't get user role id";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return userRoleId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(String email, String password) {
        User user = null;

        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_USER)) {
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (BCrypt.checkpw(password, resultSet.getString("password"))) {
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String phone = resultSet.getString("phone");
                    int roleId = resultSet.getInt("role_id");
                    user = new User(name, surname, email, password, phone, roleId);
                    user.setId(resultSet.getInt("id"));
                }
            }

        } catch (SQLException e) {
            String errorText = "can't get user";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return user;
    }

    @Override
    public boolean isEmailExistsAndPhoneExists(String email, String phone) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.CHECK_IF_EMAIL_OR_PHONE_EXISTS)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, phone);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return false;
            }

        } catch (SQLException e) {
            String errorText = "can't get check if email or phone exists";
            LOGGER.error(errorText);
            throw new DAOException(e.getMessage(), e);
        }

        return true;
    }
}
