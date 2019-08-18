package controller.passenger_command;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PassengerBackToMainPageCommand implements Command {
    /**
     * backs to passenger main page
     * @param request
     * @param response
     * @return passenger main page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "passenger_main_page.jsp";
    }
}
