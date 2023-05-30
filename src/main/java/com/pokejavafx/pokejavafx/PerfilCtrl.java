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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.*;

public class PerfilCtrl {
    public ImageView ImgUsr;
    @FXML
    private Button BtnAbout;
    @FXML
    private Button BtnAjustes;

    @FXML
    private Button BtnCerrarSesion;
    @FXML
    private Button BtnClose;

    @FXML
    private Button BtnGoBack;

    @FXML
    private Button BtnHunts;

    @FXML
    private Label LblPerfil;

    @FXML
    private TextArea TxtPerfil;
    @FXML
    private TableView<?> TbwCapturas;
    @FXML
    private TableColumn<?, ?> Tbc1;

    @FXML
    private TableColumn<?, ?> Tbc2;

    private DBConection pokeDB;
    public void setDBConection(DBConection con){ pokeDB = con; }
    private User user1;
    public void setUser1(User user){ user1 = user;
    LblPerfil.setText(user1.getUsername());
    ImgUsr.setImage(user1.getImage());
    }
    
    @FXML
    void OnClickAbout(ActionEvent event) {
        TxtPerfil.setVisible(true);
        TbwCapturas.setVisible(false);
        TxtPerfil.setText(user1.getLore());
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
    void OnClickHunts(ActionEvent event) {
        TxtPerfil.setVisible(false);
        TbwCapturas.setVisible(true);
    }
    @FXML
    void OnClickAjustes(ActionEvent event) {

    }

    @FXML
    void OnClickCerrarSesion(ActionEvent event) {

    }
}
