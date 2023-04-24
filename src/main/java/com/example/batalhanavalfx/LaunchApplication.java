package com.example.batalhanavalfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class LaunchApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LaunchApplication.class.getResource("view/menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle("Batalha Naval");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            sairTelaAction(stage);
        });
    }

    public void sairTelaAction(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Você está prestes a abandonar a tripulação.");
        alert.setContentText("Sair do jogo?");
        if (alert.showAndWait().get() == ButtonType.OK) {

            stage.close();
        }
    }

}