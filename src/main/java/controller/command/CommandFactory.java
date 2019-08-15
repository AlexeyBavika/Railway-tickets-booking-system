package controller.command;

import controller.admin_command.AdminBackToMainPageCommand;
import controller.admin_command.change_role_request.DeleteChangeRoleRequestCommand;
import controller.admin_command.change_role_request.GetAllChangeRoleRequestsCommand;
import controller.admin_command.change_role_request.UpdateRoleCommand;
import controller.admin_command.order.DeleteOrderCommand;
import controller.admin_command.order.GetAllOrdersCommand;
import controller.admin_command.price.CreatePriceCommand;
import controller.admin_command.price.DeletePriceCommand;
import controller.admin_command.price.GetAllPricesCommand;
import controller.admin_command.routes.CreateRouteCommand;
import controller.admin_command.routes.DeleteRouteCommand;
import controller.admin_command.routes.GetAllRoutesCommand;
import controller.admin_command.train.CreateTrainCommand;
import controller.admin_command.train.DeleteTrainCommand;
import controller.admin_command.train.GetAllTrainsCommand;
import controller.admin_command.user.DeleteUserCommand;
import controller.admin_command.user.GetAllUsersCommand;
import controller.common_command.*;
import controller.passenger_command.*;

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

        //passenger commands
        commands.put("passengerBackToMainPage", new PassengerBackToMainPageCommand());

        commands.put("passengerGetRoutes", new PassengerGetAllRoutes());
        commands.put("findRoute", new PassengerGetConcreteRoutesCommand());
        commands.put("chooseTrain", new ChooseTrainCommand());
        commands.put("makeOrder", new MakeOrderCommand());
        commands.put("passengerOrders", new PassengerGetAllOrdersCommand());

        commands.put("sendRoleChangeRequest", new SendRoleChangeRequestCommand());

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
        commands.put("deletePrice", new DeletePriceCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        return commands.get(request.getParameter("action"));
    }
}
