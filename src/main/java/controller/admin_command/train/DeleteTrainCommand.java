package controller.admin_command.train;

import controller.command.Command;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteTrainCommand implements Command {
    /**
     * removes train from database
     * @param request
     * @param response
     * @return list of trains
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("trainToDelete"));
        AdminService.getInstance().deleteTrain(id);
        return "controller?action=getAllTrains";
    }
}
