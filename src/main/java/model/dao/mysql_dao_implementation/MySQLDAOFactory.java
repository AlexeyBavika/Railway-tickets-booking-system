package model.dao.mysql_dao_implementation;

import model.dao.dao_interfaces.*;

public class MySQLDAOFactory implements DAOFactory {
    @Override
    public UserDAO createUserDAO() {
        return MySQLUserDAO.getInstance();
    }

    @Override
    public TrainDAO createTrainDAO() {
        return MySQLTrainDAO.getInstance();
    }

    @Override
    public RouteDAO createRouteDAO() {
        return MySQLRouteDAO.getInstance();
    }

    @Override
    public RoleDAO createRoleDAO() {
        return MySQLRoleDAO.getInstance();
    }

    @Override
    public PriceDAO createPriceDAO() {
        return MySQLPriceDAO.getInstance();
    }

    @Override
    public OrderDAO createOrderDAO() {
        return MySQLOrderDAO.getInstance();
    }
}
