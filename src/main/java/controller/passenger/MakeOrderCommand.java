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

        HttpSession session = request.getSession();
        int passengerId = (int) session.getAttribute("getId");
        int price = Integer.parseInt(request.getParameter("price"));
        AdminService.getInstance().createOrder(passengerId, trainId, placeType, price);
        setSessionAttributes(session, trainId, placeType, placeNum, price);

        return "passenger_receipt_page.jsp";
    }

    private void setSessionAttributes(HttpSession session, int trainId, String placeType, int placeNum, int price) {
        session.setAttribute("trainId", trainId);
        session.setAttribute("placeType", placeType);
        session.setAttribute("placeNum", placeNum);
        session.setAttribute("price", price);
    }
}
