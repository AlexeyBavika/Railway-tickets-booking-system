package model.dao.dao_interfaces;

import model.entity.Price;

import java.util.List;

public interface PriceDAO {
    Price createPrice(Price price);
    void deletePrice(int id);
    List<Price> getAllPrices();
    Price getPriceByRouteId(int routeId);
}
