package controller.passenger;

import controller.command.Command;
import model.entity.User;
import model.service.AdminService;
import model.service.UpdateService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MakeOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int trainId = Integer.parseInt(request.getParameter("trainId"));
        int placeNum = Integer.parseInt(request.getParameter("placeNum")) - 1;
        String placeType = request.getParameter("placeType");
        UpdateService.getInstance().updateTrainPlaceNum(trainId, placeNum, placeType);
        int passengerId = getPassengerData(request);
        int price = Integer.parseInt(request.getParameter("price"));
        AdminService.getInstance().createOrder(passengerId, trainId, placeType, price);
        return "passenger_receipt_page.jsp";
    }

    private int getPassengerData(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        session.setAttribute("ticketId", user.hashCode() * 7);
        session.setAttribute("getName", user.getName());
        session.setAttribute("getSurname", user.getSurname());
        session.setAttribute("getEmail", user.getEmail());
        session.setAttribute("getPhone", user.getPhone());
        return user.getId();
    }
}
