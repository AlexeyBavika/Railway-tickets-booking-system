package model.service;

import model.dao.dao_interfaces.AbstractDAOFactory;
import model.dao.dao_interfaces.DAOFactory;
import model.dao.dao_interfaces.Database;

public class UpdateService {
    private static volatile UpdateService instance;
    private DAOFactory factory;

    private UpdateService() {
        factory = AbstractDAOFactory.createDAOFactory(Database.MYSQL);
    }

    public static UpdateService getInstance() {
        if (instance == null) {
            synchronized (UpdateService.class) {
                if (instance == null) {
                    instance = new UpdateService();
                }
            }
        }
        return instance;
    }

    public void updateTrainPlaceNum(int trainId, int placeNum, String placeType) {
        factory.createTrainDAO().updateTrainPlaceNum(trainId, placeNum, placeType);
    }
}
