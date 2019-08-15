package controller.common_command;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String language = request.getParameter("language");
        HttpSession session = request.getSession();
        switch (language) {
            case "ua" :
                session.setAttribute("locale", "ua");
                break;
            case "ru" :
                session.setAttribute("locale", "ru");
                break;
            case "en" :
                session.setAttribute("locale", "en");
        }
        return "main.jsp";
    }
}
