/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phoneweb;

import com.mycompany.pojo.Category;
import com.mycompany.pojo.Manufacturer;
import com.mycompany.pojo.Payment;
import com.mycompany.pojo.PaymentDetail;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;
import javax.validation.Payload;

public class HibernateUtils {
    private final static SessionFactory FACTORY;
    static {
        Configuration conf=new Configuration();

        Properties pros=new Properties();
        pros.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
        pros.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        pros.put(Environment.URL,"jdbc:mysql://localhost:3306/qlbh-test");
        pros.put(Environment.USER,"root");
        pros.put(Environment.PASS,"");

        conf.setProperties(pros);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Manufacturer.class);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Payment.class);
        conf.addAnnotatedClass(PaymentDetail.class);
        ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY=conf.buildSessionFactory(registry);
    }
    public static SessionFactory getSessionFactory(){
        return FACTORY;
    }
}
