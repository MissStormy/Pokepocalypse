/**
 * @author Lara Rodriguez
 */
package com.pokejavafx.pokejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

public class TiendaCtrl implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO: Imagino que lo de sacar cuatro objetos de la base de datos y meterlos en cada run se hace desde el inicio con esto
    }
}
