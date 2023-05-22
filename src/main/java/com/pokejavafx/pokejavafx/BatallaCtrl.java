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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.*;

public class BatallaCtrl {
    @FXML
    private Button BtnAtrapar;

    @FXML
    private Button BtnHuir;

    @FXML
    private TextArea TxtBattle;
    private DBConection pokeDB;
    private User user1;
    public void setDBConection(DBConection con){ pokeDB = con; }
    public void setUser1(User user){
        user1 = user;
    }
    @FXML
    void OnClickAtrapar(ActionEvent event) {

    }

    @FXML
    void OnClickHuir(ActionEvent event) throws IOException {
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

        Stage stagePrincipal = (Stage) BtnHuir.getScene().getWindow();
        stagePrincipal.close();
    }
}
