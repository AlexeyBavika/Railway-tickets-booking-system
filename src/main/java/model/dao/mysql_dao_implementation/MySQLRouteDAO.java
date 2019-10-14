package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao.RouteDAO;
import model.entity.Route;
import model.exception.DAOException;
import model.service.PaginationService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRouteDAO implements RouteDAO {
    private static final Logger LOGGER = LogManager.getLogger(MySQLRouteDAO.class);

    private static MySQLRouteDAO instance = new MySQLRouteDAO();

    static MySQLRouteDAO getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Route createRoute(Route route) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.CREATE_ROUTE)) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteRoute(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.DELETE_ROUTE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String errorText = "can't delete route";
            LOGGER.error(errorText);
            throw new DAOException(errorText, e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Route> getAllRoutes(int currentPage) {
        String query = PaginationService.getInstance().paginate(currentPage, "routes");

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

    /**
     * {@inheritDoc}
     */
    @Override
    public Route getRouteById(int id) {
        Route route = null;
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_ROUTE_BY_ID)) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Route> getRoutesFromDate(Date date, int currentPage) {
        String query = PaginationService.getInstance().paginate(currentPage, "routes");
        query = query.substring(26);

        List<Route> routes = new ArrayList<>();
        Route route = null;
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_ROUTES_FROM_DATE + query)) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Route> getRoutesByConcreteStations(String departureStation, String destinationStation) {
        List<Route> routes = new ArrayList<>();
        Route route = null;
        try(Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_ROUTES_FROM_CONCRETE_STATION)) {
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
}