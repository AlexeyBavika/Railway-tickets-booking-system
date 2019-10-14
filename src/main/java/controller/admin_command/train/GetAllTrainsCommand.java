package controller.admin_command.train;

import controller.command.Command;
import model.entity.Train;
import model.service.AdminService;
import model.service.PaginationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllTrainsCommand implements Command {
    /**
     * gets all trains
     * @param request
     * @param response
     * @return list of trains
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Train> trains = AdminService.getInstance()
                .getAllTrains(PaginationService.getInstance().getCurrentPage(request));
        request.setAttribute("trains", trains);
        return "admin_trains_page.jsp";
    }
}
