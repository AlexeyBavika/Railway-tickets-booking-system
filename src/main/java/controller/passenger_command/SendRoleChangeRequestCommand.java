package controller.passenger_command;

import controller.command.Command;
import model.service.PassengerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendRoleChangeRequestCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String text = request.getParameter("description");
        HttpSession session = request.getSession();
        int passengerId = (int) session.getAttribute("getId");
        PassengerService.getInstance().createChangeRoleRequest(passengerId, text);
        request.setAttribute("RoleChangeRequestSend", text);
        return "passenger_main_page.jsp";
    }
}
