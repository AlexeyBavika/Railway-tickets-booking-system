package model.dao.dao;

import model.entity.Price;

import java.util.List;

public interface PriceDAO {
    void createPrice(Price price);
    void deletePrice(int id);
    List<Price> getAllPrices();
    Price getPriceByRouteId(int routeId);
}
