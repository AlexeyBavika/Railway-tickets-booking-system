package controller.passenger_command;

import controller.command.Command;
import model.entity.Route;
import model.service.PassengerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public class PassengerGetAllRoutes implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Route> routes = PassengerService.getInstance().getAvailableRoutes(new Date());
        HttpSession session = request.getSession();
        session.setAttribute("routes", routes);
        return "passenger_routes_page.jsp";
    }
}
