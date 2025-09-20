package fit.iuh.se.controllers;

import fit.iuh.se.daos.DienThoaiDAO;
import fit.iuh.se.daos.NhaCungCapDAO;
import fit.iuh.se.daos.impl.DienThoaiDAOImpl;
import fit.iuh.se.daos.impl.NhaCungCapDAOImpl;
import fit.iuh.se.entities.DienThoai;
import fit.iuh.se.entities.NhaCungCap;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "mobilesController", urlPatterns = {"/mobiles", "/mobiles*"})
public class MobilesController extends HttpServlet {
    DienThoaiDAO dao = new DienThoaiDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch(action) {
            default:
                handleShowMobiles(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch(action) {
            case "search":
                handleShowMobilesByName(req, resp);
            default:
                handleShowMobiles(req, resp);
        }
    }

    private void handleShowMobilesByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            List<DienThoai> result = dao.findAllBySupplierName(name);
            System.out.println(name);
            System.out.println(result);
            req.setAttribute("dienThoais", result);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/mobiles.jsp");
            dispatcher.forward(req, resp);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }



    private void handleShowMobiles(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<DienThoai> result =  dao.findAll();
            System.out.println(result);
            req.setAttribute("dienThoais", result);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/mobiles.jsp");
            dispatcher.forward(req, resp);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
