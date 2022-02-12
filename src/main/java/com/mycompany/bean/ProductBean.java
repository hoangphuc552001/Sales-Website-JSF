/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.bean;

import com.mycompany.pojo.Category;
import com.mycompany.pojo.Manufacturer;
import com.mycompany.pojo.Product;
import com.mycompany.service.ProductService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
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

    /**
     * @return the ProID
     */
    public int getProID() {
        return ProID;
    }

    /**
     * @param ProID the ProID to set
     */
    public void setProID(int ProID) {
        this.ProID = ProID;
    }

    /**
     * @return the ProName
     */
    public String getProName() {
        return ProName;
    }

    /**
     * @param ProName the ProName to set
     */
    public void setProName(String ProName) {
        this.ProName = ProName;
    }

    /**
     * @return the TinyDes
     */
    public String getTinyDes() {
        return TinyDes;
    }

    /**
     * @param TinyDes the TinyDes to set
     */
    public void setTinyDes(String TinyDes) {
        this.TinyDes = TinyDes;
    }

    /**
     * @return the FullDes
     */
    public String getFullDes() {
        return FullDes;
    }

    /**
     * @param FullDes the FullDes to set
     */
    public void setFullDes(String FullDes) {
        this.FullDes = FullDes;
    }

    /**
     * @return the Price
     */
    public BigDecimal getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }

    /**
     * @return the Quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the manufacturers
     */
    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    /**
     * @param manufacturers the manufacturers to set
     */
    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    /**
     * @return the proService
     */
    public static ProductService getProService() {
        return proService;
    }

    /**
     * @param aProService the proService to set
     */
    public static void setProService(ProductService aProService) {
        proService = aProService;
    }
    private int ProID;
    private String ProName;
    private String TinyDes;
    private String FullDes;
    private BigDecimal Price;
    private int Quantity;
    private Category category;
    private Set<Manufacturer> manufacturers;

    private static ProductService proService=new ProductService();
    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }
    public List<Product> getProducts(){
        return getProService().getProducts(null);
    }
    public String addProduct(){
        Product p=new Product();
        p.setProName(ProName);
        p.setCategory(category);
        p.setFullDes(TinyDes);
        p.setTinyDes(TinyDes);
        p.setPrice(Price);
        p.setQuantity(Quantity);
        p.setManufacturers(manufacturers);
        System.out.println(p.getManufacturers());
        if (proService.addOrSaveProduct(p)==true) return "product-list?faces-redirect=true";
        return "index";
    }
}

