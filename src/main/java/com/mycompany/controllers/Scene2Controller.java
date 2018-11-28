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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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
    private TableColumn<tableData, Integer> name;

    @FXML
    private TableColumn<tableData, String> title;

    @FXML
    private TableColumn<tableData, HBox> action;
    
    @FXML
    private ComboBox selectFilter;
    
    @FXML
    private Button bFilter;
    
    
    private Integer filtroEstado = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Filter
        ObservableList<String> estados =  FXCollections.observableArrayList();
        estados.addAll("Todas", "Normal", "Parada", "Retrasada");        
        selectFilter.setItems(estados);
        selectFilter.getSelectionModel().selectFirst();
        
        //Table data
        name.setCellValueFactory(new PropertyValueFactory<tableData, Integer>("name")); //propiedades/variables de la clase tableData
        title.setCellValueFactory(new PropertyValueFactory<tableData, String>("title"));
        action.setCellValueFactory(new PropertyValueFactory<tableData, HBox>("acctions"));
       
        action.getStyleClass().add("action");
        
        tv.setRowFactory(param -> new TableRow<tableData>(){
            @Override                
            public void updateItem(tableData item, boolean empty){
                super.updateItem(item, empty);
                if(item == null)
                {setStyle("");}
                else if(item.getEstado()== 1) //1 = retrasada
                {setStyle("-fx-background-color: red; -fx-text-fill: white;");}
                else if(item.getEstado() == 2) // 2 = parada
                {setStyle("-fx-background-color: cyan; -fx-text-fill: white;");}
                else
                {setStyle("");}
            }
        });
        
        rellenaTabla( datos() );
    }    
    
    @FXML
    void filtrar(ActionEvent event) 
    {
        System.out.println("filtro");
        String f = selectFilter.getValue().toString();
        switch(f)
        {
            case "Normal": filtroEstado = 0;
            break;
            case "Parada": filtroEstado = 2;
            break;
            case "Retrasada": filtroEstado = 1;
            break;
            default: filtroEstado = -1;
            break;
        }
        
        rellenaTabla(datosFiltro( datos(), filtroEstado));        
    }
    
    public void rellenaTabla(ObservableList<tableData> lista)
    {
        System.out.println("tabla filtrada");
        tv.getItems().clear();
        tv.setItems(lista);
        tv.getSortOrder().add(name);
    }
    
    public ObservableList<tableData> datosFiltro(ObservableList<tableData> lista, Integer filtro)
    {
        ObservableList<tableData> data = FXCollections.observableArrayList();
        if(filtro > -1)
        {
            for(tableData d:lista)
            {
                if(d.getEstado() == filtro)
                {
                    data.add(d);
                }           
            }
        }
        else
        {
            data = lista;
        }               
        
        return data;
    }
    
    public ObservableList<tableData> datos()
    {
        ObservableList<tableData> datos = FXCollections.observableArrayList();
        
        datos.add(new tableData(15725, "Calibre XXX", "normal"));
        datos.add(new tableData(35804, "Calibre BMV 25", "retrasada"));
        datos.add(new tableData(1, "Calibre BMV 25", "normal"));
        datos.add(new tableData(1, "Calibre BMV 25", "parada"));
        datos.add(new tableData(5000, "Calibre BMV 25", "parada"));
        datos.add(new tableData(2, "Calibre BMV 25", "normal"));
        
        
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
