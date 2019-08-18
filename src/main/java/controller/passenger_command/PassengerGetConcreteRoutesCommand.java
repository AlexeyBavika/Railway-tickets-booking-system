package controller.passenger_command;

import controller.command.Command;
import model.entity.Route;
import model.service.PassengerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PassengerGetConcreteRoutesCommand implements Command {
    /**
     * returns routes that passenger chooses
     * @param request
     * @param response
     * @return routes
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String departureStation = request.getParameter("departureStation");
        String destinationStation = request.getParameter("destinationStation");
        List<Route> routes = PassengerService.getInstance().getConcreteRoutes(departureStation, destinationStation);
        request.setAttribute("concreteRoutes", routes);
        return "passenger_routes_page.jsp";
    }
}
