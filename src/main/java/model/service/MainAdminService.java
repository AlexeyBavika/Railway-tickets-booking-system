package model.service;

import model.dao.dao_interfaces.AbstractDAOFactory;
import model.dao.dao_interfaces.DAOFactory;
import model.dao.dao_interfaces.Database;
import model.entity.User;

import java.util.List;

public class MainAdminService {
    private static volatile MainAdminService instance;
    private DAOFactory factory;

    private MainAdminService() {
        factory = AbstractDAOFactory.createDAOFactory(Database.MYSQL);
    }

    public static MainAdminService getInstance() {
        if (instance == null) {
            synchronized (MainAdminService.class) {
                if (instance == null) {
                    instance = new MainAdminService();
                }
            }
        }
        return instance;
    }

    public List<User> getAllAdmins() {
        return factory.createUserDAO().getAllAdmins();
    }

    public void deleteAdmin(int id) {
        factory.createUserDAO().deleteUser(id);
    }
}
