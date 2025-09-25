package fit.iuh.se.controllers;

import fit.iuh.se.daos.DienThoaiDAO;
import fit.iuh.se.daos.impl.DienThoaiDAOImpl;
import fit.iuh.se.entities.DienThoai;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuanLyFormServlet", urlPatterns = {"/quanLyForm"})
public class QuanLyFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl();
        List<DienThoai> dienThoais = dienThoaiDAO.findAll();
        req.setAttribute("dienThoais", dienThoais);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/QuanLyForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            String maDT = req.getParameter("maDT");
            if (maDT != null && !maDT.trim().isEmpty()) {
                try {
                    int id = Integer.parseInt(maDT);
                    DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl();
                    boolean success = dienThoaiDAO.removeDienThoaiByID(id);
                    if (!success) {
                        req.setAttribute("error", "Không thể xóa điện thoại với mã: " + id);
                    }
                } catch (NumberFormatException e) {
                    req.setAttribute("error", "Mã điện thoại không hợp lệ.");
                }
            } else {
                req.setAttribute("error", "Mã điện thoại không được để trống.");
            }
        }

        // Reload the list after deletion attempt
        DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl();
        List<DienThoai> dienThoais = dienThoaiDAO.findAll();
        req.setAttribute("dienThoais", dienThoais);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/QuanLyForm.jsp");
        dispatcher.forward(req, resp);
    }
}