package com.example.batalhanavalfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private Button jogar;

    @FXML
    private Button ranking;
    private Scene scene;
    private Parent root;
    private Stage stage;

    public void onRankingAction(){
        System.out.println("Ranking");
    }


    public void switchToPlayerController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/batalhanavalfx/view/player-view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private VBox scenePane;
    @FXML
    private Button fecharTela;
    public void sairTelaAction(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Você está prestes a abandonar a tripulação.");
        alert.setContentText("Sair do jogo?");
        if(alert.showAndWait().get()== ButtonType.OK){
            stage=(Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }
}