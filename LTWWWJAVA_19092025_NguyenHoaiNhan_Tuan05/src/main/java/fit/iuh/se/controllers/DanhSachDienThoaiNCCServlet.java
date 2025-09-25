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

@WebServlet(name = "DanhSachDienThoaiNCCServletController", urlPatterns = {"/dienThoai", "/dienThoai*"})
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";

        switch (action) {
            default -> handdleshowList(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "";

        switch (action) {
            case "search" -> {
                handleShowListBykeyWord(req, resp);
            }
            default -> handdleshowList(req, resp);
        }
    }


    private void handdleshowList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl();
        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
        List<DienThoai> dienThoais = dienThoaiDAO.findAll();
        req.setAttribute("dienThoais", dienThoais);
        List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.findAll();
        req.setAttribute("nhaCungCaps", nhaCungCaps);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/DanhSachDienThoaiNCC.jsp");
        dispatcher.forward(req, resp);
    }

    private void handleShowListBykeyWord(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl();
        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();


        String keyword = req.getParameter("keyword");
        String value = req.getParameter("value");
        List<DienThoai> dienThoais = null;
        List<NhaCungCap> nhaCungCaps = null;
        switch (keyword) {
            case "ma" -> {
                dienThoais = dienThoaiDAO.findBySupplierID(Integer.parseInt(value));
                nhaCungCaps = nhaCungCapDAO.findByID(Integer.parseInt(value));
            }
            case "ten" -> {
                dienThoais = dienThoaiDAO.findBySupplierName(value);
                nhaCungCaps = nhaCungCapDAO.findByName(value);
            }
            case "dia-chi" -> {
                dienThoais = dienThoaiDAO.findBySupplierAddress(value);
                nhaCungCaps = nhaCungCapDAO.findByAddress(value);
            }
            case "sdt" -> {
                dienThoais = dienThoaiDAO.findBySupplierPhone(value);
                nhaCungCaps = nhaCungCapDAO.findByPhone(value);
            }
            default -> {
                dienThoais = dienThoaiDAO.findAll();
                nhaCungCaps = nhaCungCapDAO.findAll();
            }
        }


        req.setAttribute("dienThoais", dienThoais);
        req.setAttribute("nhaCungCaps", nhaCungCaps);
        req.setAttribute("keyword", keyword);
        req.setAttribute("value", value);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/DanhSachDienThoaiNCC.jsp");
        dispatcher.forward(req, resp);
    }
}
