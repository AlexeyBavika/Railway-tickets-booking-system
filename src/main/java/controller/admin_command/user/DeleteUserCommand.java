package controller.admin_command.user;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUserCommand implements Command {
    /**
     * removes user from database, admin can only remove passengers, main admin can remove passengers and admins
     * @param request
     * @param response
     * @return
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int userToDeleteId = Integer.parseInt(request.getParameter("userToDelete"));
        int userRoleId = Integer.parseInt(request.getParameter("userToDeleteRoleId"));
        int adminRole = (int) session.getAttribute("getRoleId");
        if(adminRole == 2) {
            if(userRoleId == 3) {
                AdminService.getInstance().deleteUser(userToDeleteId);
            } else {
                request.setAttribute("cantDeleteUser", "cant delete user coz no rights");
            }
        }

        if(adminRole == 1 && userToDeleteId != 1) {
            AdminService.getInstance().deleteUser(userToDeleteId);
        } else {
            request.setAttribute("cantDeleteUser", "cant delete user coz no rights");
        }

        return "controller?action=getAllUsers";
    }
}
