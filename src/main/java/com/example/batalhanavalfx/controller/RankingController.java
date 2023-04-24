package com.example.batalhanavalfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class RankingController {

    @FXML
    public TextArea winnerTextArea;
    private Stage stage;
    private Scene scene;

    //botao pra voltar pro menu
    //um ranking pra cada modo?
    public void displayWinners() throws NullPointerException{
        try (BufferedReader reader = new BufferedReader(new FileReader("vencedores.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            winnerTextArea.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
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




