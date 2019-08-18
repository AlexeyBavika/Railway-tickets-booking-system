package controller.admin_command;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminBackToMainPageCommand implements Command {
    /**
     * returns admin main page
     * @param request
     * @param response
     * @return admin main page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "admin_main_page.jsp";
    }
}
