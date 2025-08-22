package iuh.fit.tuan01;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bai02", value = "/bai02", initParams = {
        @WebInitParam(name = "username", value = "Nhan")
})
public class bai02 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Username: " + this.getServletConfig().getInitParameter("username") + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}