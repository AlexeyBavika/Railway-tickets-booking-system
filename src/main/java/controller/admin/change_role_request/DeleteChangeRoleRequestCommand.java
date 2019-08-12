package controller.admin.change_role_request;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteChangeRoleRequestCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("changeRoleRequestToDelete"));
        AdminService.getInstance().deleteChangeRoleRequest(id);
        return "controller?action=getAllChangeRoleRequests";
    }
}
