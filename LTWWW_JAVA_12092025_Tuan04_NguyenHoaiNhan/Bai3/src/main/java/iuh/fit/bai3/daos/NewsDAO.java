package iuh.fit.bai3.daos;

import iuh.fit.bai3.entites.News;

import java.util.List;

public interface NewsDAO {
    List<News> getAll();
    boolean addNews(News news);

    boolean deleteNews(int id);
}
