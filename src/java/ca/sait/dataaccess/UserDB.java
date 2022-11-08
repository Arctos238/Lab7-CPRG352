/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.dataaccess;

import ca.sait.models.User;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author J.Pointer
 */
public class UserDB {

    public UserDB() {

    }

    public boolean createUser(User user) {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(user);
            trans.commit();

            return true;
        } catch (Exception ex) {
            trans.rollback();

            return false;
        } finally {
            em.close();
        }

    }

    public void deleteUser(User user) {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

        EntityTransaction trans = em.getTransaction();

        User ref = em.find(User.class, user.getEmail());

        try {
            trans.begin();
            em.remove(ref);
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }

    }

    public void updateUser(User user) {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        EntityManager em = emFactory.createEntityManager();
        User ref = em.find(User.class, user.getEmail());

        ref.setActive(user.getActive());
        ref.setFirstName(user.getFirstName());
        ref.setLastName(user.getLastName());
        ref.setRole(user.getRole());
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(ref);
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public List<User> getAll() {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }
}
