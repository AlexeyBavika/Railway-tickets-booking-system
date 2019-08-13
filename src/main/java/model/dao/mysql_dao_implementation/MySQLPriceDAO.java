package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao.PriceDAO;
import model.entity.Price;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLPriceDAO implements PriceDAO {
    private static final Logger LOGGER = LogManager.getLogger(MySQLPriceDAO.class);

    private static MySQLPriceDAO instance = new MySQLPriceDAO();

    static MySQLPriceDAO getInstance() {
        return instance;
    }

    @Override
    public void createPrice(Price price) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO prices (route_id, berth_price, coupe_price, deluxe_price) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, price.getRouteId());
            preparedStatement.setInt(2, price.getBerthPrice());
            preparedStatement.setInt(3, price.getCoupePrice());
            preparedStatement.setInt(4, price.getDeluxePrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't create price";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
    }

    @Override
    public void deletePrice(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM prices WHERE prices.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't delete price";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
    }

    @Override
    public List<Price> getAllPrices() {
        Price price = null;
        List<Price> prices = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM prices")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int routeId = resultSet.getInt("route_id");
                int berthPrice = resultSet.getInt("berth_price");
                int coupePrice = resultSet.getInt("coupe_price");
                int deluxePrice = resultSet.getInt("deluxe_price");
                price = new Price(routeId, berthPrice, coupePrice, deluxePrice);
                price.setId(resultSet.getInt("id"));
                prices.add(price);
            }
        } catch (SQLException e) {
            String errorText = "can't get all prices";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
        return prices;
    }

    @Override
    public Price getPriceByRouteId(int routeId) {
        Price price = null;
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM prices WHERE prices.route_id = ?")) {
            preparedStatement.setInt(1, routeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int idOfRoute = resultSet.getInt("route_id");
                int berthPrice = resultSet.getInt("berth_price");
                int coupePrice = resultSet.getInt("coupe_price");
                int deluxePrice = resultSet.getInt("deluxe_price");
                price = new Price(idOfRoute, berthPrice, coupePrice, deluxePrice);
                price.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            String errorText = "can't get price by route id";
            LOGGER.error(errorText);
            e.printStackTrace();
        }
        return price;
    }
}
