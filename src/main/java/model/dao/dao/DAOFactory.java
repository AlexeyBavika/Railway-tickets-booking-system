package model.dao.dao;

public interface DAOFactory {
    UserDAO createUserDAO();
    TrainDAO createTrainDAO();
    RouteDAO createRouteDAO();
    RoleDAO createRoleDAO();
    PriceDAO createPriceDAO();
    OrderDAO createOrderDAO();
    ChangeRoleRequestDAO createChangeRoleRequestDAO();
}
