package com.mycompany.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ListView;

public class FXMLController implements Initializable {
    
    @FXML
    private ComboBox<String> CB_Test;
    
     @FXML
    private TitledPane panelD;

    @FXML
    private Pane PaneCopy;

    @FXML
    private AnchorPane comboboxPane;

    @FXML
    private Button boton;
    
    @FXML
    private VBox cont;
    
    @FXML
    private ListView<String> Lista;    

    @FXML
    private Label lSelection;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        CB_Test.getItems().addAll("A", "B", "C"); //asigna valores al desplegable
        cont.setSpacing(10);
    }   
    
    
    @FXML
    public void deletePane(ActionEvent event) {
        Pane p = (Pane)((Button)event.getSource()).getParent();
        ((VBox)p.getParent()).getChildren().remove(p);
    }
    
    @FXML
    public void printValue(ActionEvent event) //genera nuevos paneles aunque se borren todos los visibles
    {
        Pane nuevo = new Pane();
        nuevo = clonaPanel(PaneCopy);
        cont.getChildren().add(nuevo);
    }   
    
    @FXML
    void Leedatos(ActionEvent event) {
        lSelection.setText("");
        lSelection.setText(CB_Test.getValue());
        
        Lista.getItems().clear();
        
        for(Node child:cont.getChildren())
        {
            String t = ((TextField)((Pane) child).getChildren().get(2)).getText();
            Lista.getItems().add(t);
        }
        
    }
    
    public Pane clonaPanel(Pane p)
    {
        Pane clon = new  Pane();
        
        clon.setLayoutX(p.getLayoutX());
        clon.setLayoutY(p.getLayoutY());
        clon.setPrefHeight(p.getPrefHeight());
        clon.setPrefWidth(p.getPrefWidth());
        clon.getStyleClass().add("panelClon");
        
        Label l = new Label();
        Label lc =(Label) p.getChildren().get(0);
        
        l.setLayoutX(lc.getLayoutX());
        l.setLayoutY(lc.getLayoutY());
        l.setPrefHeight(lc.getPrefHeight());
        l.setPrefWidth(lc.getPrefWidth());
        l.setText(lc.getText());
        l.getStyleClass().add("Mytext");
        
        Button b =  new Button();
        Button bc = (Button) p.getChildren().get(1);
        
        b.setLayoutX(bc.getLayoutX());
        b.setLayoutY(bc.getLayoutY());
        b.setPrefHeight(bc.getPrefHeight());
        b.setPrefWidth(bc.getPrefWidth());
        b.setText(bc.getText());
        b.setOnAction(bc.getOnAction()); //copia la función deletePane del origen
        
        TextField t = new TextField();
        TextField tc = (TextField) p.getChildren().get(2);
        
        t.setLayoutX(tc.getLayoutX());
        t.setLayoutY(tc.getLayoutY());
        t.setPrefHeight(tc.getPrefHeight());
        t.setPrefWidth(tc.getPrefWidth());
        
        
        clon.getChildren().addAll(l, b, t);
        
        return clon;
    }
}
