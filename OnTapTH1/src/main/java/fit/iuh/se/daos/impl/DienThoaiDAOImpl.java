package fit.iuh.se.daos.impl;

import fit.iuh.se.entities.DienThoai;
import fit.iuh.se.utils.AppUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class DienThoaiDAOImpl implements fit.iuh.se.daos.DienThoaiDAO {
    private EntityManager em;

    public DienThoaiDAOImpl() {
        this.em = AppUtils.getEntityManager();
    }

    @Override
    public List<DienThoai> findAll() {
        try {
            String jpql = "SELECT d FROM DienThoai d";
            return em.createQuery(jpql, DienThoai.class).getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<DienThoai> findAllBySupplierName(String supplierName) {
        try {
            String jpql = "SELECT d FROM DienThoai d JOIN fetch d.nhaCungCap s where s.tenNCC = :supplierName";
            return em.createQuery(jpql, DienThoai.class).setParameter("supplierName", supplierName).getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
