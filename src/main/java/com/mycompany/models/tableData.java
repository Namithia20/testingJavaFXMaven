/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Usuario
 */
public class tableData {
    
    private Integer name;
    private String title;
    private Integer estado;
    private HBox acctions;

    public tableData(Integer name, String title, String est) {
        this.name = name;
        this.title = title;
        
        Button see =  new Button();
        Button edit = new Button();
        
        see.getStyleClass().add("botonView");        
        edit.getStyleClass().add("botonEdit");
        
        see.setPrefHeight(20);
        see.setPrefWidth(25);
        edit.setPrefHeight(20);
        edit.setPrefWidth(25);
        
        this.acctions = new HBox(see, edit);
        this.acctions.setSpacing(10);
        this.acctions.getStyleClass().add("action");
        
        switch(est)
        {
            case "parada": this.estado = 2;
            break;
            case "retrasada": this.estado = 1;
            break;
            default: this.estado = 0;
            break;
        }
    }

    public Integer getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public HBox getAcctions() {
        return acctions;
    }
    
    public Integer getEstado()
    {
        return estado;
    }

    public void setName(Integer name) {
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
        
        see.setPrefHeight(20);
        see.setPrefWidth(25);
        edit.setPrefHeight(20);
        edit.setPrefWidth(25);
        
        this.acctions = new HBox(see, edit);
        this.acctions.setSpacing(10);
        
        this.acctions.getStyleClass().add("action");   
    }
    
    public void setEstado(String est)
    {
        switch(est)
        {
            case "parada": this.estado = 2;
            break;
            case "retrasada": this.estado = 1;
            break;
            default: this.estado = 0;
            break;
        }
    }   
    
}
