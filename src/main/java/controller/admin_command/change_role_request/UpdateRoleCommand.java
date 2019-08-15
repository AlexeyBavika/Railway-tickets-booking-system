package controller.admin_command.change_role_request;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateRoleCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int passengerId = Integer.parseInt(request.getParameter("passengerId"));
        int roleId = Integer.parseInt(request.getParameter("passengerNewRoleId"));
        AdminService.getInstance().updateUserRole(passengerId, roleId);
        return "admin_change_role_requests_page.jsp";
    }
}
