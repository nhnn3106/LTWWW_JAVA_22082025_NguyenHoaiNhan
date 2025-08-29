package iuh.fit.se.bai01;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



public class AuthenticationFilter extends HttpFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        String usernameConfig = this.getInitParameter("username");
        String passwordConfig = this.getInitParameter("password");

        System.out.println(usernameConfig);

        if(username.equals(usernameConfig) && password.equals(passwordConfig)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

}
