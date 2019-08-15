package controller.admin_command.change_role_request;

import controller.command.Command;
import model.entity.ChangeRoleRequest;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllChangeRoleRequestsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<ChangeRoleRequest> changeRoleRequests = AdminService.getInstance().getAllChangeRoleRequests();
        request.setAttribute("changeRoleRequests", changeRoleRequests);
        return "admin_change_role_requests_page.jsp";
    }
}
