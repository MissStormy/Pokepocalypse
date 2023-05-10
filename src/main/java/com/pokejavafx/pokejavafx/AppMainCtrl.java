package com.pokejavafx.pokejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AppMainCtrl {
    @FXML
    private Button BtnCrear;

    @FXML
    private Button BtnLogin;
    @FXML
    private TextField TxtCrearPass;

    @FXML
    private TextField TxtCrearUsuario;

    @FXML
    private TextField TxtPass;

    @FXML
    private TextField TxtUsuario;

    @FXML
    void OnClickCrear(ActionEvent event){

    }

    @FXML
    void OnClickLogin(ActionEvent event) throws IOException  {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("PokeJavaFX");
        stage.setScene(scene);
        stage.show();
    }

}