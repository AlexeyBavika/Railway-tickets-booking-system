package controller.common_command;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    /**
     * closes session and returns main page
     * @param request
     * @param response
     * @return main page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("getId");
        session.removeAttribute("getName");
        session.removeAttribute("getSurname");
        session.removeAttribute("getEmail");
        session.removeAttribute("getPhone");
        session.removeAttribute("getRoleId");
        return "main.jsp";
    }
}
