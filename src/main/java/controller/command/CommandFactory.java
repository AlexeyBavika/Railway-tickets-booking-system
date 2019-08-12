package controller.command;

import controller.admin.AdminBackToMainPageCommand;
import controller.admin.change_role_request.DeleteChangeRoleRequestCommand;
import controller.admin.change_role_request.GetAllChangeRoleRequestsCommand;
import controller.admin.change_role_request.UpdateRoleCommand;
import controller.admin.order.DeleteOrderCommand;
import controller.admin.order.GetAllOrdersCommand;
import controller.admin.price.CreatePriceCommand;
import controller.admin.price.GetAllPricesCommand;
import controller.admin.routes.CreateRouteCommand;
import controller.admin.routes.DeleteRouteCommand;
import controller.admin.routes.GetAllRoutesCommand;
import controller.admin.train.CreateTrainCommand;
import controller.admin.train.DeleteTrainCommand;
import controller.admin.train.GetAllTrainsCommand;
import controller.admin.user.DeleteUserCommand;
import controller.admin.user.GetAllUsersCommand;
import controller.common.*;
import controller.main_admin.DeleteAdminCommand;
import controller.main_admin.GetAllAdminsCommand;
import controller.passenger.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory factory = null;
    private Map<String, Command> commands = new HashMap<>();

    private CommandFactory(){}

    public static CommandFactory getInstance() {
        if(factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    {
        // common commands
        commands.put("main", new MainCommand());
        commands.put("register", new RegisterCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("backToMainPage", new BackToMainPageCommand());
        commands.put("sendRoleChangeRequest", new SendRoleChangeRequestCommand());

        //passenger commands
        commands.put("passengerBackToMainPage", new PassengerBackToMainPageCommand());

        commands.put("passengerGetRoutes", new PassengerGetAllRoutes());
        commands.put("findRoute", new PassengerGetConcreteRoutesCommand());
        commands.put("chooseTrain", new ChooseTrainCommand());
        commands.put("makeOrder", new MakeOrderCommand());
        commands.put("passengerOrders", new PassengerGetAllOrdersCommand());

        //admin commands
        commands.put("adminBackToMainPage", new AdminBackToMainPageCommand());

        commands.put("getAllUsers", new GetAllUsersCommand());
        commands.put("deleteUser", new DeleteUserCommand());

        commands.put("createTrain", new CreateTrainCommand());
        commands.put("getAllTrains", new GetAllTrainsCommand());
        commands.put("deleteTrain", new DeleteTrainCommand());

        commands.put("createRoute", new CreateRouteCommand());
        commands.put("getAllRoutes", new GetAllRoutesCommand());
        commands.put("deleteRoute", new DeleteRouteCommand());

        commands.put("getAllOrders", new GetAllOrdersCommand());
        commands.put("deleteOrder", new DeleteOrderCommand());

        commands.put("getAllChangeRoleRequests", new GetAllChangeRoleRequestsCommand());
        commands.put("deleteChangeRoleRequest", new DeleteChangeRoleRequestCommand());
        commands.put("updateUserRole", new UpdateRoleCommand());

        commands.put("createPrice", new CreatePriceCommand());
        commands.put("getAllPrices", new GetAllPricesCommand());

        //main admin commands
        commands.put("getAllAdmins", new GetAllAdminsCommand());
        commands.put("deleteAdmin", new DeleteAdminCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        return commands.get(request.getParameter("action"));
    }
}
