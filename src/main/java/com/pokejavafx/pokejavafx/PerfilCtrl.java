/**
 * @author Lara Rodriguez
 */
package com.pokejavafx.pokejavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableView<Pokimon> TbwCapturas;

    private DBConection pokeDB;
    public void setDBConection(DBConection con){ pokeDB = con; }
    private User user1;
    public void setUser1(User user){ user1 = user;
    LblPerfil.setText(user1.getUsername());
    ImgUsr.setImage(user1.getImage());
    }

    ObservableList<Pokimon> pokimonsCapturados;
    public void setCapturados(Pokimon[] pokimons){
        this.pokimonsCapturados = FXCollections.observableArrayList(pokimons);
        TableColumn Tbc1 = new TableColumn<>("Pokimon");
        TableColumn Tbc2 = new TableColumn<>("Tipo");
        Tbc1.setPrefWidth(TbwCapturas.getPrefWidth()/2);
        Tbc2.setPrefWidth(TbwCapturas.getPrefWidth()/2);
        Tbc1.setEditable(false);
        Tbc2.setEditable(false);
        Tbc1.setCellValueFactory(
                new PropertyValueFactory<Pokimon,String>("nombre")
        );
        Tbc2.setCellValueFactory(
                new PropertyValueFactory<Pokimon,String>("tipo")
        );
        TbwCapturas.setItems(pokimonsCapturados);
        TbwCapturas.getColumns().addAll(Tbc1,Tbc2);
    }

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
    void OnClickCerrarSesion(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("login.fxml"));
        //Para enviar la conexion de bases de datos
        Parent root = fxmlLoader.load();
        AppMainCtrl controller = fxmlLoader.getController();
        controller.setDBConection(pokeDB);
        //cargamos la escena
        Scene scene = new Scene(root, 659, 501);
        Stage stage = new Stage();
        stage.setTitle("PokeJavaFX");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
