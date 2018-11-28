/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class Scene3Controller implements Initializable {

    @FXML
    private Circle backColor;

    @FXML
    private ImageView imgDep;

    @FXML
    private Circle shadow;

    @FXML
    private Button bColor;

    @FXML
    private Button bBlock;

    @FXML
    private Label texto;
    
    Integer i = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        shadow.setVisible(false);
    }    
    
    @FXML
    void bloquea(ActionEvent event) {
       if(shadow.isVisible()==true)
       {
           shadow.setVisible(false);
       }
       else
       {shadow.setVisible(true);}
    }

    @FXML
    void cambiacol(ActionEvent event) {
        ArrayList<String> l = new ArrayList<>();  
        l.add("#1e90ff");
        l.add("#1fdd32");
        l.add("#d60909");
        l.add("#ffffff");
        
        backColor.setFill(Paint.valueOf(l.get(i)));
        i++;
        if(i>3)
        {i=0;} 
    }

    @FXML
    void info(MouseEvent event) {
         texto.setText("Hola");
    }
}
