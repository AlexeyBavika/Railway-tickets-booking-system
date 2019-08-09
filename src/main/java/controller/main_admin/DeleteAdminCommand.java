package controller.main_admin;

import controller.command.Command;
import model.service.AdminService;
import model.service.MainAdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAdminCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("adminToDelete"));
        MainAdminService.getInstance().deleteAdmin(id);
        return "controller?action=getAllAdmins";
    }
}
