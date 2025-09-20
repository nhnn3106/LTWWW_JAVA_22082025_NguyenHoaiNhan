package fit.iuh.se.daos.impl;

import fit.iuh.se.entities.NhaCungCap;
import fit.iuh.se.utils.AppUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class NhaCungCapDAOImpl implements fit.iuh.se.daos.NhaCungCapDAO {
    private EntityManager em;

    public NhaCungCapDAOImpl() {
        this.em = AppUtils.getEntityManager();
    }

    @Override
    public List<NhaCungCap> findAll() {
        try {
            String jpql = "SELECT n FROM NhaCungCap n";
            return em.createQuery(jpql, NhaCungCap.class).getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
