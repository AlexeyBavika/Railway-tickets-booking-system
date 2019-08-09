package controller.common;

import controller.command.Command;
import model.entity.User;
import model.service.RegisterService;

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

        if(RegisterService.getInstance().checkIfExistsEmailOrPhone(email, phone)){
            User user = new User(name, surname, email, password, phone, 3);
            RegisterService.getInstance().addUser(user);
            return "login.jsp";
        } else {
            request.setAttribute("notAdd", "this email exists");
        }
        return "register.jsp";
    }
}
