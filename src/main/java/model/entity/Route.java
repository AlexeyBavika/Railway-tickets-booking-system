package model.entity;

import java.util.Objects;

public class Route {
    private int id;
    private String departureStation;
    private String departureTime;
    private String destinationStation;
    private String destinationTime;

    public Route (String departureStation, String departureTime, String destinationStation, String destinationTime) {
        this.departureStation = departureStation;
        this.departureTime = departureTime;
        this.destinationStation = destinationStation;
        this.destinationTime = destinationTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public String getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id &&
                departureStation.equals(route.departureStation) &&
                departureTime.equals(route.departureTime) &&
                destinationStation.equals(route.destinationStation) &&
                destinationTime.equals(route.destinationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departureStation, departureTime, destinationStation, destinationTime);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", departureStation='" + departureStation + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                ", destinationTime='" + destinationTime + '\'' +
                '}';
    }
}
