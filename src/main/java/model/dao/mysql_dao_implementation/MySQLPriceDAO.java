package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao_interfaces.PriceDAO;
import model.entity.Price;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLPriceDAO implements PriceDAO {
    private static MySQLPriceDAO instance = new MySQLPriceDAO();

    static MySQLPriceDAO getInstance() {
        return instance;
    }

    @Override
    public Price createPrice(Price price) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO prices (route_id, berth_price, coupe_price, deluxe_price) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, price.getRouteId());
            preparedStatement.setInt(2, price.getBerthPrice());
            preparedStatement.setInt(3, price.getCoupePrice());
            preparedStatement.setInt(4, price.getDeluxePrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    @Override
    public void deletePrice(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM prices WHERE price.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Price> getAllPrices() {
        List<Price> prices = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM prices")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int routeId = resultSet.getInt("route_id");
                int berthPrice = resultSet.getInt("berth_price");
                int coupePrice = resultSet.getInt("coupe_price");
                int deluxePrice = resultSet.getInt("deluxe_price");
                prices.add(new Price(routeId, berthPrice, coupePrice, deluxePrice));
            }
        } catch (SQLException e) {

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
            e.printStackTrace();
        }
        return price;
    }
}
