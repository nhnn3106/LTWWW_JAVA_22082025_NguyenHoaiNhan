package fit.iuh.se.controllers;

import fit.iuh.se.daos.NhaCungCapDAO;
import fit.iuh.se.daos.impl.NhaCungCapDAOImpl;
import fit.iuh.se.entities.NhaCungCap;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "suppliersController", urlPatterns = {"/suppliers"})
public class SuppliersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";
        switch(action) {
            default:
                handleShowSuppliers(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void handleShowSuppliers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            NhaCungCapDAO dao = new NhaCungCapDAOImpl();
            List<NhaCungCap> result =  dao.findAll();
            req.setAttribute("result", result);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/suppliers.jsp");
            dispatcher.forward(req, resp);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
