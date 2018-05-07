package by.it.academy.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFirstFilter implements Filter {

    private boolean isEnableLogging;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String paramValue =
                filterConfig.getInitParameter("enable_logging");
        if ("TRUE".equalsIgnoreCase(paramValue)) {
            isEnableLogging = true;
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        if (isEnableLogging) {
            String s = "Hello from MyFirstFilter "
                    + servletRequest.getRemoteAddr();
            System.out.println(s);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
