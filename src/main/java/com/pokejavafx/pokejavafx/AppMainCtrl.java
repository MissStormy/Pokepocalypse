package com.pokejavafx.pokejavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AppMainCtrl {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}