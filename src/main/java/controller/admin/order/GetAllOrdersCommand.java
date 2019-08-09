package controller.admin.order;

import controller.command.Command;
import model.entity.Order;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Order> orders = AdminService.getInstance().getAllOrders();
        request.setAttribute("orders", orders);
        return "admin_orders_page.jsp";
    }
}
