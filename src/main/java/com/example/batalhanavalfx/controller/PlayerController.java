package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.exception.InputInvalidoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.batalhanavalfx.model.Player;
import com.example.batalhanavalfx.model.Tabuleiro;
import java.io.IOException;

public class PlayerController {
    private Stage stage;
    private Scene scene;
    @FXML
    private Button voltar;
    @FXML
    private Button proximo;

    @FXML
    private TextField nomePlayerUm;

    @FXML
    private TextField nomePlayerDois;

    public void errorAnimation(Node error, Label errorLabel){
        error.setStyle("-fx-border-color: red; -fx-border-windth: 2px;");
        errorLabel.setStyle("-fx-background-color: #ff0000");
    }


    public void switchToMenuController(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/menu-view.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToModoController(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/modo-view.fxml"));
            Parent root = loader.load();
            ModoController controller = loader.getController();
            String nomeUm = nomePlayerUm.getText();
            String nomeDois = nomePlayerDois.getText();
            int numBarcosUm = 0;
            int numBarcosDois = 0;
            if (nomeUm.length() < 3 || nomeDois.length() < 3) {
                throw new InputInvalidoException();
            }
            Player playerUm = new Player(nomeUm, new Tabuleiro(), numBarcosUm, null);
            Player playerDois = new Player(nomeDois, new Tabuleiro(), numBarcosDois, null);
            controller.setPlayer(playerUm, playerDois);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (InputInvalidoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }



}


