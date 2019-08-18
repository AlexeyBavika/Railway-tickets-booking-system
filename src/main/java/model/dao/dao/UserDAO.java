package model.dao.dao;

import model.entity.User;

import java.util.List;

public interface UserDAO {
    /**
     * method for creating user
     * @param user
     * @return nothing, should be void
     */
    User createUser(User user);

    /**
     * delete user from database by id
     * @param id
     */
    void deleteUser(int id);

    /**
     * gets all users from database to current page
     * @param currentPage
     * @return all users
     */
    List<User> getAllUsers(int currentPage);

    /**
     * updates user role by id
     * @param id
     * @param roleId
     */
    void updateUserRole(int id, int roleId);

    /**
     * gets all emails
     * @return all emails
     */
    List<String> getAllEmails();

    /**
     * gets all phones
     * @return all phones
     */
    List<String> getAllPhones();

    /**
     * gets user role id
     * @param user
     * @return user role id
     */
    int getUserRoleId(User user);

    /**
     * check if user with email and password exists
     * @param email
     * @param password
     * @return
     */
    User getUser(String email, String password);
}
