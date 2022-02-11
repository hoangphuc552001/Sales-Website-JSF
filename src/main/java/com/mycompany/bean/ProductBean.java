/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.bean;

import com.mycompany.pojo.Product;
import com.mycompany.service.ProductService;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author hoang
 */
@ManagedBean
@Named(value = "productBean")
@RequestScoped
public class ProductBean {
    private final static ProductService proService=new ProductService();
    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }
    public List<Product> getProducts(){
        return proService.getProducts(null);
    }
}

