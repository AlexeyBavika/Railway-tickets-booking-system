package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao.OrderDAO;
import model.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLOrderDAO implements OrderDAO {
    private static MySQLOrderDAO instance = new MySQLOrderDAO();

    static MySQLOrderDAO getInstance() {
        return instance;
    }

    @Override
    public void createOrder(int passengerId, int trainId, String placeType, int price) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders (passenger_id, train_id, place_type, price) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, passengerId);
            preparedStatement.setInt(2, trainId);
            preparedStatement.setString(3, placeType);
            preparedStatement.setInt(4, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE orders.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Order> getAllOrders() {
        Order order = null;
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int passengerId = resultSet.getInt("passenger_id");
                int trainId = resultSet.getInt("train_id");
                String placeType = resultSet.getString("place_type");
                int price = resultSet.getInt("price");
                order = new Order(passengerId, trainId, placeType, price);
                order.setId(resultSet.getInt("id"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> getAllOrdersById(int passengerId) {
        Order order = null;
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE orders.passenger_id = ?")) {
            preparedStatement.setInt(1, passengerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("passenger_id");
                int trainId = resultSet.getInt("train_id");
                String placeType = resultSet.getString("place_type");
                int price = resultSet.getInt("price");
                order = new Order(passengerId, trainId, placeType, price);
                order.setId(resultSet.getInt("id"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
