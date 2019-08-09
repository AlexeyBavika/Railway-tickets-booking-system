package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao_interfaces.RoleDAO;
import model.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLRoleDAO implements RoleDAO {
    private static MySQLRoleDAO instance = new MySQLRoleDAO();

    static MySQLRoleDAO getInstance() {
        return instance;
    }

    @Override
    public Role createRole(Role role) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO roles (role_name) VALUES (?)")) {
            preparedStatement.executeQuery();
        } catch (SQLException e) {

        }
        return role;
    }

    @Override
    public void deleteRole(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM roles WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM roles")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String roleName = resultSet.getString("role_name");
                roles.add(new Role(roleName));
            }
        } catch (SQLException e) {

        }
        return roles;
    }

    @Override
    public Role getRoleById(int id) {
        Role role = null;
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM roles WHERE role.id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String roleName = resultSet.getString("role_name");
            role = new Role(roleName);
        } catch (SQLException e) {

        }
        return role;
    }

    @Override
    public void updateRole(int id, String name) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE roles SET roles.role_name = ? WHERE roles.id = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
}
