package com.pokejavafx.pokejavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppMain extends Application {
    private  DBConection pokeDB;
    @Override
    public void start(Stage stage) throws IOException {
        pokeDB = new DBConection("jdbc:mysql://localhost:3306/pokejava?serverTimezone=UTC","root","verysecret");
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("login.fxml"));
        //Para enviar la conexion de bases de datos
        Parent root = fxmlLoader.load();
        AppMainCtrl controller = fxmlLoader.getController();
        controller.setDBConection(pokeDB);
        //va a dar conflicto, ~~SI~~ PUES NO
        Scene scene = new Scene(root, 659, 501);
        stage.setTitle("PokeJavaFX");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public void stop(){

        pokeDB.cerrar();
    }

    public static void main(String[] args) {

        launch();
    }
}