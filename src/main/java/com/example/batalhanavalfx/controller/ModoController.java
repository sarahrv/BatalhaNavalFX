package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModoController {
    private Player playerUm;
    private Player playerDois;
    private Stage stage;
    private Scene scene;


    public void setPlayer(Player playerUm, Player playerDois) {
        this.playerUm = playerUm;
        this.playerDois = playerDois;
    }

    public void switchToDefesaController(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/defesa-view.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DefesaController controller = loader.getController();
        String normal = "normal";
        playerUm.setModo(normal);
        playerDois.setModo(normal);
        controller.setPlayer(playerUm,playerDois);
        controller.initialize(playerUm);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDefesaCustomController(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/defesa-view.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DefesaController controller = loader.getController();
        String custom = "custom";
        playerUm.setModo(custom);
        playerDois.setModo(custom);
        controller.setPlayer(playerUm,playerDois);
        controller.initialize(playerUm);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMenuController(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/menu-view.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
