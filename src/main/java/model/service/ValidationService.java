package model.service;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean isUANameValid(String firstName) {
        if (firstName == null){return false;}
        Pattern p = Pattern.compile(getProperty("user.uaname"));
        Matcher m = p.matcher(firstName);
        return m.matches();
    }

    public static boolean isRUNameValid(String firstName) {
        if (firstName == null){return false;}
        Pattern p = Pattern.compile(getProperty("user.runame"), Pattern.UNICODE_CASE);
        Matcher m = p.matcher(firstName);
        return m.matches();
    }

    public static boolean isENNameValid(String firstName) {
        if (firstName == null){return false;}
        Pattern p = Pattern.compile(getProperty("user.enname"));
        Matcher m = p.matcher(firstName);
        return m.matches();
    }

    public static boolean isPasswordValid(String password) {
        if (password == null){return false;}
        Pattern p = Pattern.compile(getProperty("user.password"), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static boolean isEmailValid(String email) {
        if (email == null){return false;}
        Pattern p = Pattern.compile(getProperty("user.email"));
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isPhoneValid(String phone) {
        if (phone == null){return false;}
        Pattern p = Pattern.compile(getProperty("user.phone"));
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    private static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
