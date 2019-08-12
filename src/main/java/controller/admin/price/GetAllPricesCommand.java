package controller.admin.price;

import controller.command.Command;
import model.entity.Price;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllPricesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Price> prices = AdminService.getInstance().getAllPrices();
        request.setAttribute("prices", prices);
        return "admin_prices_page.jsp";
    }
}
