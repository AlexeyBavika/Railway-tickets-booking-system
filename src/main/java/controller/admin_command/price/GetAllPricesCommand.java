package controller.admin_command.price;

import controller.command.Command;
import model.service.PaginationService;
import model.entity.Price;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllPricesCommand implements Command {
    /**
     * gets all prices
     * @param request
     * @param response
     * @return list of prices
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Price> prices = AdminService.getInstance()
                .getAllPrices(PaginationService.getInstance().getCurrentPage(request));
        request.setAttribute("prices", prices);
        return "admin_prices_page.jsp";
    }
}
