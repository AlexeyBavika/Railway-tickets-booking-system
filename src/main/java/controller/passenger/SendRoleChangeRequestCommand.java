package controller.passenger;

import controller.command.Command;
import model.service.PassengerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendRoleChangeRequestCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String text = request.getParameter("description");
        if(checkTextLength(text)) {
            HttpSession session = request.getSession();
            int passengerId = (int) session.getAttribute("getId");
            PassengerService.getInstance().createChangeRoleRequest(passengerId, text);
            session.setAttribute("RoleChangeRequestSend", text);
        } else {
            // TODO
        }
        return "passenger_main_page.jsp";
    }

    private boolean checkTextLength(String text) {
        if(text.length() <= 300) {
            return true;
        }
        return false;
    }
}
