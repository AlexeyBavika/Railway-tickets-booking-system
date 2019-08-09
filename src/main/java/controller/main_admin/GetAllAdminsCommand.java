package controller.main_admin;

import controller.command.Command;
import model.entity.User;
import model.service.MainAdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllAdminsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> admins = MainAdminService.getInstance().getAllAdmins();
        request.setAttribute("admins", admins);
        return "main_admin_page.jsp";
    }
}
