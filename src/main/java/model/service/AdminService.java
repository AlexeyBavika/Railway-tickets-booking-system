package model.service;

import model.dao.dao.AbstractDAOFactory;
import model.dao.dao.DAOFactory;
import model.dao.dao.Database;
import model.entity.*;

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

    public void updateUserRole(int userId, int roleId) {
        factory.createUserDAO().updateUserRole(userId, roleId);
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

    public void createPrice(Price price) {
        factory.createPriceDAO().createPrice(price);
    }

    public List<Price> getAllPrices() {
        return factory.createPriceDAO().getAllPrices();
    }

    public void deletePrice(int priceId) {
        factory.createPriceDAO().deletePrice(priceId);
    }

    public List<ChangeRoleRequest> getAllChangeRoleRequests() {
        return factory.createChangeRoleRequestDAO().getAllChangeRoleRequests();
    }

    public void deleteChangeRoleRequest(int id) {
        factory.createChangeRoleRequestDAO().deleteChangeRoleRequest(id);
    }
}
