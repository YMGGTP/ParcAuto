package com.mycompany.parcautomobile;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.client.widget.grid.selection.SelectionEvent;
import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent.SelectionListener;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

/**
 *
 */
@Theme("mytheme")
@Widgetset("com.mycompany.parcautomobile.MyAppWidgetset")
public class MyUI extends UI {

    private Grid contactList = new Grid();
    private Grid contactList1 = new Grid();
    private Table contactTable = new Table();
    private Grid contactList2 = new Grid();
    @Override
    protected void init(VaadinRequest vaadinrequest) {
        configureComponents();  // configuration des composants
        buildLayout();          //  construction de la vue
    }

    private void configureComponents() {

        // Chargement des données.
    Init uniqueinstance=Init.getInit();
    uniqueinstance.chargementinitial();
    
 

        

        contactList.setContainerDataSource(Vehicule.getVehicules());
        contactList1.setContainerDataSource(Vehicule.getVehiculesPrixBas());
        contactList2.setContainerDataSource(Visiteur.getVisiteur());

        //contactTable.setContainerDataSource(new BeanItemContainer<>( Vehicule.class));
        contactList.setColumnOrder("marque", "modele", "prix");  // choisir l'ordre des colonnes
        contactList.removeColumn("id"); 
        contactList1.setColumnOrder("marque", "modele", "prix");  // choisir l'ordre des colonnes
        contactList1.removeColumn("id"); // masquer la colonne
        //  contactList.setSelectionMode(Grid.SelectionMode.SINGLE);
       
        
        contactList2.setColumnOrder("id", "prenom", "nom", "marque");  // choisir l'ordre des colonnes

        
        
        contactList.setSizeFull();
        contactList1.setSizeFull();
        contactList2.setSizeFull();

    }

    private void buildLayout() {

        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        // ajouts de composants
        layout.addComponent(new Label(" Parc de véhicule"));
        layout.addComponent(contactList);
        layout.addComponent(new Label(" Parc de véhicule < 15 000 prix"));
        layout.addComponent(contactList1);
        
         layout.addComponent(new Label(" Visiteurs"));
        layout.addComponent(contactList2);
        //layout.addComponent(contactTable);
        setContent(layout);  // affectation de la vue
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
