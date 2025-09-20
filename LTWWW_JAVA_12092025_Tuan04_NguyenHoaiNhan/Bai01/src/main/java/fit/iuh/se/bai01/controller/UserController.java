package fit.iuh.se.bai01.controller;

import fit.iuh.se.bai01.daos.UserDAO;
import fit.iuh.se.bai01.daos.impl.UserDAOImpl;
import fit.iuh.se.bai01.utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import fit.iuh.se.bai01.entities.User;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@WebServlet(name="userController", urlPatterns = {"/users", "/users*"})
public class UserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch(action) {
            case "insert":
                handleSignUp(req, resp);
                break;
            default:
                handleShowInfo(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch(action) {
            case "new":
                handleShowSignUpForm(req, resp);
                break;
            default:
                handleShowInfo(req, resp);
        }
    }

    private void handleShowInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            UserDAO userDAO = new UserDAOImpl(em);
            List<User> listUser = userDAO.findAll();
            req.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/user/list.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errors", "An error occurred: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/user/list.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void handleShowSignUpForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/user/registration-form.jsp");
        dispatcher.forward(req, resp);
    }

    private void handleSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            UserDAO userDAO = new UserDAOImpl(em);

            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String reEnterEmail = req.getParameter("re-enter-email");
            String password = req.getParameter("password");
            String gender = req.getParameter("gender");
            String monthStr = req.getParameter("month");
            String dayStr = req.getParameter("day");
            String yearStr = req.getParameter("year");

            // Validate date inputs
            if (monthStr == null || dayStr == null || yearStr == null || monthStr.isEmpty() || dayStr.isEmpty() || yearStr.isEmpty()) {
                req.setAttribute("errors", "Please select a valid date of birth.");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/registration-form.jsp");
                dispatcher.forward(req, resp);
                return;
            }

            int month = Integer.parseInt(monthStr);
            int day = Integer.parseInt(dayStr);
            int year = Integer.parseInt(yearStr);

            User user = new User(firstName, lastName, email, password, LocalDate.of(year, month, day), gender);
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<User>> violations = validator.validate(user);

            if (violations.isEmpty()) {
                userDAO.save(user);
                resp.sendRedirect("users");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                violations.forEach(violation -> {
                    stringBuilder.append(violation.getPropertyPath() + ": " + violation.getMessage() + "<br>");
                });
                req.setAttribute("user", user);
                req.setAttribute("errors", stringBuilder.toString());
                RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/registration-form.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errors", "Invalid date format. Please select a valid date.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/registration-form.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errors", "An error occurred: " + e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/registration-form.jsp");
            dispatcher.forward(req, resp);
        }
    }
}