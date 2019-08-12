package controller.admin.routes;

import controller.command.Command;
import model.entity.Route;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllRoutesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Route> routes = AdminService.getInstance().getAllRoutes();
        request.setAttribute("routes", routes);
        return "admin_routes_page.jsp";
    }
}