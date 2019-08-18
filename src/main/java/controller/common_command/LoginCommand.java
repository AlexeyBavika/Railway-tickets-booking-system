package controller.common_command;

import controller.command.Command;
import model.entity.User;
import model.exception.DAOException;
import model.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    /**
     * login user if email and password are correct
     * if not returns main page
     * @param request
     * @param response
     * @return
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String pageToRedirectUser = null;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LoginService.getInstance().loginUser(email, password);
        if (user == null) {
            request.setAttribute("wrongLoginOrPassword", "wrong login or password");
            return "main.jsp";
        } else {
            pageToRedirectUser = LoginService.getInstance().checkRole(user, request);
        }
        return pageToRedirectUser;
    }
}
