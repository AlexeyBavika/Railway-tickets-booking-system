package model.dao.dao;

import model.entity.Order;

import java.util.List;

public interface OrderDAO {
    void createOrder(int passengerId, int trainId, String placeType, int price);
    void deleteOrder(int id);
    List<Order> getAllOrders();
    List<Order> getAllOrdersById(int passengerId);
}
