package controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LocalizationFilter implements Filter {
    private static final String LOCALE = "locale";
    private static final String BUNDLE = "bundle";
    private String defaultBundle;
    private String locale;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        locale = filterConfig.getInitParameter(LOCALE);
        defaultBundle = filterConfig.getInitParameter(BUNDLE);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String localeSession = (String) httpRequest.getSession().getAttribute(LOCALE);

        if(localeSession == null){
            httpRequest.getSession().setAttribute(LOCALE, locale);
        }

        httpRequest.getSession().setAttribute(BUNDLE, defaultBundle);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
