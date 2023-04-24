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
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.NoSuchElementException;

public class MenuController {
    @FXML
    private Button jogar;
    @FXML
    private Button ranking;
    private Scene scene;
    private Parent root;
    private Stage stage;
    @FXML
    private VBox scenePane;
    @FXML
    private Button fecharTela;


    public void onRankingAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/ranking-view.fxml"));
        Parent root = loader.load();
        RankingController controller = loader.getController();
        controller.displayWinners();
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToPlayerController(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/player-view.fxml"));
        Parent root = loader.load();
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*public void switchToModoController(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/modo-view.fxml"));
        Parent root = loader.load();
        ModoController controller = loader.getController();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/

    public void sairTelaAction(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Você está prestes a abandonar a tripulação.");
        alert.setContentText("Sair do jogo?");
        if(alert.showAndWait().isPresent()){
            if(alert.showAndWait().get()== ButtonType.OK){
                stage=(Stage) scenePane.getScene().getWindow();
                stage.close();

        }
        }
    }
}