package controller.common;

import controller.command.Command;
import model.entity.User;
import model.service.RegisterService;
import model.validation.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        if(checkValidation(name, surname, email, password, phone)) {
            if (RegisterService.getInstance().checkIfExistsEmailOrPhone(email, phone)) {
                User user = new User(name, surname, email, password, phone, 3);
                RegisterService.getInstance().addUser(user);
                return "login.jsp";
            } else {
                request.setAttribute("notAdd", "this email exists");
                return "register.jsp";
            }
        } else {
            request.setAttribute("notValidRegister", "you did use unacceptable symbols, please try again");
        }
        return "register.jsp";
    }

    private boolean checkValidation(String name, String surname, String email, String password, String phone) {
        return (Validator.isUANameValid(name) && Validator.isUANameValid(surname)) || (Validator.isRUNameValid(name) &&
                Validator.isRUNameValid(surname)) || (Validator.isENNameValid(name) && Validator.isENNameValid(surname))
                && Validator.isEmailValid(email) && Validator.isPasswordValid(password) && Validator.isPhoneValid(phone);
    }
}
