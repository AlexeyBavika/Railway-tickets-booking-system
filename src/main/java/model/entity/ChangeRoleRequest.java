package model.entity;

import java.util.Objects;

public class ChangeRoleRequest {
    private int id;
    private int passengerId;
    private String text;

    public ChangeRoleRequest(int passengerId, String text) {
        this.passengerId = passengerId;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeRoleRequest that = (ChangeRoleRequest) o;
        return passengerId == that.passengerId &&
                text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, text);
    }

    @Override
    public String toString() {
        return "ChangeRoleRequest{" +
                "passengerId=" + passengerId +
                ", text='" + text + '\'' +
                '}';
    }
}
