package controller.admin_command.user;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("userToDelete"));
        int userRoleId = Integer.parseInt(request.getParameter("userToDeleteRoleId"));
        if(userRoleId == 3) {
            AdminService.getInstance().deleteUser(id);
        } else {
            request.setAttribute("cantDeleteUser", "can't delete user");
        }
        return "controller?action=getAllUsers";
    }
}
