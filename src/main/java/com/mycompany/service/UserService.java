/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.phoneweb.HibernateUtils;
import com.mycompany.pojo.User;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author hoang
 */
public class UserService {

    private final static SessionFactory FACTORY = HibernateUtils.getSessionFactory();

    public boolean addUser(User u) { //status persistent=>update, transient=>add
        try ( Session session = FACTORY.openSession()) {
            try {
                session.getTransaction().begin();
                u.setPassword(DigestUtils.md5Hex(u.getPassword()));
                session.save(u);
                session.getTransaction().commit();
                return true;
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
        return false;

    }

    public User login(String username, String password) {
        password = DigestUtils.md5Hex(password);
        try ( Session session = FACTORY.openSession()) {
            try {
                CriteriaBuilder b = session.getCriteriaBuilder();
                CriteriaQuery<User> q = b.createQuery(User.class);
                Root<User> root = q.from(User.class);
                q.select(root);
                q.where(b.equal(root.get("username").as(String.class),
                        username), b.equal(root.get("password").as(String.class), password));
                return session.createQuery(q).getSingleResult();
            }catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
