package fit.iuh.se.daos.impl;

import fit.iuh.se.entities.DienThoai;
import fit.iuh.se.utils.AppUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class DienThoaiDAOImpl implements fit.iuh.se.daos.DienThoaiDAO {

    private EntityManager em;

    public DienThoaiDAOImpl() {
        this.em = AppUtil.getEntityManager();
    }

    @Override
    public List<DienThoai> findAll() {
        try {
            String jpql = "SELECT d from DienThoai d join fetch d.nhaCungCap ncc order by ncc.maNCC";

            return em.createQuery(jpql, DienThoai.class).getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<DienThoai> findBySupplierID(int supplierID) {
        try {
            String jpql = "SELECT d from DienThoai d join d.nhaCungCap s where s.maNCC = :supplierID";
            return em.createQuery(jpql, DienThoai.class)
                    .setParameter("supplierID", supplierID)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public List<DienThoai> findBySupplierName(String supplierName) {
        try {
            String jpql = "SELECT d from DienThoai d join d.nhaCungCap s where s.tenNhaCC LIKE CONCAT('%',:supplierName, '%')";
            return em.createQuery(jpql, DienThoai.class)
                    .setParameter("supplierName", supplierName)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DienThoai> findBySupplierAddress(String supplierAddress) {
        try {
            String jpql = "SELECT d from DienThoai d join d.nhaCungCap s where s.diaChi LIKE CONCAT('%', :supplierAddress, '%')";
            return em.createQuery(jpql, DienThoai.class)
                    .setParameter("supplierAddress", supplierAddress)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DienThoai> findBySupplierPhone(String supplierPhone) {
        try {
            String jpql = "SELECT d from DienThoai d join d.nhaCungCap s where s.diaChi LIKE CONCAT('%', :supplierPhone, '%')";
            return em.createQuery(jpql, DienThoai.class)
                    .setParameter("supplierPhone", supplierPhone)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addDienThoai(DienThoai dienThoai) {
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(dienThoai);
            tx.commit();
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeDienThoaiByID(int id) {
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(em.find(DienThoai.class, id));
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
