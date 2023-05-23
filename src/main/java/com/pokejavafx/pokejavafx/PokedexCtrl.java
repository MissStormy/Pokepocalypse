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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.text.html.ImageView;
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
    private Label LblPoke;

    @FXML
    private ListView<?> LvPokedex;

    @FXML
    private TextField TxtAltura;

    @FXML
    private TextField TxtAtq1;

    @FXML
    private TextField TxtAtq2;

    @FXML
    private TextField TxtAtq3;

    @FXML
    private TextField TxtAtq4;

    @FXML
    private TextField TxtEvolucion;

    @FXML
    private TextField TxtPeso;

    @FXML
    private TextField TxtTipo;


    @FXML
    void OnClickAnterior(ActionEvent event) {

    }
    private DBConection pokeDB;
    private User user1;
    private Pokimon[] pokedex;
    public void setInitialValues(DBConection con,User user,Pokimon[] pkdx){
        pokeDB = con;
        user1 = user;
        pokedex = pkdx;
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

    }
}
