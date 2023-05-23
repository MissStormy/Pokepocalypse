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
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClickerCtrl implements Initializable {
    @FXML
    private Label LbProgress;
    @FXML
    private Button BtnCaminar;

    @FXML
    private Button BtnClose;

    @FXML
    private Button BtnGoBack;
    @FXML
    private ImageView ImgChibi;

    @FXML
    private ProgressBar PgBar;
    double progress = 0.0;

    //Cargar base de datos
    private DBConection pokeDB;
    private User user1;
    private Pokimon[] pokedex;
    public void setInitialValues(DBConection con,User user,Pokimon[] pokimons) {
        pokeDB = con;
        user1 = user;
        pokedex = pokimons;

    }
    @FXML
    void OnClickCamina(ActionEvent event) throws IOException {
        //TODO: Arreglar esto Vera, por el amor de Nyachan que me da algo
        //TODO: No consigo enterarme de como mover al personaje
        if(progress < 1){
            progress += 0.1;
            PgBar.setProgress(progress);
            LbProgress.setText(Integer.toString((int)Math.round(progress*100)) + " Pasos dados");
        }else {
            FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("batalla.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("PokeJavaFX");
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

            Stage stagePrincipal = (Stage) BtnCaminar.getScene().getWindow();
            stagePrincipal.close();
        }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PgBar.progressProperty().bindBidirectional(ImgChibi.translateXProperty());
    }
}
