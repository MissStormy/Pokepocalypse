package com.pokejavafx.pokejavafx;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Desktop;
import java.net.URI;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;



public class AppMainCtrl {
    @FXML
    private Hyperlink HyperGit;
    @FXML
    private Button BtnClose;
    @FXML
    private Button BtnLogin;
    @FXML
    private TextField txtCrearEmail;

    @FXML
    private TextField txtCrearPass;

    @FXML
    private TextField txtCrearUser;

    @FXML
    private TextField txtPass;

    @FXML
    private TextField txtUser;

    void login() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("PokeJavaFX");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Stage stagePrincipal = (Stage) BtnLogin.getScene().getWindow();
        stagePrincipal.close();
    }
    @FXML
    void OnClickCrear(ActionEvent event) {
        //TODO: Aqui hay que meter la conexion y queries para guardar los datos en la BBDD
    }

    @FXML
    void OnClickLogin(ActionEvent event) throws IOException  {
        //TODO: Conexion con BBDD
        //TODO: Array de backup mientras descubrimos como hacer la conexion
        String user = txtUser.getText();
        String pass = txtPass.getText();


        if(user.equals("Stormy") && pass.equals("1234")){
            login();
        } else if (user.equals("Lokka") & pass.equals("4321")) {
            login();
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error de login");
            alert.setContentText("Error, la contraseña o el user estan mal. En caso de que no tenga cuenta" +
                    "vaya a sign up para crear una");
            alert.showAndWait();

        }


    }

    @FXML
    void OpenGitHub(ActionEvent event) throws URISyntaxException, IOException {
        //Un hyperlink que lleva a la pagina de GitHub
        Desktop.getDesktop().browse(new URI("https://github.com/MissStormy/PokeJavaFX"));
    }

    @FXML
    void OnClickClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}