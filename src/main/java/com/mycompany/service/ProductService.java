/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.phoneweb.HibernateUtils;
import com.mycompany.pojo.Product;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author hoang
 */
public class ProductService {

    private final static SessionFactory FACTORY = HibernateUtils.getSessionFactory();

    public List<Product> getProducts(String kw) {
        try ( Session session = FACTORY.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> root = query.from(Product.class);
            query.select(root);
            if (kw != null && !kw.isEmpty()) {
                String p = String.format("%%%s%%", kw);
                Predicate p1 = builder.like(root.get("ProName").as(String.class), p);
                Predicate p2 = builder.like(root.get("TinyDes").as(String.class), p);
                query=query.where(builder.or(p1,p2));
            }
            return session.createQuery(query).getResultList();
        }
    }
}
