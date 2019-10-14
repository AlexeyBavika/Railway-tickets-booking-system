package controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();

        if (session.getAttribute("getRoleId") == null) {
            if (uri.equals("/controller") || uri.equals("/register.jsp")) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                requestDispatcher = ((HttpServletRequest) servletRequest).getRequestDispatcher("main.jsp");
                requestDispatcher.forward((HttpServletRequest) servletRequest, servletResponse);
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            if (((int) session.getAttribute("getRoleId") == 1) || ((int) session.getAttribute("getRoleId") == 2)) {
                if (uri.equals("/controller")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    requestDispatcher = ((HttpServletRequest) servletRequest).getRequestDispatcher("admin_main_page.jsp");
                    requestDispatcher.forward((HttpServletRequest) servletRequest, servletResponse);
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                if (uri.equals("/controller")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    requestDispatcher = ((HttpServletRequest) servletRequest).getRequestDispatcher("passenger_main_page.jsp");
                    requestDispatcher.forward((HttpServletRequest) servletRequest, servletResponse);
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }

    private void forwardAccessDenied(HttpServletRequest request, ServletResponse response) throws ServletException, IOException {
        String page = "/main.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }
}
