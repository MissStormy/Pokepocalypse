/**
 * @author Lara Rodriguez
 */
package com.pokejavafx.pokejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.*;

public class HomeCtrl {
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
    void OnClickClicker(ActionEvent event) {
        //TODO: Hacer pantalla de clicker

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
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("PokeJavaFX");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    void OnClickPokedex(ActionEvent event) {
        //TODO: Hacer pokedex
    }

    @FXML
    void OnClickTienda(ActionEvent event) {
        //TODO: Hacer tienda
    }
}
