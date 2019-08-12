package model.dao.dao;

import model.entity.User;

import java.util.List;

public interface UserDAO {
    User createUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
    User findUserById(int id);
    void updateUserRole(int id, int roleId);
    List<String> getAllEmails();
    List<String> getAllPhones();
    int getUserRoleId(User user);
    User getUser(String email, String password);
    List<User> getAllAdmins();
}
