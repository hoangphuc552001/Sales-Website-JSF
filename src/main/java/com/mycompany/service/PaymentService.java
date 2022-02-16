/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.phoneweb.HibernateUtils;
import com.mycompany.pojo.Payment;
import com.mycompany.pojo.PaymentDetail;
import com.mycompany.pojo.User;
import java.util.List;
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
public class PaymentService {

    private final static SessionFactory FACTORY = HibernateUtils.getSessionFactory();

    public boolean addPayment(Payment payment, List<PaymentDetail> paymentDetail) { //status persistent=>update, transient=>add
        try ( Session session = FACTORY.openSession()) {
            try {
                session.getTransaction().begin();
                session.save(payment);
                System.out.println(payment.getId());
                System.out.println(paymentDetail.size());
                for (PaymentDetail detail : paymentDetail) {
                    System.out.println(detail.getPayment().getId());
                    session.save(detail);
                }
                session.getTransaction().commit();
                return true;
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
        return false;

    }

}
