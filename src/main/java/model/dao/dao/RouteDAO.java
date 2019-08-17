package model.dao.dao;

import model.entity.Route;

import java.sql.Date;
import java.util.List;

public interface RouteDAO {
    Route createRoute(Route route);
    void deleteRoute(int id);
    List<Route> getAllRoutes(int currentPage);
    Route getRouteById(int id);
    List<Route> getRoutesFromDate(Date date, int currentPage);
    List<Route> getRoutesByConcreteStations(String departureStation, String destinationStation);
}
