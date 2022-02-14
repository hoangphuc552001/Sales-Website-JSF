/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;

/**
 *
 * @author hoang
 */
@ManagedBean
@Named(value = "cartBean")
@SessionScoped
public class CartBean implements Serializable {

    /**
     * Creates a new instance of CartBean
     */
    public CartBean() {
    }
    @PostConstruct
    public void init(){
        if (FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("cart")==null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                    .put("cart", new HashMap<>());
        }
    }
    
    public String addItemToCart(int productID,String productName,BigDecimal price){
        Map<Integer,Object> cart=(Map<Integer,Object>) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap()
                .get("cart");
       if (cart.get(productID)==null){
           Map<String,Object> data=new HashMap<>();
           data.put("productId", productID);
           data.put("productName",productName);
           data.put("productPrice",price);
           data.put("count", 1);
           cart.put(productID,data);
       } else{
           Map<String,Object>d= (Map<String,Object>) cart.get("productId");
           d.put("count",Integer.parseInt((String) d.get("count"))+1);
       }
        return null;
    }
}
