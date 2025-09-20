package iuh.fit.bai3.daos.Impl;

import iuh.fit.bai3.daos.CategoryDAO;
import iuh.fit.bai3.entites.Category;
import iuh.fit.bai3.utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private EntityManager entityManager;

    public CategoryDAOImpl() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public List<Category> getAll() {
        String query = "SELECT c FROM Category c";
        try {
            return entityManager.createQuery(query, Category.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Category getCategoryById(int id){
        try{
            return entityManager.find(Category.class, id);
        } catch (Exception e) {
            return null;

        }
    }

}
