package model.entity;

import java.util.Objects;

public class Order {
    private int id;
    private int passengerId;
    private int trainId;
    private String placeType;
    private int price;

    public Order(int passengerId, int trainId, String placeType, int price) {
        this.passengerId = passengerId;
        this.trainId = trainId;
        this.placeType = placeType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType.toString();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                passengerId == order.passengerId &&
                trainId == order.trainId &&
                price == order.price &&
                placeType == order.placeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passengerId, trainId, placeType, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", passengerId=" + passengerId +
                ", trainId=" + trainId +
                ", placeType=" + placeType +
                ", price=" + price +
                '}';
    }
}
