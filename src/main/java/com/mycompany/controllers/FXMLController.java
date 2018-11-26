package com.mycompany.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class FXMLController implements Initializable {
    
    @FXML
    private ComboBox<String> CB_Test;
    
     @FXML
    private TitledPane panelD;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private Pane PaneCopy;

    @FXML
    private AnchorPane comboboxPane;

    @FXML
    private Button boton;
    
    @FXML
    private VBox cont;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        CB_Test.getItems().addAll("A", "B", "C"); //asigna valores al desplegable
        cont.setSpacing(10);
        
    }   
    
    public void printValue()
    {
        System.out.println((String) CB_Test.getValue()); //devuelve el valor seleccionado o escrito del combobox
       
        Pane nuevo = new Pane(PaneCopy);
        
        double val =  nuevo.getBoundsInParent().getHeight()*2;
        nuevo.setLayoutY(val);
         System.out.println("X = "+nuevo.getLayoutX()+", Y = "+nuevo.getLayoutY() + ", bounds = "+nuevo.getBoundsInParent().getHeight());
        cont.getChildren().add(nuevo);
         System.out.println(cont.getChildren().size());
    }
}
