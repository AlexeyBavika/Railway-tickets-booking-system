package model.dao.dao;

public interface DAOFactory {
    UserDAO createUserDAO();
    TrainDAO createTrainDAO();
    RouteDAO createRouteDAO();
    PriceDAO createPriceDAO();
    OrderDAO createOrderDAO();
    ChangeRoleRequestDAO createChangeRoleRequestDAO();
}
