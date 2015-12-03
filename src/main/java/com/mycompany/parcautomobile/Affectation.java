/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parcautomobile;

import com.vaadin.data.util.BeanItemContainer;

/**
 *
 * @author Guillaume
 */
public class Affectation {
    


    private int id;
    private String dateAffectation;
    private static BeanItemContainer<Affectation> affectation = new BeanItemContainer<>(Affectation.class);
    
 public Affectation() {
    }

    public Affectation(int id, String dateAffectation) {
        this.id = id;
        this.dateAffectation=dateAffectation;
        this.affectation.addBean(this);
    }

    public String getDate() {
        return dateAffectation;
    }
    public void setDate(String dateAffectation){
    
    this.dateAffectation = dateAffectation;
        
    }
      public static BeanItemContainer<Affectation> getAffectation() {
    
    
    
    return affectation;
    }
}
