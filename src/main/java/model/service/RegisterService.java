package model.service;

import model.dao.dao.AbstractDAOFactory;
import model.dao.dao.DAOFactory;
import model.dao.dao.Database;
import model.entity.User;

import java.util.List;

public class RegisterService {
    private static volatile RegisterService instance;
    private DAOFactory factory;

    private RegisterService() {
        factory = AbstractDAOFactory.createDAOFactory(Database.MYSQL);
    }

    public static RegisterService getInstance() {
        if (instance == null) {
            synchronized (RegisterService.class) {
                if (instance == null) {
                    instance = new RegisterService();
                }
            }
        }
        return instance;
    }

    public boolean checkIfExistsEmailOrPhone(String emailToCheck, String phoneToCheck) {
        return factory.createUserDAO().isEmailExistsAndPhoneExists(emailToCheck, phoneToCheck);
    }

    public void addUser(User userToCreate) {
        factory.createUserDAO().createUser(userToCreate);
    }
}
