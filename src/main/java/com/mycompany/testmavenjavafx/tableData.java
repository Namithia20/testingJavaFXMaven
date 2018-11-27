/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testmavenjavafx;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Usuario
 */
public class tableData {
    
    private String name, title;
    private GridPane acctions;

    public tableData(String name, String title) {
        this.name = name;
        this.title = title;
        
        Button see =  new Button();
        Button edit = new Button();
        
        see.getStyleClass().add("botonView");        
        edit.getStyleClass().add("botonEdit");
        
        this.acctions = new GridPane();
        this.acctions.add(see,0,0);
        this.acctions.add(edit,1,0);
        this.acctions.getStyleClass().add("acciones");
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public GridPane getAcctions() {
        return acctions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAcctions(HBox acctions) {
        Button see =  new Button();
        Button edit = new Button();
        
        see.getStyleClass().add("botonView");
        edit.getStyleClass().add("botonEdit");
        
        this.acctions = new GridPane();
        this.acctions.add(see,0,0);
        this.acctions.add(edit,1,1);
        this.acctions.getStyleClass().add("acciones");
    }
    
    
}
