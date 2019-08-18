package controller.admin_command.order;

import controller.command.Command;
import model.entity.Order;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllOrdersCommand implements Command {
    /**
     * gets all prices
     * @param request
     * @param response
     * @return list of prices
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Order> orders = AdminService.getInstance().getAllOrders(getCurrentPage(request));
        request.setAttribute("orders", orders);
        return "admin_orders_page.jsp";
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
