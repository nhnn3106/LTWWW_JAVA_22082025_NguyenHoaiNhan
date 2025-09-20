package iuh.fit.bai3.daos;

import iuh.fit.bai3.entites.Category;
import iuh.fit.bai3.entites.News;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAll();

    Category getCategoryById(int id);
}
