package com.pokejavafx.pokejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Desktop;
import java.net.URI;

import java.io.IOException;
import java.net.URISyntaxException;


public class AppMainCtrl{
    @FXML
    private Hyperlink HyperGit;
    @FXML
    private Button BtnClose;
    @FXML
    private Button BtnLogin;
    @FXML
    private Button BtnSignIn;

    @FXML
    private Button BtnSignUp;
    @FXML
    private TextField txtCrearEmail;

    @FXML
    private TextField txtCrearPass;

    @FXML
    private TextField txtCrearUser;

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUser;
    @FXML
    private AnchorPane APSignIn;

    @FXML
    private AnchorPane APSignUp;

    //Cargamos la conexion con la BD
    private DBConection pokeDB;
    public void setDBConection(DBConection con){
        pokeDB = con;
    }
    //Ya hemos cargado la conexion con BD
    void login(User user1) throws IOException {
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

        Stage stagePrincipal = (Stage) BtnLogin.getScene().getWindow();
        stagePrincipal.close();
    }
    @FXML
    void OnClickCrear(ActionEvent event) {
        //TODO: Aqui hay que meter la conexion y queries para guardar los datos en la BBDD
        String user = txtCrearUser.getText();
        String pass = txtCrearPass.getText();
        if (pokeDB.signup(user,pass,"")){
            //todo mensaje de que se ha creado bien el usuario
        }else {
            //todo mensaje de que el usuario ya existe
        }
    }

    @FXML
    void OnClickLogin(ActionEvent event) throws IOException  {
        String user = txtUser.getText();
        String pass = txtPass.getText();

        User user1 = pokeDB.login(user,pass);
        if(user1!=null){
            login(user1);
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error de login");
            alert.setContentText("Error, la contraseña o el user estan mal. En caso de que no tenga cuenta" +
                    " vaya a sign up para crear una");
            alert.showAndWait();

        }
    }
    @FXML
    void OnClickSignIn(ActionEvent event) {
        APSignIn.setVisible(true);
        APSignUp.setVisible(false);
    }

    @FXML
    void OnClickSignUp(ActionEvent event) {
        APSignIn.setVisible(false);
        APSignUp.setVisible(true);
    }
    @FXML
    void OpenGitHub(ActionEvent event) throws URISyntaxException, IOException {
        //Un hyperlink que lleva a la pagina de GitHub
        Desktop.getDesktop().browse(new URI("https://github.com/MissStormy/PokeJavaFX"));
    }

    @FXML
    void OnClickClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }



}