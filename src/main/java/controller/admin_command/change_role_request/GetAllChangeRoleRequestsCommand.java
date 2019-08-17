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
        List<ChangeRoleRequest> changeRoleRequests = AdminService.getInstance().getAllChangeRoleRequests(getCurrentPage(request));
        request.setAttribute("changeRoleRequests", changeRoleRequests);
        return "admin_change_role_requests_page.jsp";
    }

    private int getCurrentPage(HttpServletRequest request) {
        String page = request.getParameter("page");
        int currentPage;

        if(page == null) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(page);
        }
        return currentPage;
    }
}
