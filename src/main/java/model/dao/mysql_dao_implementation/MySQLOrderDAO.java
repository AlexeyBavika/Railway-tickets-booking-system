package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao.OrderDAO;
import model.entity.Order;
import model.exception.DAOException;
import model.service.PaginationService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLOrderDAO implements OrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(MySQLOrderDAO.class);

    private static MySQLOrderDAO instance = new MySQLOrderDAO();

    static MySQLOrderDAO getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createOrder(int passengerId, int trainId, String placeType, int price) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.CREATE_ORDER)) {
            preparedStatement.setInt(1, passengerId);
            preparedStatement.setInt(2, trainId);
            preparedStatement.setString(3, placeType);
            preparedStatement.setInt(4, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't create order";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteOrder(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.DELETE_ORDER)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't delete order";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Order> getAllOrders(int currentPage) {
        String query = PaginationService.getInstance().paginate(currentPage, "orders");

        Order order = null;
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
            String errorText = "can't get all orders";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return orders;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Order> getAllOrdersById(int passengerId, int currentPage) {
        String query = PaginationService.getInstance().paginate(currentPage, "orders");
        query = query.substring(26);

        Order order = null;
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_ALL_ORDERS_BY_ID + query)) {
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
            String errorText = "can't get all orders by id";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return orders;
    }
}
