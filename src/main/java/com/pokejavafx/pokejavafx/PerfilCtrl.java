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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.*;

public class PerfilCtrl {
    @FXML
    private Button BtnAbout;

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
    public void setUser1(User user){ user1 = user; }

    /*public void initialize() {
        // Configuración inicial del controlador
        initializeTableView();
    }
    private void initializeTableView() {
        // Inicializar las columnas del TableView
        Tbc1.setCellValueFactory(new PropertyValueFactory<>("data1"));
        Tbc2.setCellValueFactory(new PropertyValueFactory<>("data2"));
    }
    public void showCaptureData() {
        // Mostrar datos de capturas en el TableView
        TxtPerfil.setVisible(false);
        TbwCapturas.setVisible(true);
        //TbwCapturas.setItems(getCaptureData()); // Obtener los datos de la base de datos
    }
    private ObservableList<CaptureData> getCaptureData() {
        // Obtener los datos de la base de datos y retornarlos en una lista ObservableList
        // Aquí debes implementar la lógica para obtener los datos de la base de datos y retornarlos
        // como una lista de objetos CaptureData
        // Por ejemplo:
        ObservableList<CaptureData> data = FXCollections.observableArrayList();
        data.add(new CaptureData("Dato 1", "Dato A"));
        data.add(new CaptureData("Dato 2", "Dato B"));
        return data;
    }*/
    @FXML
    void OnClickAbout(ActionEvent event) {
        TxtPerfil.setVisible(true);
        TbwCapturas.setVisible(false);
        TxtPerfil.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Fusce in ullamcorper erat, pellentesque rutrum orci. " +
                "Aenean aliquam dolor massa, a venenatis nisl mollis in. " +
                "Donec nisi massa, tincidunt sed dapibus vel, dapibus ut nisl. " +
                "Cras hendrerit libero ac lorem dignissim venenatis. " +
                "Maecenas vitae turpis vitae dolor cursus congue nec posuere ipsum. " +
                "Ut ultrices enim eget tincidunt tincidunt. Mauris pulvinar dapibus libero, " +
                "non pharetra mi imperdiet id. Aenean rutrum, dolor quis egestas venenatis, " +
                "nisl tellus viverra diam, eleifend auctor urna elit cursus eros. .");
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
    void OnClickAplicarDesc(ActionEvent event) {

    }

    @FXML
    void OnClickAplicarNombre(ActionEvent event) {

    }

    @FXML
    void OnClickBorrarTodo(ActionEvent event) {

    }

    @FXML
    void OnClickCerrarSesion(ActionEvent event) {

    }
}
