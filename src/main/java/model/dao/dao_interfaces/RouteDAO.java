package model.dao.dao_interfaces;

import model.entity.Route;

import java.sql.Date;
import java.util.List;

public interface RouteDAO {
    Route createRoute(Route route);
    void deleteRoute(int id);
    List<Route> getAllRoutes();
    Route getRouteById(int id);
    List<Route> getRoutesFromDate(Date date);
    List<Route> getRoutesByConcreteStations(String departureStation, String destinationStation);
}
