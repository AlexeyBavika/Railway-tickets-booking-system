package model.validation;


import model.service.ValidationService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isUANameValid(String firstName) {
        if (firstName == null){return false;}
        Pattern p = Pattern.compile(ValidationService.getInstance().getProperty("user.uaname"), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(firstName);
        return m.matches();
    }

    public static boolean isRUNameValid(String firstName) {
        if (firstName == null){return false;}
        Pattern p = Pattern.compile(ValidationService.getInstance().getProperty("user.runame"), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(firstName);
        return m.matches();
    }

    public static boolean isENNameValid(String firstName) {
        if (firstName == null){return false;}
        Pattern p = Pattern.compile(ValidationService.getInstance().getProperty("user.enname"), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(firstName);
        return m.matches();
    }

    public static boolean isPasswordValid(String password) {
        if (password == null){return false;}
        Pattern p = Pattern.compile(ValidationService.getInstance().getProperty("user.password"), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static boolean isEmailValid(String email) {
        if (email == null){return false;}
        Pattern p = Pattern.compile(ValidationService.getInstance().getProperty("user.email"), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isPhoneValid(String phone) {
        if (phone == null){return false;}
        Pattern p = Pattern.compile(ValidationService.getInstance().getProperty("user.phone"), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
