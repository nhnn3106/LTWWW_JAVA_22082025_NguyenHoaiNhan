package fit.iuh.se.daos.impl;

import fit.iuh.se.entities.CartItem;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class CartItemDAO {
    private EntityManager em;

    public CartItemDAO(EntityManager em) {
        this.em = em;
    }

    public CartItem add(CartItem itemCart) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(itemCart);
            tx.commit();
            return itemCart;
        } catch (Exception e) {
            e.printStackTrace();
            if(tx != null && tx.isActive()) tx.rollback();
        }
        return null;
    }

    public CartItem update(CartItem itemCart) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(itemCart);
            tx.commit();
            return itemCart;
        } catch (Exception e) {
            e.printStackTrace();
            if(tx != null && tx.isActive()) tx.rollback();
        }
        return null;
    }

    public boolean delete(int id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            CartItem itemCart = em.find(CartItem.class, id);
            if (itemCart != null) {
                em.remove(itemCart);
            }
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if(tx!=null && tx.isActive()) {
                tx.rollback();
            }
        }
        return false;
    }
    public CartItem findById(int id) {
        try {
            CartItem itemCart = em.find(CartItem.class, id);
            return itemCart;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CartItem> findAll() {
        try {
            return em
                    .createQuery("SELECT u FROM CartItem u", CartItem.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
