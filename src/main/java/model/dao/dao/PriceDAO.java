package model.dao.dao;

import model.entity.Price;

import java.util.List;

public interface PriceDAO {
    /**
     * creates price
     * @param price
     */
    void createPrice(Price price);

    /**
     * deletes price
     * @param id
     */
    void deletePrice(int id);

    /**
     * gets all prices
     * @param currentPage
     * @return list of prices
     */
    List<Price> getAllPrices(int currentPage);

    /**
     * gets price by id
     * @param routeId
     * @return price
     */
    Price getPriceByRouteId(int routeId);
}
