/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.bean;

import com.mycompany.pojo.Category;
import com.mycompany.pojo.Manufacturer;
import com.mycompany.service.CategoryService;
import com.mycompany.service.ManufacturerService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author hoang
 */
@ManagedBean
@Named(value = "cateBean")
@SessionScoped
public class CateBean implements Serializable {

    private final static CategoryService categoryService = new CategoryService();
    private final static ManufacturerService manufacturerService = new ManufacturerService();

    /**
     * Creates a new instance of CateBean
     */
    public CateBean() {
    }

    public List<Category> getCategories() {
        return categoryService.getCategories();
    }
    public List<Manufacturer> getManufacturer(){
        return manufacturerService.getManufacturers();
    }
}
