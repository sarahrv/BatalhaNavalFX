package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Button jogar;

    public void onJogarAction(){
        System.out.println("Jogar");
    }

    public void onRankingAction(){
        System.out.println("Ranking");
    }

    public void onSairAction(){
        System.out.println("Sair");
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}