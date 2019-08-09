package controller.admin.train;

import controller.command.Command;
import model.entity.Train;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateTrainCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int routeId = Integer.parseInt(request.getParameter("routeId"));
        int berthNum = Integer.parseInt(request.getParameter("berthNum"));
        int coupeNum = Integer.parseInt(request.getParameter("coupeNum"));
        int deluxeNum = Integer.parseInt(request.getParameter("deluxeNum"));
        AdminService.getInstance().createTrain(new Train(routeId, berthNum, coupeNum, deluxeNum));
        return "controller?action=getAllTrains";
    }
}
