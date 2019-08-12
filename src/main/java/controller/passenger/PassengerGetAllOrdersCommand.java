package controller.passenger;

import controller.command.Command;
import model.entity.Order;
import model.service.PassengerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PassengerGetAllOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int passengerId = (int) session.getAttribute("getId");
        List<Order> orders = PassengerService.getInstance().getAllOrders(passengerId);
        request.setAttribute("passengerOrders", orders);
        return "passenger_orders_page.jsp";
    }
}
