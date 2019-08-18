package controller.passenger_command;

import controller.command.Command;
import model.entity.Order;
import model.service.PassengerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PassengerGetAllOrdersCommand implements Command {
    /**
     * return all passenger's tickets
     * @param request
     * @param response
     * @return tickets
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int passengerId = (int) session.getAttribute("getId");
        List<Order> orders = PassengerService.getInstance().getAllOrders(passengerId, getCurrentPage(request));
        request.setAttribute("passengerOrders", orders);
        return "passenger_orders_page.jsp";
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
