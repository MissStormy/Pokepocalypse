/**
 * @author Lara Rodriguez
 */
package com.pokejavafx.pokejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
<<<<<<< HEAD
    private DBConection pokeDB;
    private User user1;
    private Pokimon[] pokedex;
    public void setInitialValues(DBConection con,User user,Pokimon[] pokimons){
        pokeDB = con;
        user1 = user;
        pokedex = pokimons;
    }

=======
<<<<<<< Updated upstream
>>>>>>> parent of 94951d9 (Pokedex terminada)
    //Cargamos la conexion con la BD
    //private DBConection pokeDB;
    public void setDBConection(DBConection con){
        pokeDB = con;
    }
=======
    @FXML
    private TableColumn<?, ?> TbcPokedex1;

>>>>>>> Stashed changes
    @FXML
    private TableColumn<?, ?> TbcPokedex2;

    @FXML
    private TableView<?> TbvPokedex;
    @FXML
    void OnClickAnterior(ActionEvent event) {

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
        //Para enviar la conexion de bases de datos
        Parent root = fxmlLoader.load();
        HomeCtrl controller = fxmlLoader.getController();
        controller.setDBConection(pokeDB);
        //para enviar el usuario
        controller.setUser1(user1);
        //cargamos la escena
        Scene scene = new Scene(root);
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
