package iuh.fit.tuan01;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bai04", value = "/bai04", initParams = {
        @WebInitParam(name = "product-name", value = "laptop")
})
public class bai04 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Product name: " + this.getServletConfig().getInitParameter("product-name")+ "</h1>");
        out.println("<h1> OS: " + this.getServletContext().getInitParameter("operating system")+ "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Post information</h1>");
        out.println("<p>First name: " + firstName + "</p>");
        out.println("<p>Last name: " + lastName + "</p>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}