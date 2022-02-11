/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.phoneweb.HibernateUtils;
import com.mycompany.pojo.Category;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author hoang
 */
public class CategoryService {
    private final static SessionFactory FACTORY=HibernateUtils.getSessionFactory();
    public List<Category> getCategories(){
        try(Session session=FACTORY.openSession()){
            CriteriaBuilder builder=session.getCriteriaBuilder();
            CriteriaQuery<Category> query=builder.createQuery(Category.class);
            Root<Category> root=query.from(Category.class);
            query.select(root);
            return session.createQuery(query).getResultList();
        }
    }
}
