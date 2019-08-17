package model.service;

import model.dao.dao.AbstractDAOFactory;
import model.dao.dao.DAOFactory;
import model.dao.dao.Database;
import model.entity.*;

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

    public List<Route> getAvailableRoutes(Date date, int currentPage) {
        long time = date.getTime();
        return factory.createRouteDAO().getRoutesFromDate(new java.sql.Date(time), currentPage);
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

    public void createChangeRoleRequest(int passengerId, String text) {
        factory.createChangeRoleRequestDAO().createChangeRoleRequest(passengerId, text);
    }

    public List<Order> getAllOrders(int passengerId, int currentPage) {
        return factory.createOrderDAO().getAllOrdersById(passengerId, currentPage);
    }

}
