/**
 * @author Lara Rodriguez
 */
package com.pokejavafx.pokejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HomeCtrl implements Initializable {
    @FXML
    private Button BtnClicker;

    @FXML
    private Button BtnClose;

    @FXML
    private Button BtnPerfil;

    @FXML
    private Button BtnPokedex;

    @FXML
    private Button BtnTienda;
    @FXML
    private TextArea TxtWelcome;

    //Cargar base de datos
    private DBConection pokeDB;
    private User user1;
    public void setDBConection(DBConection con){ pokeDB = con; }
    public void setUser1(User user){
        user1 = user;
        TxtWelcome.setText("Bienvenido de vuelta " + user1.getUsername());
    }
    @FXML
    void OnClickClicker(ActionEvent event) throws IOException {
        //TODO: Hacer pantalla de clicker
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("clicker.fxml"));
        //Para enviar la conexion de bases de datos
        Parent root = fxmlLoader.load();
        ClickerCtrl controller = fxmlLoader.getController();
        controller.setDBConection(pokeDB);
        //para enviar el usuario
        controller.setUser1(user1);
        //cargamos la escena
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Stage stagePrincipal = (Stage) BtnClicker.getScene().getWindow();
        stagePrincipal.close();

    }

    @FXML
    void OnClickClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnClickPerfil(ActionEvent event) throws IOException {
        //TODO: Hacer perfil
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("perfil.fxml"));
        //Para enviar la conexion de bases de datos
        Parent root = fxmlLoader.load();
        PerfilCtrl controller = fxmlLoader.getController();
        controller.setDBConection(pokeDB);
        //para enviar el usuario
        controller.setUser1(user1);
        //cargamos la escena
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Stage stagePrincipal = (Stage) BtnPerfil.getScene().getWindow();
        stagePrincipal.close();
    }

    @FXML
    void OnClickPokedex(ActionEvent event) throws IOException {
        //TODO: Hacer pokedex
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("pokedex.fxml"));
        //Para enviar la conexion de bases de datos
        Parent root = fxmlLoader.load();
        PokedexCtrl controller = fxmlLoader.getController();
        controller.setDBConection(pokeDB);
        //para enviar el usuario
        controller.setUser1(user1);
        //cargamos la escena
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Stage stagePrincipal = (Stage) BtnPokedex.getScene().getWindow();
        stagePrincipal.close();
    }

    @FXML
    void OnClickTienda(ActionEvent event) throws IOException {
        //TODO: Hacer tienda
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("tienda.fxml"));
        //Para enviar la conexion de bases de datos
        Parent root = fxmlLoader.load();
        TiendaCtrl controller = fxmlLoader.getController();
        controller.setDBConection(pokeDB);
        //para enviar el usuario
        controller.setUser1(user1);
        //cargamos la escena
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Stage stagePrincipal = (Stage) BtnTienda.getScene().getWindow();
        stagePrincipal.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
