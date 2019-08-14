package model.service;

import java.util.ResourceBundle;

public class ValidationService {
    private static volatile ValidationService instance;
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("validation");
    private ValidationService() {

    }

    public static ValidationService getInstance() {
        if (instance == null) {
            synchronized (ValidationService.class) {
                if (instance == null) {
                    instance = new ValidationService();
                }
            }
        }
        return instance;
    }

    public static String getProperty(String key) {

        return resourceBundle.getString(key);
    }
}
