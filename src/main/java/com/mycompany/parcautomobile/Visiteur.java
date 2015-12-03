/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parcautomobile;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author user
 */ 






public class Visiteur {


    private int id;
    private String prenom;
    private String nom;
    private String marque;
    private static BeanItemContainer<Visiteur> visiteurs = new BeanItemContainer<>(Visiteur.class);
    
    public Visiteur(){
        
    }


    public Visiteur(int id, String prenom, String nom, String marque) {
        this.id = id;
        this.prenom= prenom;
        this.nom = nom;
        this.marque = marque;
        this.visiteurs.addBean(this);
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    
    public String getMarque() {
        return marque;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static BeanItemContainer<Visiteur> getVisiteur() {
    
    
    
    return visiteurs;
    }
    
    
    
}