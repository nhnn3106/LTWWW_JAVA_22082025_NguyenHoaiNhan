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

@WebServlet(name = "bai03", value = "/bai03")
public class bai03 extends HttpServlet {
    private User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        user = new User("Nhan", "1234567890", "nguyennhan@gmail.com");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();
        String userAsString = mapper.writeValueAsString(user);

        // Hello
        PrintWriter out = response.getWriter();
        out.println(userAsString);
    }

    public void destroy() {
    }
}