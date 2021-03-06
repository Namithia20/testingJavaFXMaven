package com.mycompany.controllers;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

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
    
      @FXML
    private Button btest;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
       CB_Test.getItems().addAll("A", "B", "C"); //asigna valores al desplegable
       cont.setSpacing(10);
       btest.getStyleClass().add("bImg");
    }   
    
    @FXML
    public void carga(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Scene2.fxml"));
        Parent vistaAnt = loader.load(); 
        
        Scene2Controller controller = loader.getController();
        if( CB_Test.getValue() == null)
        {            
            controller.initData("sin datos");
        }else            
        {
            if(CB_Test.getValue().trim().isEmpty() || CB_Test.getValue().trim().isBlank())
            {
                controller.initData("sin datos");
            }
            else
            {
                controller.initData(CB_Test.getValue());
            }
        }
        
        Scene vistaAnt_scene = new Scene(vistaAnt);        
        vistaAnt_scene.getStylesheets().add("/styles/scene2.css"); 
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setTitle("Testing JavaFX and Maven");
        //app_stage.hide();
        app_stage.setScene(vistaAnt_scene);
        app_stage.show();
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
