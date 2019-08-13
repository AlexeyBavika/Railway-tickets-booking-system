package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao.UserDAO;
import model.entity.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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

    @Override
    public User createUser(User user) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, surname, email, password, phone, role_id) VALUES (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setInt(6, user.getRoleId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't create user";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE users.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't delete user";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users")) {
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
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findUserById(int id) {
        User user = null;
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE users.id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String phone = resultSet.getString("phone");
            int roleId = resultSet.getInt("role_id");
            user = new User(name, surname, email, password, phone, roleId);
        } catch (SQLException e) {

        }
        return user;
    }

    @Override
    public void updateUserRole(int id, int roleId) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET users.role_id = ? WHERE users.id = ?")) {
            preparedStatement.setInt(1, roleId);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't update user role";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAllEmails() {
        List<String> emails = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT email FROM users")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String email = resultSet.getString("email");
                emails.add(email);
            }
        } catch (SQLException e) {
            String errorText = "can't get all emails";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
        return emails;
    }

    @Override
    public List<String> getAllPhones() {
        List<String> phones = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT phone FROM users")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String phone = resultSet.getString("phone");
                phones.add(phone);
            }
        } catch (SQLException e) {
            String errorText = "can't get all phones";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
        return phones;
    }

    @Override
    public int getUserRoleId(User user) {
        int userRoleId = 0;
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT role_id FROM users WHERE users.email = ?")) {
            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userRoleId = resultSet.getInt("role_id");
            }
        } catch (SQLException e) {
            String errorText = "can't get user role id";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
        return userRoleId;
    }

    @Override
    public User getUser(String email, String password) {
        User user = null;

        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, surname, phone, role_id FROM users WHERE users.email = ? AND users.password = ?")) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                int roleId = resultSet.getInt("role_id");
                user = new User(name, surname, email, password, phone, roleId);
                user.setId(resultSet.getInt("id"));
            }

        } catch (SQLException e) {
            String errorText = "can't get user";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllAdmins() {
        List<User> admins = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE users.role_id = 2")) {
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
                admins.add(user);
            }
        } catch (SQLException e) {
            String errorText = "can't get all admins";
            LOGGER.error(errorText);
        }
        return admins;
    }
}
