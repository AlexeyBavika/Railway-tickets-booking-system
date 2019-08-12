package model.dao.mysql_dao_implementation;

import model.dao.connection.ConnectionPool;
import model.dao.dao.TrainDAO;
import model.entity.Train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLTrainDAO implements TrainDAO {
    private static MySQLTrainDAO instance = new MySQLTrainDAO();

    static MySQLTrainDAO getInstance() {
        return instance;
    }

    @Override
    public Train createTrain(Train train) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO trains (route_id, berth_num, coupe_num, deluxe_num) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, train.getRouteId());
            preparedStatement.setInt(2, train.getBerthNum());
            preparedStatement.setInt(3, train.getCoupeNum());
            preparedStatement.setInt(4, train.getDeluxeNum());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
        return train;
    }

    @Override
    public void deleteTrain(int id) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM trains WHERE trains.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Train> getAllTrains() {
        List<Train> trains = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trains")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int routeId = resultSet.getInt("route_id");
                int berthNum = resultSet.getInt("berth_num");
                int coupeNum = resultSet.getInt("coupe_num");
                int deluxeNum = resultSet.getInt("deluxe_num");
                Train train = new Train(routeId, berthNum, coupeNum, deluxeNum);
                train.setId(resultSet.getInt("id"));
                trains.add(train);
            }
        } catch (SQLException e) {

        }
        return trains;
    }

    @Override
    public Train getTrainById(int id) {
        Train train = null;
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trains WHERE train.id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int routeId = resultSet.getInt("route_id");
            int berthNum = resultSet.getInt("berth_num");
            int coupeNum = resultSet.getInt("coupe_num");
            int deluxeNum = resultSet.getInt("deluxe_num");
            train = new Train(routeId, berthNum, coupeNum, deluxeNum);
        } catch (SQLException e) {

        }
        return train;
    }

    @Override
    public List<Train> getTrainsByRouteId(int routeId) {
        Train train = null;
        List<Train> trains = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trains WHERE trains.route_id = ?")) {
            preparedStatement.setInt(1, routeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idOfRoute = resultSet.getInt("route_id");
                int berthNum = resultSet.getInt("berth_num");
                int coupeNum = resultSet.getInt("coupe_num");
                int deluxeNum = resultSet.getInt("deluxe_num");
                train = new Train(idOfRoute, berthNum, coupeNum, deluxeNum);
                train.setId(resultSet.getInt("id"));
                trains.add(train);
            }
        } catch (SQLException e) {

        }
        return trains;
    }

    @Override
    public void updateTrainRoute(int trainId, int newRouteId) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE trains SET trains.route_id = ? WHERE trains.id = ?")) {
            preparedStatement.setInt(1, newRouteId);
            preparedStatement.setInt(2, trainId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void updateTrainPlaceNum(int trainId, int placeNum, String placeType) {
        try (Connection connection = ConnectionPool.getConnectionPoolInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(checkPlaceType(placeType))) {
            preparedStatement.setInt(1, placeNum);
            preparedStatement.setInt(2, trainId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String checkPlaceType(String placeType) {
        String placeTypeToChange = null;
        switch (placeType) {
            case "berth" :
                return placeTypeToChange = "UPDATE trains SET trains.berth_num = ? WHERE trains.id = ?";
            case "coupe" :
                return placeTypeToChange = "UPDATE trains SET trains.coupe_num = ? WHERE trains.id = ?";
            case "deluxe" :
                return placeTypeToChange = "UPDATE trains SET trains.deluxe_num = ? WHERE trains.id = ?";
        }
        return placeTypeToChange;
    }
}