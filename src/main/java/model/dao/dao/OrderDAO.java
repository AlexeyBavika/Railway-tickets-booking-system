package model.dao.dao;

import model.entity.Order;

import java.util.List;

public interface OrderDAO {
    /**
     * creates order
     * @param passengerId
     * @param trainId
     * @param placeType
     * @param price
     */
    void createOrder(int passengerId, int trainId, String placeType, int price);

    /**
     * deletes order
     * @param id
     */
    void deleteOrder(int id);

    /**
     * gets all orders
     * @param currentPage
     * @return list of orders
     */
    List<Order> getAllOrders(int currentPage);

    /**
     * gets all orders by id
     * @param passengerId
     * @param currentPage
     * @return list of orders
     */
    List<Order> getAllOrdersById(int passengerId, int currentPage);
}
