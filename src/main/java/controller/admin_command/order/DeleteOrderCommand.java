package controller.admin_command.order;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteOrderCommand implements Command {
    /**
     * removes order from database
     * @param request
     * @param response
     * @return list of orders
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int orderId = Integer.parseInt(request.getParameter("orderToDelete"));
        AdminService.getInstance().deleteOrder(orderId);
        return "controller?action=getAllOrders";
    }
}
