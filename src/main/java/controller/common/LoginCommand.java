package controller.common;

import controller.command.Command;
import model.entity.User;
import model.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String pageToRedirectUser = null;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LoginService.getInstance().loginUser(email, password);
        if (user == null) {
            request.setAttribute("notExists", "notExists");
            System.out.println("null");
            return "login.jsp";
        } else {
            pageToRedirectUser = LoginService.getInstance().checkRole(user, request);
        }
        return pageToRedirectUser;
    }
}
