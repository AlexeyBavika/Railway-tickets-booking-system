package controller.admin.price;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePriceCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("priceId"));
        AdminService.getInstance().deletePrice(id);
        return "controller?action=getAllPrices";
    }
}
