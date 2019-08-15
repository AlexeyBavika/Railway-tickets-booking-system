package controller.admin_command.routes;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteRouteCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("routeToDelete"));
        AdminService.getInstance().deleteRoute(id);
        return "controller?action=getAllRoutes";
    }
}
