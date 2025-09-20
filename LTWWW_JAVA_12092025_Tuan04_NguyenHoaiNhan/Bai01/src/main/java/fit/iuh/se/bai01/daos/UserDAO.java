package fit.iuh.se.bai01.daos;

import fit.iuh.se.bai01.entities.User;
import java.util.List;

public interface UserDAO {
    public User save(User user);
    public User update(User user);
    public boolean delete(int id);
    public User findById(int id);
    public List<User> findAll();
}