package model.service;

import model.dao.dao.AbstractDAOFactory;
import model.dao.dao.DAOFactory;
import model.dao.dao.Database;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginService {
    private static volatile LoginService instance;
    private DAOFactory factory;

    private LoginService() {
        factory = AbstractDAOFactory.createDAOFactory(Database.MYSQL);
    }

    public static LoginService getInstance() {
        if (instance == null) {
            synchronized (LoginService.class) {
                if (instance == null) {
                    instance = new LoginService();
                }
            }
        }
        return instance;
    }

    /**
     * checks if user with given email and password exists
     * @param email
     * @param password
     * @return user
     */
    public User loginUser(String email, String password) {
        return factory.createUserDAO().getUser(email, password);
    }

    /**
     * checks user role and after that returns page
     * @param user
     * @param request
     * @return main page of user
     */
    public String checkRole(User user, HttpServletRequest request) {
        String page = null;
        switch (factory.createUserDAO().getUserRoleId(user)) {
            case 1:
            case 2:
                page = "admin_main_page.jsp";
                break;
            case 3:
                page = "passenger_main_page.jsp";
                break;
        }
        HttpSession session = request.getSession();
        session.setAttribute("getId", user.getId());
        session.setAttribute("getName", user.getName());
        session.setAttribute("getSurname", user.getSurname());
        session.setAttribute("getEmail", user.getEmail());
        session.setAttribute("getPhone", user.getPhone());
        session.setAttribute("getRoleId", user.getRoleId());
        return page;
    }
}
