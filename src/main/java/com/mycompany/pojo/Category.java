/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hoang
 */
@Entity
@Table(name="categories")
public class Category implements Serializable {

    /**
     * @return the CatID
     */
    public int getCatID() {
        return CatID;
    }

    /**
     * @param CatID the CatID to set
     */
    public void setCatID(int CatID) {
        this.CatID = CatID;
    }

    /**
     * @return the CatName
     */
    public String getCatName() {
        return CatName;
    }

    /**
     * @param CatName the CatName to set
     */
    public void setCatName(String CatName) {
        this.CatName = CatName;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int CatID;
    private String CatName;
}
