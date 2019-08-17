package controller.admin_command.user;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("userToDelete"));
        int userRoleId = Integer.parseInt(request.getParameter("userToDeleteRoleId"));
        int adminRole = (int) session.getAttribute("getRoleId");
        if(adminRole == 2) {
            if(userRoleId == 3) {
                AdminService.getInstance().deleteUser(id);
            } else {
                request.setAttribute("cantDeleteUser", "cant delete user coz no rights");
            }
        } else {
            AdminService.getInstance().deleteUser(id);
        }
        return "controller?action=getAllUsers";
    }
}
