package model.dao.dao;

import model.entity.Train;

import java.util.List;

public interface TrainDAO {
    /**
     * creates train
     * @param train
     * @return created train
     */
    Train createTrain(Train train);

    /**
     * deletes train from database
     * @param id
     */
    void deleteTrain(int id);

    /**
     * gets all trains to current page
     * @param currentPage
     * @return trains
     */
    List<Train> getAllTrains(int currentPage);

    /**
     * gets all trains with given role id
     * @param routeId
     * @return
     */
    List<Train> getTrainsByRouteId(int routeId);

    /**
     * updates train place num
     * @param trainId
     * @param placeNum
     * @param placeType
     */
    void updateTrainPlaceNum(int trainId, int placeNum, String placeType);
}
