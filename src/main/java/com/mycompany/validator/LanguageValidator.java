/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectMany;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



/**
 *
 * @author hoang
 */
@FacesValidator("LanguageValidator")
public class LanguageValidator implements Validator{

    /**
     * Creates a new instance of LanguageValidator
     */
    public LanguageValidator() {
    }

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) throws ValidatorException {
        UISelectMany lng=(UISelectMany) uic.findComponent("checkNgonNgu");
        if (t.toString().isEmpty()&&lng.getSelectedValues().length==0){
            FacesMessage m =new FacesMessage("Vui long chon mot ngon ngu");
            m.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(m);
        }   
    }
    
}
