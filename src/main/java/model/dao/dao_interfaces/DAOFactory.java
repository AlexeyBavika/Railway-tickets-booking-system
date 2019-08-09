package model.dao.dao_interfaces;

public interface DAOFactory {
    UserDAO createUserDAO();
    TrainDAO createTrainDAO();
    RouteDAO createRouteDAO();
    RoleDAO createRoleDAO();
    PriceDAO createPriceDAO();
    OrderDAO createOrderDAO();
}
