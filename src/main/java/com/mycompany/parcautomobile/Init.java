/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parcautomobile;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;


/**
 *
 * @author Guillaume
 */
public class Init {
    public XMLEncoder encoder = null;
    private static Init uniqueInit;
    
    private Init() { 
        serialiser();}
    public static Init getInit() {
        if (uniqueInit == null){
            uniqueInit = new Init();
        }
        return uniqueInit;
        
    }
    
   public void chargementinitial(){
        Vehicule vehicule1 = new Vehicule(1, "Renault", "Clio", 10000);
        Vehicule vehicule2 = new Vehicule(2, "Audi", "A8", 12500);
        Vehicule vehicule3 = new Vehicule(3, "Toyota", "Yaris", 15005);
        Vehicule vehicule4 = new Vehicule(4, "Test", "test", 18650);
        Vehicule vehicule5 = new Vehicule(5, "Test1", "test1", 20000);
        Vehicule vehicule6 = new Vehicule(6, "Test1", "test1", 8000);
        

    
        Visiteur visiteur2 = new Visiteur(2, "Guillaume", "Guigui", "Test");
       
        Affectation affectation1 = new Affectation(2, "9");
        Affectation affectation2 = new Affectation(2, "12/13/10");
   }
        
   
   public void serialiser(){
   Visiteur visiteur1 = new Visiteur(1, "Marlon", "Chat", "Audi");

        
       try {
           encoder = new XMLEncoder(new BufferedOutputStream(
           new FileOutputStream("visiteurtest.xml")));
           encoder.writeObject(visiteur1);
           encoder.flush();
       }catch (final java.io.IOException e){
           e.printStackTrace();
       } finally {
           if (encoder != null){
              
               encoder.close();
               
           }
       }
   }}






/*
   public void deserealiser(){

        XMLDecoder decoder=null;
        
        try {
        decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("visiteur.xml")));
        final Visiteur visiteur = (Visiteur) decoder.readObject();
        System.out.println(visiteur);
        } catch (final Exception e) {
          e.printStackTrace();
        
        } finally {
            if (decoder !=null){
                decoder.close();
                
            }
        }  
    }

    
}*/