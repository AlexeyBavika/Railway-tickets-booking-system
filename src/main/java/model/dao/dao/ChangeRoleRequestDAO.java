package model.dao.dao;

import model.entity.ChangeRoleRequest;

import java.util.List;

public interface ChangeRoleRequestDAO {
    /**
     * creates change role request
     * @param passengerId
     * @param text
     */
    void createChangeRoleRequest(int passengerId, String text);

    /**
     * gets all change role requests
     * @param currentPage
     * @return list of change role requests
     */
    List<ChangeRoleRequest> getAllChangeRoleRequests(int currentPage);

    /**
     * deletes change role request
     * @param id
     */
    void deleteChangeRoleRequest(int id);
}
