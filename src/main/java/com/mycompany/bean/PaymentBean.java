/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.bean;

import com.mycompany.pojo.Payment;
import com.mycompany.pojo.PaymentDetail;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import com.mycompany.service.PaymentService;
import com.mycompany.service.ProductService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author hoang
 */
@ManagedBean
@Named(value = "paymentBean")
@RequestScoped
public class PaymentBean {
    private static final ProductService proService = new ProductService();
    private static final PaymentService paymentService = new PaymentService();

    /**
     * Creates a new instance of PaymentBean
     */
    public PaymentBean() {
    }

    public String add() {
        Map<Integer, Object> cart = (Map<Integer, Object>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cart");
        if (cart != null) {
            Payment p = new Payment();
            p.setCreatedDate(new Date());
            p.setUser((User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user"));
            List<PaymentDetail> details=new ArrayList<>();
            List<Map<String, Object>> kq = new ArrayList<>();
            for (Object o : cart.values()) {
                Map<String, Object> d = (Map<String, Object>) o;
                Product pro = proService.getProductById(Integer.parseInt(d.get("productId")
                .toString()));
                PaymentDetail detail=new PaymentDetail();
                detail.setProduct(pro);
                detail.setPayment(p);
                detail.setPrice(pro.getPrice());
                detail.setCount(Integer.parseInt(d.get("count").toString()));
                details.add(detail);
            }
            if (paymentService.addPayment(p, details)) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("cart");
                return "index?faces-redirect=true";
            }
        }
        return "payment";
    }

}
