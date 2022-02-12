/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.converter;
import com.mycompany.service.ManufacturerService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author hoang
 */
@FacesConverter("ManufacturerConverter")
public class ManufacturerConverter implements Converter{
//đổ thành object
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return new ManufacturerService().getManufacturerById(Integer.parseInt(value));
     }
//    đổ ra ngoài ui
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        return value.toString();
    }
    
}
