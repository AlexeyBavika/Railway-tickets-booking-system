package controller.common_command;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackToMainPageCommand implements Command {
    /**
     * back to main page
     * @param request
     * @param response
     * @return main page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "main.jsp";
    }
}
