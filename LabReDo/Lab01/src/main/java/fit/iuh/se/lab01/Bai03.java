package fit.iuh.se.lab01;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import fit.iuh.se.lab01.models.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bai03", value = "/bai03")
public class Bai03 extends HttpServlet {


    private User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        user = new User("nhan123", "12345678");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("application/json");

        System.out.println(user);
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(user);

        System.out.println(jsonString);
        PrintWriter writer = resp.getWriter();
        writer.println(jsonString);

        writer.flush();
    }
}
