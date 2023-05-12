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
    void OnClickClicker(ActionEvent event) throws IOException {
        //TODO: Hacer pantalla de clicker
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("clicker.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
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
        Scene scene = new Scene(fxmlLoader.load());
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
        Scene scene = new Scene(fxmlLoader.load());
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
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Stage stagePrincipal = (Stage) BtnTienda.getScene().getWindow();
        stagePrincipal.close();
    }
}
