package model.dao.dao;

import model.entity.ChangeRoleRequest;

import java.util.List;

public interface ChangeRoleRequestDAO {
    void createChangeRoleRequest(int passengerId, String text);
    List<ChangeRoleRequest> getAllChangeRoleRequests(int currentPage);
    void deleteChangeRoleRequest(int id);
}
