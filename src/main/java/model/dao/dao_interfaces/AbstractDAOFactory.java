package model.dao.dao_interfaces;

import model.dao.mysql_dao_implementation.MySQLDAOFactory;

public abstract class AbstractDAOFactory {
    public static DAOFactory createDAOFactory(Database database) {
        DAOFactory daoFactory = null;

        switch(database) {
            case MYSQL :
                daoFactory = new MySQLDAOFactory();
        }

        /*
        if (daoFactory == null) throw new DatabaseNotFoundException;
         */

        return daoFactory;
    }
}
