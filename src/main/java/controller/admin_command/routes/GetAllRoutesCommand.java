package controller.admin_command.routes;

import controller.command.Command;
import model.entity.Route;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllRoutesCommand implements Command {
    /**
     * gets all routes
     * @param request
     * @param response
     * @return list of routes
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Route> routes = AdminService.getInstance().getAllRoutes(getCurrentPage(request));
        request.setAttribute("routes", routes);
        return "admin_routes_page.jsp";
    }

    private int getCurrentPage(HttpServletRequest request) {
        String page = request.getParameter("page");
        int currentPage;

        if(page == null) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(page);
        }
        return currentPage;
    }
}
