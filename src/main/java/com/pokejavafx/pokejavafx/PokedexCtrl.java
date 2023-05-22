/**
 * @author Lara Rodriguez
 */
package com.pokejavafx.pokejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.util.*;

public class PokedexCtrl {
    @FXML
    private Button BtnAnterior;

    @FXML
    private Button BtnClose;

    @FXML
    private Button BtnGoBack;

    @FXML
    private Button BtnSiguiente;

    @FXML
    private ImageView ImgPoke;

    @FXML
    private ImageView ImgPoke1;

    @FXML
    private ImageView ImgPoke2;

    @FXML
    private ImageView ImgPoke3;

    @FXML
    private ImageView ImgPoke4;

    @FXML
    private Label LblPoke;

    @FXML
    private Label LblPoke1;

    @FXML
    private Label LblPoke2;

    @FXML
    private Label LblPoke3;

    @FXML
    private Label LblPoke4;

    @FXML
    private TextField TxtDefensa;

    @FXML
    private TextArea TxtDesc;

    @FXML
    private TextField TxtPeso;

    @FXML
    private TextField TxtTipo;

    //Cargamos la conexion con la BD
    private DBConection pokeDB;
    public void setDBConection(DBConection con){
        pokeDB = con;
    }


    @FXML
    void OnClickAnterior(ActionEvent event) {
        //TODO: Con este boton, se tiene que mover el array/cosa un puesto hacia atras en la pokedex
    }

    @FXML
    void OnClickClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnClickGoBack(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("PokeJavaFX");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Stage stagePrincipal = (Stage) BtnGoBack.getScene().getWindow();
        stagePrincipal.close();
    }

    @FXML
    void OnClickSiguiente(ActionEvent event) {
        //TODO: Con este boton, se mueve 1 puesto hacia delante
    }
}
