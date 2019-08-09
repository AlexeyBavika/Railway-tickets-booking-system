package model.entity;

import java.util.Objects;

public class Train {
    private int id;
    private int routeId;
    private int berthNum;
    private int coupeNum;
    private int deluxeNum;

    public Train(int routeId, int berthNum, int coupeNum, int deluxeNum) {
        this.routeId = routeId;
        this.berthNum = berthNum;
        this.coupeNum = coupeNum;
        this.deluxeNum = deluxeNum;
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

    public int getBerthNum() {
        return berthNum;
    }

    public void setBerthNum(int berthNum) {
        this.berthNum = berthNum;
    }

    public int getCoupeNum() {
        return coupeNum;
    }

    public void setCoupeNum(int coupeNum) {
        this.coupeNum = coupeNum;
    }

    public int getDeluxeNum() {
        return deluxeNum;
    }

    public void setDeluxeNum(int deluxeNum) {
        this.deluxeNum = deluxeNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return id == train.id &&
                routeId == train.routeId &&
                berthNum == train.berthNum &&
                coupeNum == train.coupeNum &&
                deluxeNum == train.deluxeNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId, berthNum, coupeNum, deluxeNum);
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", berthNum=" + berthNum +
                ", coupeNum=" + coupeNum +
                ", deluxeNum=" + deluxeNum +
                '}';
    }
}
