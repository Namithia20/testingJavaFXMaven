/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mycompany.models.user;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private TextField nickText;

    @FXML
    private PasswordField passText;

    @FXML
    private Button bLogin;

    @FXML
    void login(ActionEvent event) throws UnirestException {
        
        String url = "http://10.1.0.43/prueba/index.php";
        
        HttpResponse<String> cad = Unirest.post(url).header("accept", "application/json").field("nick", nickText.getText()).field("pass", passText.getText()).asString();
        
        System.out.println(cad.getBody());
        
        Gson gson = new Gson();
        user[] u = gson.fromJson( cad.getBody(), user[].class);
        
        if(u.length > 0)
        {
            System.out.println("Usuario: "+u[0].getNick()+" Primer login: "+u[0].getFirstLogin());
        }
        else
        {
            System.out.println("No encontrado");
        }
    }
    
    
}
