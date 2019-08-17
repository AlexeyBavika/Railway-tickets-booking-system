package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao.RouteDAO;
import model.entity.Route;
import model.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRouteDAO implements RouteDAO {
    private final int RECORDS_PER_PAGE = 10;
    private static final Logger LOGGER = LogManager.getLogger(MySQLRouteDAO.class);

    private static MySQLRouteDAO instance = new MySQLRouteDAO();

    static MySQLRouteDAO getInstance() {
        return instance;
    }

    @Override
    public Route createRoute(Route route) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO routes (departure_station, departure_time, destination_station, destination_time) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, route.getDepartureStation());
            preparedStatement.setString(2, route.getDepartureTime());
            preparedStatement.setString(3, route.getDestinationStation());
            preparedStatement.setString(4, route.getDestinationTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't create route";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return route;
    }

    @Override
    public void deleteRoute(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM routes WHERE routes.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't delete route";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
    }

    @Override
    public List<Route> getAllRoutes(int currentPage) {
        String query = paginate(currentPage);

        List<Route> routes = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String departureStation = resultSet.getString("departure_station");
                String departureTime = resultSet.getString("departure_time");
                String destinationStation = resultSet.getString("destination_station");
                String destinationTime = resultSet.getString("destination_time");
                Route route = new Route(departureStation, departureTime, destinationStation, destinationTime);
                route.setId(resultSet.getInt("id"));
                routes.add(route);
            }
        } catch (SQLException e) {
            String errorText = "can't get all routes";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return routes;
    }

    @Override
    public Route getRouteById(int id) {
        Route route = null;
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM routes WHERE routes.id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String departureStation = resultSet.getString("departure_station");
            String departureTime = resultSet.getString("departure_time");
            String destinationStation = resultSet.getString("destination_station");
            String destinationTime = resultSet.getString("destination_time");
            route = new Route(departureStation, departureTime, destinationStation, destinationTime);
        } catch (SQLException e) {
            String errorText = "can't get route by id";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return route;
    }

    @Override
    public List<Route> getRoutesFromDate(Date date, int currentPage) {
        String query = paginate(currentPage);
        query = query.substring(26);

        List<Route> routes = new ArrayList<>();
        Route route = null;
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM routes WHERE routes.departure_time > ? LIMIT" + query)) {
            preparedStatement.setDate(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String departureStation = resultSet.getString("departure_station");
                String departureTime = resultSet.getString("departure_time");
                String destinationStation = resultSet.getString("destination_station");
                String destinationTime = resultSet.getString("destination_time");
                route = new Route(departureStation, departureTime, destinationStation, destinationTime);
                route.setId(resultSet.getInt("id"));
                routes.add(route);
            }
        } catch (SQLException e) {
            String errorText = "can't get routes from date";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return routes;
    }

    @Override
    public List<Route> getRoutesByConcreteStations(String departureStation, String destinationStation) {
        List<Route> routes = new ArrayList<>();
        Route route = null;
        try(Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM routes WHERE routes.departure_station = ? AND routes.destination_station = ?")) {
            preparedStatement.setString(1, departureStation);
            preparedStatement.setString(2, destinationStation);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String departureTime = resultSet.getString("departure_time");
                String destinationTime = resultSet.getString("destination_time");
                route = new Route(departureStation, departureTime, destinationStation, destinationTime);
                route.setId(resultSet.getInt("id"));
                routes.add(route);
            }
        } catch (SQLException e) {
            String errorText = "can't get routes by concrete stations";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
        return routes;
    }

    private String paginate(int currentPage) {
        String query = "SELECT * FROM routes LIMIT ";
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