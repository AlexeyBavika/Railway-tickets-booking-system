package model.dao.dao;

import model.entity.Route;

import java.sql.Date;
import java.util.List;

public interface RouteDAO {
    /**
     * creates route
     * @param route
     * @return route
     */
    Route createRoute(Route route);

    /**
     * deletes route from database
     * @param id
     */
    void deleteRoute(int id);

    /**
     * gets all routes
     * @param currentPage
     * @return list of routes
     */
    List<Route> getAllRoutes(int currentPage);
    Route getRouteById(int id);

    /**
     * gets all routes from current date
     * @param date
     * @param currentPage
     * @return list of routes
     */
    List<Route> getRoutesFromDate(Date date, int currentPage);

    /**
     * gets all routes by given stations
     * @param departureStation
     * @param destinationStation
     * @return list of routes
     */
    List<Route> getRoutesByConcreteStations(String departureStation, String destinationStation);
}
