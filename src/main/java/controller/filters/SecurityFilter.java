package controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialized...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        RequestDispatcher requestDispatcher;
//        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
//
//        if (session.getAttribute("getRoleId") == null) {
//            forwardAccessDenied((HttpServletRequest) servletRequest, servletResponse);
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroyed...");
    }

    private void forwardAccessDenied(HttpServletRequest request, ServletResponse response) throws ServletException, IOException {
        String page = "/main.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }
}
