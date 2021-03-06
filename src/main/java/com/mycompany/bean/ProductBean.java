/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.bean;

import com.mycompany.pojo.Category;
import com.mycompany.pojo.Manufacturer;
import com.mycompany.pojo.Product;
import com.mycompany.service.ProductService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author hoang
 */
@ManagedBean
@Named(value = "productBean")
@RequestScoped
public class ProductBean {

    /**
     * @return the imgFile
     */
    public Part getImgFile() {
        return imgFile;
    }

    /**
     * @param imgFile the imgFile to set
     */
    public void setImgFile(Part imgFile) {
        this.imgFile = imgFile;
    }

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
    private String img;
    private Set<Manufacturer> manufacturers;
    private Part imgFile;
    private static ProductService proService = new ProductService();

    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            String proId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
                    .get("product_id");
            if (proId != null && !proId.isEmpty()) {
                Product p = proService.getProductById(Integer.parseInt(proId));
                this.ProID=p.getProID();
                this.ProName = p.getProName();
                this.FullDes = p.getTinyDes();
                this.TinyDes = p.getTinyDes();
                this.Price = p.getPrice();
                this.Quantity = p.getQuantity();
                this.category = p.getCategory();
                this.manufacturers = p.getManufacturers();
            }

        }
    }

    public List<Product> getProducts() {
        return getProService().getProducts(null);
    }

    public String addProduct(){
        Product p;
        if (this.ProID > 0) 
             p = proService.getProductById(this.ProID);//persistence,update
        else  p = new Product();//transient,add
        p.setProName(ProName);
        p.setCategory(category);
        p.setFullDes(TinyDes);
        p.setTinyDes(TinyDes);
        p.setPrice(Price);
        p.setQuantity(Quantity);
        p.setManufacturers(manufacturers);
        try {
            if (this.imgFile != null) {
                this.uploadFile();
                p.setImg("sp/" + this.imgFile.getSubmittedFileName());
            }

            if (proService.addOrSaveProduct(p) == true) {
                return "product-list?faces-redirect=true";
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

    public String deleteProduct(Product p) throws Exception {
        if (proService.deleteProduct(p)) {
            return "successful";
        }
        throw new Exception("Something wrong");
    }

    private void uploadFile() throws IOException {
//        String path = FacesContext.getCurrentInstance().getExternalContext()
//                .getRealPath("/resources/imgs-clothes/sp") + "/"
//                + this.imgFile.getSubmittedFileName();
        String path = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("uploadPath")
                + this.imgFile.getSubmittedFileName();
        try ( InputStream in = this.imgFile.getInputStream();  FileOutputStream out = new FileOutputStream(path)) {
            byte[] d = new byte[1024];
            int byteRead;
            while ((byteRead = in.read(d)) != -1) {
                out.write(d, 0, byteRead);
            }
        }
    }
}
