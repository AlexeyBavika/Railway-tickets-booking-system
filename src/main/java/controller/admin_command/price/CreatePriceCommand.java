package controller.admin_command.price;

import controller.command.Command;
import model.entity.Price;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreatePriceCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int routeId = Integer.parseInt(request.getParameter("routeId"));
        int berthPrice = Integer.parseInt(request.getParameter("berthPrice"));
        int coupePrice = Integer.parseInt(request.getParameter("coupePrice"));
        int deluxePrice = Integer.parseInt(request.getParameter("deluxePrice"));
        AdminService.getInstance().createPrice(new Price(routeId, berthPrice, coupePrice, deluxePrice));
        return "controller?action=getAllPrices";
    }
}
