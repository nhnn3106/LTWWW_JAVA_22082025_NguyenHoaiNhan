package iuh.fit.bai3.controllers;

import iuh.fit.bai3.daos.CategoryDAO;
import iuh.fit.bai3.daos.Impl.CategoryDAOImpl;
import iuh.fit.bai3.daos.Impl.NewsDAOImpl;
import iuh.fit.bai3.daos.NewsDAO;
import iuh.fit.bai3.entites.Category;
import iuh.fit.bai3.entites.News;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/news", "/news*"})
public class NewsController extends HttpServlet {
    private NewsDAO newsDAO;
    private CategoryDAO categoryDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "add": {
                Map<String, String> errors = validateForm(req);

                if (!errors.isEmpty()) {
                    req.setAttribute("errors", errors);

                    categoryDAO = new CategoryDAOImpl();
                    List<Category> categories = categoryDAO.getAll();
                    req.setAttribute("categories", categories);

                    req.setAttribute("page", "views/news/add.jsp");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);

                } else {
                    addNews(req);
                    List<News> newsList = newsDAO.getAll();
                    req.setAttribute("newsList", newsList);
                    req.setAttribute("page", "views/news/list-news.jsp");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
                break;
            }

            case "delete": {
                deleteNews(Integer.parseInt(req.getParameter("id")));
                newsDAO = new NewsDAOImpl();
                List<News> newsList = newsDAO.getAll();
                req.setAttribute("newsList", newsList);
                req.setAttribute("page", "views/news/management.jsp");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        String page;
        newsDAO = new NewsDAOImpl();
        List<News> newsList = newsDAO.getAll();
        req.setAttribute("newsList", newsList);

        if ("list".equals(action)) {
            page = "views/news/list-news.jsp";
        } else if ("add".equals(action)) {
            categoryDAO = new CategoryDAOImpl();
            List<Category> categories = categoryDAO.getAll();
            req.setAttribute("categories", categories);
            page = "views/news/add.jsp";
        } else if ("management".equals(action)) {
            page = "views/news/management.jsp";
        } else {
            page = "index.jsp";
        }

        req.setAttribute("page", page);
        req.getRequestDispatcher("index.jsp").forward(req, resp);


    }

    private Map<String, String> validateForm(HttpServletRequest req) {
        Map<String, String> errors = new HashMap<>();

        String category = req.getParameter("category");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String link = req.getParameter("link");

        if (title == null || title.trim().isEmpty()) {
            errors.put("title", "Tiêu đề không được để trống");
        }

        if (content == null || content.trim().isEmpty()) {
            errors.put("content", "Nội dung không được để trống");
        } else if (!content.matches("^.{1,255}$")) {
            errors.put("content", "Nội dung không được vượt quá 255 ký tự");
        }

        if (link == null || link.trim().isEmpty()) {
            errors.put("link", "Liên kết không được để trống");
        } else if (!link.matches("^https://.+$")) {
            errors.put("link", "Liên kết phải bắt đầu bằng http://");
        }

        if (category == null || category.trim().isEmpty()) {
            errors.put("category", "Bạn phải chọn loại tin tức");
        }

        return errors;
    }


    private void addNews(HttpServletRequest req) {
        int category = Integer.parseInt(req.getParameter("category"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String link = req.getParameter("link");

        News news = new News();
        news.setTitle(title);
        news.setContent(content);
        news.setLink(link);
        news.setCategory(categoryDAO.getCategoryById(category));

        newsDAO = new NewsDAOImpl();
        newsDAO.addNews(news);
    }

    private void deleteNews(int id) {
        newsDAO = new NewsDAOImpl();
        newsDAO.deleteNews(id);
    }
}
