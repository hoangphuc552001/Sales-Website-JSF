/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author hoang
 */
@ManagedBean
@Named(value = "surveyBean")
@RequestScoped
public class SurveyBean {

    private String name;
    private String year;
    private String gender;
    private String[] languages;
    private String others;
    private String reason;

    /**
     * Creates a new instance of SurveyBean
     */
    public SurveyBean() {
    }
    public String goAjax(){
        return "ajaxtest?faces-redirect=true";
    }
    public String getResponse() {
        StringBuilder builder = new StringBuilder();
        if (this.name != null) {
            builder.append(String.format("Ho ten: %s<br>", this.name));
            builder.append(String.format("Nam sinh: %s<br>", this.year));
            builder.append(String.format("Gioi tinh: %s<br>", this.gender));
        }
        return builder.toString();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the languages
     */
    public String[] getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    /**
     * @return the others
     */
    public String getOthers() {
        return others;
    }

    /**
     * @param others the others to set
     */
    public void setOthers(String others) {
        this.others = others;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

}
