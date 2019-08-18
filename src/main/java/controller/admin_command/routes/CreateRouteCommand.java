package controller.admin_command.routes;

import controller.command.Command;
import model.entity.Route;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateRouteCommand implements Command {
    /**
     * creates route
     * @param request
     * @param response
     * @return list of routes
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String departureStation = request.getParameter("departureStation");
        String departureTime = request.getParameter("departureTime");
        String destinationStation = request.getParameter("destinationStation");
        String destinationTime = request.getParameter("destinationTime");
        AdminService.getInstance().createRoute(new Route(departureStation, departureTime, destinationStation, destinationTime));
        return "controller?action=getAllRoutes";
    }
}
