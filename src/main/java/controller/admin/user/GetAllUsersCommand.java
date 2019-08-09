package controller.admin.user;

import controller.command.Command;
import model.entity.User;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllUsersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = AdminService.getInstance().getAllUsers();
        request.setAttribute("users", users);
        return "admin_users_page.jsp";
    }
}
