/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.testmavenjavafx.tableData;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class Scene2Controller implements Initializable {

    @FXML
    private Label l_Text;
    
    @FXML
    private TableView<tableData> tv; //cambiar Node por el objeto/clase 
    
    @FXML
    private TableColumn<tableData, String> name;

    @FXML
    private TableColumn<tableData, String> title;

    @FXML
    private TableColumn<tableData, HBox> action;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        name.setCellValueFactory(new PropertyValueFactory<tableData, String>("name")); //propiedades/variables de la clase tableData
        title.setCellValueFactory(new PropertyValueFactory<tableData, String>("title"));
        action.setCellValueFactory(new PropertyValueFactory<tableData, HBox>("acctions"));
        
        tv.setItems( datos() );
    }    
    
    
    public ObservableList<tableData> datos()
    {
        ObservableList<tableData> datos = FXCollections.observableArrayList();
        
        datos.add(new tableData("OF", "Calibre XXX"));
        datos.add(new tableData("OF2017", "Calibre BMV 25"));
        
        System.out.println(datos);
        return datos;
    }
    
     @FXML
    void backPane(ActionEvent event) throws IOException {
        Parent vistaAnt = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml")); 
        Scene vistaAnt_scene = new Scene(vistaAnt);
        vistaAnt_scene.getStylesheets().add("/styles/Styles.css"); 
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setTitle("Testing JavaFX and Maven");
        app_stage.setScene(vistaAnt_scene);
        app_stage.show();
    }
    
    public void initData(String val)
    {
        l_Text.setText(val);
    }
}
