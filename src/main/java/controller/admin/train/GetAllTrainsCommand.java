package controller.admin.train;

import controller.command.Command;
import model.entity.Train;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllTrainsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Train> trains = AdminService.getInstance().getAllTrains();
        request.setAttribute("trains", trains);
        return "admin_trains_page.jsp";
    }
}
