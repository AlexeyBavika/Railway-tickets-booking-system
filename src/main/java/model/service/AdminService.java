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

    public List<User> getAllUsers(int currentPage) {
        return factory.createUserDAO().getAllUsers(currentPage);
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

    public List<Train> getAllTrains(int currentPage) {
        return factory.createTrainDAO().getAllTrains(currentPage);
    }

    public void deleteTrain(int id) {
        factory.createTrainDAO().deleteTrain(id);
    }

    public void createRoute(Route route) {
        factory.createRouteDAO().createRoute(route);
    }

    public List<Route> getAllRoutes(int currentPage) {
        return factory.createRouteDAO().getAllRoutes(currentPage);
    }

    public void deleteRoute(int id) {
        factory.createRouteDAO().deleteRoute(id);
    }

    public void createOrder(int passengerId, int trainId, String placeType, int price) {
        factory.createOrderDAO().createOrder(passengerId, trainId, placeType, price);
    }

    public List<Order> getAllOrders(int currentPage) {
        return factory.createOrderDAO().getAllOrders(currentPage);
    }

    public void deleteOrder(int id) {
        factory.createOrderDAO().deleteOrder(id);
    }

    public void createPrice(Price price) {
        factory.createPriceDAO().createPrice(price);
    }

    public List<Price> getAllPrices(int currentPage) {
        return factory.createPriceDAO().getAllPrices(currentPage);
    }

    public void deletePrice(int priceId) {
        factory.createPriceDAO().deletePrice(priceId);
    }

    public List<ChangeRoleRequest> getAllChangeRoleRequests(int currentPage) {
        return factory.createChangeRoleRequestDAO().getAllChangeRoleRequests(currentPage);
    }

    public void deleteChangeRoleRequest(int id) {
        factory.createChangeRoleRequestDAO().deleteChangeRoleRequest(id);
    }
}
