/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hoang
 */
@Entity
@Table(name="products")
public class Product implements Serializable {

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProID;
    private String ProName;
    private String TinyDes;
    private String FullDes;
    private BigDecimal Price;
    private int Quantity;
    private String img;
    @ManyToOne
    @JoinColumn(name = "CatID")
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="prod_manufacturer",
            joinColumns={
                @JoinColumn(name="product_id")
            },
            inverseJoinColumns={
                @JoinColumn(name="manufacturer_id")
            }
    )
    private Set<Manufacturer> manufacturers;
}
