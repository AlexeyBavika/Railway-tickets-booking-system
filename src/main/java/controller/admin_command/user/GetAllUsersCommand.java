package controller.admin_command.user;

import controller.command.Command;
import model.entity.User;
import model.service.AdminService;
import model.service.PaginationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllUsersCommand implements Command {
    /**
     * returns list of all users
     * @param request
     * @param response
     * @return
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = AdminService.getInstance()
                .getAllUsers(PaginationService.getInstance().getCurrentPage(request));
        request.setAttribute("users", users);
        return "admin_users_page.jsp";
    }
}
