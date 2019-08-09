package model.entity;

import java.util.Objects;

public class Price {
    private int id;
    private int routeId;
    private int berthPrice;
    private int coupePrice;
    private int deluxePrice;

    public Price(int routeId, int berthPrice, int coupePrice, int deluxePrice) {
        this.routeId = routeId;
        this.berthPrice = berthPrice;
        this.coupePrice = coupePrice;
        this.deluxePrice = deluxePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getBerthPrice() {
        return berthPrice;
    }

    public void setBerthPrice(int berthPrice) {
        this.berthPrice = berthPrice;
    }

    public int getCoupePrice() {
        return coupePrice;
    }

    public void setCoupePrice(int coupePrice) {
        this.coupePrice = coupePrice;
    }

    public int getDeluxePrice() {
        return deluxePrice;
    }

    public void setDeluxePrice(int deluxePrice) {
        this.deluxePrice = deluxePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return id == price.id &&
                routeId == price.routeId &&
                berthPrice == price.berthPrice &&
                coupePrice == price.coupePrice &&
                deluxePrice == price.deluxePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId, berthPrice, coupePrice, deluxePrice);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", berthPrice=" + berthPrice +
                ", coupePrice=" + coupePrice +
                ", deluxePrice=" + deluxePrice +
                '}';
    }
}
