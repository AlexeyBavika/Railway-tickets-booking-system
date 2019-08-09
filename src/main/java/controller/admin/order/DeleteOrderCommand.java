package controller.admin.order;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int orderId = Integer.parseInt(request.getParameter("orderToDelete"));
        AdminService.getInstance().deleteOrder(orderId);
        return "controller?action=getAllOrders";
    }
}
