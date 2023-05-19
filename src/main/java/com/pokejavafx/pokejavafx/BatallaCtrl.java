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
    //Cargamos la conexion con la BD
    private DBConection pokeDB;
    public void setDBConection(DBConection con){
        pokeDB = con;
    }
    @FXML
    void OnClickAtrapar(ActionEvent event) {

    }

    @FXML
    void OnClickHuir(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("PokeJavaFX");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Stage stagePrincipal = (Stage) BtnHuir.getScene().getWindow();
        stagePrincipal.close();
    }
}
