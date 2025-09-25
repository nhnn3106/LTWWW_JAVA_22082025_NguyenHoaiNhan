package fit.iuh.se.daos.impl;

import fit.iuh.se.entities.NhaCungCap;
import fit.iuh.se.utils.AppUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class NhaCungCapDAOImpl implements fit.iuh.se.daos.NhaCungCapDAO {
    private EntityManager em;
    public NhaCungCapDAOImpl() {
        em = AppUtil.getEntityManager();
    }

    @Override
    public List<NhaCungCap> findAll() {
        try {
              String jpql = "SELECT n from NhaCungCap n";

              return em.createQuery(jpql, NhaCungCap.class).getResultList();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NhaCungCap> findByID(int id) {
        try {
            String jpql = "SELECT n from NhaCungCap n where n.maNCC = :id";

            return em.createQuery(jpql, NhaCungCap.class).setParameter("id", id).getResultList();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NhaCungCap> findByName(String name) {
        try {
            String jpql = "SELECT n from NhaCungCap n where n.tenNhaCC LIKE CONCAT('%',:name,'%')";

            return em.createQuery(jpql, NhaCungCap.class).setParameter("name", name).getResultList();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NhaCungCap> findByAddress(String address) {
        try {
            String jpql = "SELECT n from NhaCungCap n where n.diaChi LIKE CONCAT('%',:address,'%')";

            return em.createQuery(jpql, NhaCungCap.class).setParameter("address", address).getResultList();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NhaCungCap> findByPhone(String phone) {
        try {
            String jpql = "SELECT n from NhaCungCap n where n.soDienThoai LIKE CONCAT('%',:phone,'%')";

            return em.createQuery(jpql, NhaCungCap.class).setParameter("phone", phone).getResultList();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
