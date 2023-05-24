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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class PokedexCtrl{
    public ImageView ImgPoke;
    public AnchorPane AnchList;
    public AnchorPane AnchDetalle;
    public ImageView ImgPokeDetalle;
    @FXML
    private Button BtnClose;

    @FXML
    private Button BtnGoBack;

    @FXML
    private Button BtnPokeLista;

    @FXML
    private Button BtnPokeVista;

    @FXML
    private Label LblPoke;

    @FXML
    private Label LblPoke1;

    @FXML
    private Label LblPoke2;

    @FXML
    private Label LblPoke3;

    @FXML
    private Label LblPoke4;

    @FXML
    private Label LblPokeName;

    @FXML
    private Label LblTipo;

    @FXML
    private TextField TxtAtaque;

    @FXML
    private TextField TxtDefensa;

    @FXML
    private TextArea TxtDescripcion;

    @FXML
    private TextField TxtPeso;

    private DBConection pokeDB;
    private User user1;
    private Pokimon[] pokedex;
    int current = 0; //current pokemon in display
    public void setInitialValues(DBConection con,User user,Pokimon[] pkdx){
        pokeDB = con;
        user1 = user;
        pokedex = pkdx;
        refresh();
    }
    private void refresh(){
        LblPoke.setText(pokedex[current].nombre);
        LblTipo.setText(pokedex[current].tipo);
        int poke1 = current-2;
        int poke2 = current-1;
        int poke3 = current+1;
        int poke4 = current+2;
        if(current<2){
            poke1 += pokedex.length;
        }
        if(current==0){
            poke2 += pokedex.length;
        }
        if(current==pokedex.length-1){
            poke3 += -pokedex.length;
        }
        if(current>pokedex.length-3){
            poke4 += -pokedex.length;
        }
        LblPoke1.setText(poke1+1 + " " + pokedex[poke1].nombre);
        LblPoke2.setText(poke2+1 + " " + pokedex[poke2].nombre);
        LblPoke3.setText(poke3+1 + " " + pokedex[poke3].nombre);
        LblPoke4.setText(poke4+1 + " " + pokedex[poke4].nombre);
        ImgPoke.setImage(pokedex[current].img);
        LblPokeName.setText(pokedex[current].nombre);
        TxtDescripcion.setText(pokedex[current].descripcion);
        TxtAtaque.setText(""+pokedex[current].atq);
        TxtDefensa.setText(""+pokedex[current].def);
        TxtPeso.setText(""+pokedex[current].peso);
        ImgPokeDetalle.setImage(pokedex[current].img);
    }
    @FXML
    void OnClickAnterior(ActionEvent event) {
        current += -1;
        if (current<0){current=pokedex.length-1;}
        refresh();
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
    void OnClickSiguiente(ActionEvent event) {
        current += 1;
        if (current>pokedex.length-1){current=0;}
        refresh();
    }
    @FXML
    void OnClickPokeLista(ActionEvent event) {
        AnchList.setVisible(true);
        AnchDetalle.setVisible(false);
    }

    @FXML
    void OnClickPokeVista(ActionEvent event) {
        AnchList.setVisible(false);
        AnchDetalle.setVisible(true);
    }
}
