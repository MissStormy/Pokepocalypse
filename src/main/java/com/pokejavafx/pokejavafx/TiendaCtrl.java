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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TiendaCtrl{
    @FXML
    private AnchorPane APComprar;

    @FXML
    private AnchorPane APTransferir;

    @FXML
    private AnchorPane APVender;

    @FXML
    private Button BtnClose;

    @FXML
    private Button BtnComprar;

    @FXML
    private Button BtnGoBack;

    @FXML
    private Button BtnTransferir;

    @FXML
    private Button BtnVender;

    @FXML
    private ImageView ImgSlot1;

    @FXML
    private ImageView ImgSlot2;

    @FXML
    private ImageView ImgSlot3;

    @FXML
    private ImageView ImgSlot4;

    @FXML
    private Label LblSlot1;

    @FXML
    private Label LblSlot2;

    @FXML
    private Label LblSlot3;

    @FXML
    private Label LblSlot4;
    private DBConection pokeDB;
    private User user1;
    private Objeto[] objs;
    private Objeto obj1;
    private Objeto obj2;
    private Objeto obj3;
    private Objeto obj4;
    public void setInitialValues(DBConection con,User user,Objeto[] objetos){
        pokeDB = con;
        user1 = user;
        objs = objetos;
        obj1 = objetos[(int) (Math.random()*(objs.length-1))];
        obj2 = objetos[(int) (Math.random()*(objs.length-1))];
        obj3 = objetos[(int) (Math.random()*(objs.length-1))];
        obj4 = objetos[(int) (Math.random()*(objs.length-1))];
        LblSlot1.setText(obj1.nombre);
        LblSlot2.setText(obj2.nombre);
        LblSlot3.setText(obj3.nombre);
        LblSlot4.setText(obj4.nombre);
    }

    @FXML
    void OnClickClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnClickComprar(ActionEvent event) {
        APComprar.setVisible(true);
        APVender.setVisible(false);
        APTransferir.setVisible(false);
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
    void OnClickTransferir(ActionEvent event) {
        APComprar.setVisible(false);
        APVender.setVisible(false);
        APTransferir.setVisible(true);
    }

    @FXML
    void OnClickVender(ActionEvent event) {
        APComprar.setVisible(false);
        APVender.setVisible(true);
        APTransferir.setVisible(false);
    }
}
