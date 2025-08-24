package iuh.fit.se.tuan01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Register", value = "/register")
public class bai05 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String facebook = req.getParameter("facebook");
        String shortBio = req.getParameter("shortBio");

        resp.getWriter().println("<h2>Thông tin đăng ký</h2>");
        resp.getWriter().println("Họ tên: " + firstName + " " + lastName + "<br>");
        resp.getWriter().println("Username: " + username + "<br>");
        resp.getWriter().println("Email: " + email + "<br>");
        resp.getWriter().println("Facebook: " + facebook + "<br>");
        resp.getWriter().println("Bio: " + shortBio + "<br>");
    }
}