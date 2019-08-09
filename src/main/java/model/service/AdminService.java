package model.service;

import model.dao.dao_interfaces.AbstractDAOFactory;
import model.dao.dao_interfaces.DAOFactory;
import model.dao.dao_interfaces.Database;
import model.entity.Order;
import model.entity.Route;
import model.entity.Train;
import model.entity.User;

import java.util.List;

public class AdminService {
    private static volatile AdminService instance;
    private DAOFactory factory;

    private AdminService() {
        factory = AbstractDAOFactory.createDAOFactory(Database.MYSQL);
    }

    public static AdminService getInstance() {
        if (instance == null) {
            synchronized (AdminService.class) {
                if (instance == null) {
                    instance = new AdminService();
                }
            }
        }
        return instance;
    }

    public List<User> getAllUsers() {
        return factory.createUserDAO().getAllUsers();
    }

    public void deleteUser(int id) {
        factory.createUserDAO().deleteUser(id);
    }

    public void createTrain(Train train) {
        factory.createTrainDAO().createTrain(train);
    }

    public List<Train> getAllTrains() {
        return factory.createTrainDAO().getAllTrains();
    }

    public void deleteTrain(int id) {
        factory.createTrainDAO().deleteTrain(id);
    }

    public void createRoute(Route route) {
        factory.createRouteDAO().createRoute(route);
    }

    public List<Route> getAllRoutes() {
        return factory.createRouteDAO().getAllRoutes();
    }

    public void deleteRoute(int id) {
        factory.createRouteDAO().deleteRoute(id);
    }

    public void createOrder(int passengerId, int trainId, String placeType, int price) {
        factory.createOrderDAO().createOrder(passengerId, trainId, placeType, price);
    }

    public List<Order> getAllOrders() {
        return factory.createOrderDAO().getAllOrders();
    }

    public void deleteOrder(int id) {
        factory.createOrderDAO().deleteOrder(id);
    }
}
