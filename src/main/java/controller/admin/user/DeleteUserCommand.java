package controller.admin.user;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("userToDelete"));
        AdminService.getInstance().deleteUser(id);
        return "controller?action=getAllUsers";
    }
}
