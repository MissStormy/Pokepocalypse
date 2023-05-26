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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.math.*;

public class BatallaCtrl implements Initializable {
    @FXML
    private Button BtnAtrapar;

    public ImageView ImgBattle;
    @FXML
    private Button BtnHuir;

    @FXML
    private TextArea TxtBattle;
    private DBConection pokeDB;
    private User user1;
    private Pokimon[] pokedex;
    public void setInitialValues(DBConection con,User user,Pokimon[] pokimons) {
        pokeDB = con;
        user1 = user;
        pokedex = pokimons;
        Pokimon pokemon = pokimons[(int)(Math.random()*(pokimons.length-1))];
        TxtBattle.setText("Ante ti hay un " + pokemon.nombre);
        ImgBattle.setImage(pokemon.img);


    }

    @FXML
    void OnClickAtrapar(ActionEvent event) {
        //TODO: Aqui se tienen que meter en la tabla jugador_has_pokimon??
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TxtBattle.setEditable(false);
    }
}
