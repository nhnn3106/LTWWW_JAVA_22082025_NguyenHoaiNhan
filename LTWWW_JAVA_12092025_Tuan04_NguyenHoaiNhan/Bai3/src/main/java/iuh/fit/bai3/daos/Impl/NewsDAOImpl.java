package iuh.fit.bai3.daos.Impl;

import iuh.fit.bai3.daos.NewsDAO;
import iuh.fit.bai3.entites.News;
import iuh.fit.bai3.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class NewsDAOImpl implements NewsDAO {
    private EntityManager entityManager;

    public NewsDAOImpl() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public List<News> getAll() {
        String query = "SELECT n FROM News n";
        try {
            return entityManager.createQuery(query, News.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean addNews(News news) {
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.persist(news);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteNews(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            News news = entityManager.find(News.class, id);
            if (news != null) {
                entityManager.remove(news);
            }
            transaction.commit();
            return true;
        } finally {
            entityManager.close();
        }


    }


}
