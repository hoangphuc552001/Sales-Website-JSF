/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author hoang
 */
@FacesValidator("uploadValidator")
public class ImgValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) throws ValidatorException {
        Part p=(Part) t;
        //Ảnh phải png hoặc jpg
        if (!p.getContentType().equals("image/png")&&
                !p.getContentType().equals("image/jpg")){
            FacesMessage msg=new FacesMessage("Need png/jpg");
            throw  new ValidatorException(msg);                    
        }
        //Dung lượng phải nhỏ hơn hoặc bằng 2MB 
        if(p.getSize()>2097152){
             FacesMessage msg=new FacesMessage("Size<=2MB");
            throw  new ValidatorException(msg);    
        }
    }
    
}
