package controller.passenger;

import controller.command.Command;
import model.entity.Price;
import model.entity.Train;
import model.service.PassengerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChooseTrainCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int routeId = Integer.parseInt(request.getParameter("id"));
        List<Train> trains = PassengerService.getInstance().getAvailableTrains(routeId);
        Price price = PassengerService.getInstance().getAvailablePrice(routeId);
        request.setAttribute("berthPrice", price.getBerthPrice());
        request.setAttribute("coupePrice", price.getCoupePrice());
        request.setAttribute("deluxePrice", price.getDeluxePrice());
        request.setAttribute("trains", trains);
        return "passenger_choose_train_page.jsp";
    }
}
