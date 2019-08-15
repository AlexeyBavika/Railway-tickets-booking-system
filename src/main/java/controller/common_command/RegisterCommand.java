package controller.common_command;

import controller.command.Command;
import model.entity.User;
import model.service.RegisterService;
import model.service.ValidationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                return "main.jsp";
            } else {
                request.setAttribute("notAdd", "this email or phone exists");
                return "register.jsp";
            }
        } else {
            request.setAttribute("notValidRegister", "You wrote something wrong. Please check it with examples");
        }
        return "register.jsp";
    }

    private boolean checkValidation(String name, String surname, String email, String password, String phone) {
        return (ValidationService.getInstance().isUANameValid(name) && ValidationService.getInstance().isUANameValid(surname))
                || (ValidationService.getInstance().isRUNameValid(name) && ValidationService.getInstance().isRUNameValid(surname))
                || (ValidationService.getInstance().isENNameValid(name) && ValidationService.getInstance().isENNameValid(surname))
                && ValidationService.getInstance().isEmailValid(email) && ValidationService.getInstance().isPasswordValid(password)
                && ValidationService.getInstance().isPhoneValid(phone);
    }
}
