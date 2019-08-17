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

    // This method has to be reworked :
    // It has to use MySQL queries to check if exists email and phone and after that return result
    // It will work a lot faster
    public boolean checkIfExistsEmailOrPhone(String emailToCheck, String phoneToCheck) {
        List<String> emails = factory.createUserDAO().getAllEmails();
        List<String> phones = factory.createUserDAO().getAllPhones();
        for (String email : emails) {
            if (email.equals(emailToCheck)) {
                return false;
            }
        }

        for (String phone : phones) {
            if (phone.equals(phoneToCheck)) {
                return false;
            }
        }

        return true;
    }

    public void addUser(User userToCreate) {
        factory.createUserDAO().createUser(userToCreate);
    }
}
