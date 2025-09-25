package fit.iuh.se.controllers;

import fit.iuh.se.daos.DienThoaiDAO;
import fit.iuh.se.daos.NhaCungCapDAO;
import fit.iuh.se.daos.impl.DienThoaiDAOImpl;
import fit.iuh.se.daos.impl.NhaCungCapDAOImpl;
import fit.iuh.se.entities.DienThoai;
import fit.iuh.se.entities.NhaCungCap;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet(name = "DienThoaiFormServlet", urlPatterns = {"/dienThoaiForm"})
@MultipartConfig
public class DienThoaiFormServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "images";
    private static final Pattern YEAR_PATTERN = Pattern.compile("^\\d{4}$");
    private static final Pattern CONFIG_PATTERN = Pattern.compile("^.{1,255}$");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
        List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.findAll();
        req.setAttribute("nhaCungCaps", nhaCungCaps);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/DienThoaiForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get form parameters
        String ten = req.getParameter("ten");
        String namSx = req.getParameter("nam-sx");
        String cauHinh = req.getParameter("cau-hinh");
        String maNcc = req.getParameter("mancc");
        Part filePart = req.getPart("hinh-anh");

        // Validation
        StringBuilder errors = new StringBuilder();
        if (ten == null || ten.trim().isEmpty()) {
            errors.append("Tên điện thoại là bắt buộc.<br>");
        }
        if (namSx == null || !YEAR_PATTERN.matcher(namSx).matches()) {
            errors.append("Năm sản xuất phải là số nguyên 4 chữ số.<br>");
        }
        if (cauHinh == null || !CONFIG_PATTERN.matcher(cauHinh).matches()) {
            errors.append("Cấu hình là bắt buộc và không quá 255 ký tự.<br>");
        }
        if (maNcc == null || maNcc.trim().isEmpty()) {
            errors.append("Nhà cung cấp là bắt buộc.<br>");
        }

        // Validate image file
        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            fileName = extractFileName(filePart);
            String fileExtension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            if (!fileExtension.matches("\\.(png|jpg|jpeg)$")) {
                errors.append("Hình ảnh phải có định dạng .png, .jpg hoặc .jpeg.<br>");
            }
        } else {
            errors.append("Hình ảnh là bắt buộc.<br>");
        }

        // If there are validation errors, return to form with errors
        if (errors.length() > 0) {
            NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
            List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.findAll();
            req.setAttribute("nhaCungCaps", nhaCungCaps);
            req.setAttribute("errors", errors.toString());
            req.setAttribute("ten", ten);
            req.setAttribute("namSx", namSx);
            req.setAttribute("cauHinh", cauHinh);
            req.setAttribute("maNcc", maNcc);
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/DienThoaiForm.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        // Save image to /src/main/webapp/images
        String applicationPath = req.getServletContext().getRealPath("");
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        // Create and save DienThoai entity
        DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl();
        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
        List<NhaCungCap> nhaCungCap = nhaCungCapDAO.findByID(Integer.parseInt(maNcc));
        DienThoai dienThoai = new DienThoai();
        dienThoai.setTenDT(ten);
        dienThoai.setNamSanXuat(Integer.parseInt(namSx));
        dienThoai.setCauHinh(cauHinh);
        dienThoai.setHinhAnh(fileName);
        dienThoai.setNhaCungCap(nhaCungCap.getFirst());

        boolean success = dienThoaiDAO.addDienThoai(dienThoai);
        if (success) {
            resp.sendRedirect(req.getContextPath() + "/dienThoai");
        } else {
            req.setAttribute("errors", "Lỗi khi thêm điện thoại vào cơ sở dữ liệu.");
            NhaCungCapDAO nhaCungCapDAO2 = new NhaCungCapDAOImpl();
            List<NhaCungCap> nhaCungCaps = nhaCungCapDAO2.findAll();
            req.setAttribute("nhaCungCaps", nhaCungCaps);
            req.setAttribute("ten", ten);
            req.setAttribute("namSx", namSx);
            req.setAttribute("cauHinh", cauHinh);
            req.setAttribute("maNcc", maNcc);
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/DienThoaiForm.jsp");
            dispatcher.forward(req, resp);
        }
    }

    // Helper method to extract file name from Part
    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}