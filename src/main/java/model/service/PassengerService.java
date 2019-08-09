package model.service;

import model.dao.dao_interfaces.AbstractDAOFactory;
import model.dao.dao_interfaces.DAOFactory;
import model.dao.dao_interfaces.Database;
import model.entity.Price;
import model.entity.Route;
import model.entity.Train;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PassengerService {
    private static volatile PassengerService instance;
    private DAOFactory factory;

    private PassengerService() {
        factory = AbstractDAOFactory.createDAOFactory(Database.MYSQL);
    }

    public static PassengerService getInstance() {
        if (instance == null) {
            synchronized (PassengerService.class) {
                if (instance == null) {
                    instance = new PassengerService();
                }
            }
        }
        return instance;
    }

    public List<Route> getAvailableRoutes(Date date) {
        long time = date.getTime();
        return factory.createRouteDAO().getRoutesFromDate(new java.sql.Date(time));
    }

    public List<Route> getConcreteRoutes(String departureStation, String destinationStation) {
        return factory.createRouteDAO().getRoutesByConcreteStations(departureStation, destinationStation);
    }

    public List<Train> getAvailableTrains(int routeId) {
        return factory.createTrainDAO().getTrainsByRouteId(routeId);
    }

    public Price getAvailablePrice(int routeId) {
        return factory.createPriceDAO().getPriceByRouteId(routeId);
    }

}
