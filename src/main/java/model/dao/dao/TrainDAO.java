package model.dao.dao;

import model.entity.Train;

import java.util.List;

public interface TrainDAO {
    Train createTrain(Train train);
    void deleteTrain(int id);
    List<Train> getAllTrains();
    List<Train> getTrainsByRouteId(int routeId);
    void updateTrainPlaceNum(int trainId, int placeNum, String placeType);
}
