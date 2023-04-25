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

    private Stage stage;
    private Scene scene;

    @FXML
    public TextArea winnerTextArea;

    public void displayWinners() {
        try (BufferedReader reader = new BufferedReader(new FileReader("vencedores.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    String nome = parts[0];
                    int numberClicks = Integer.parseInt(parts[1]);
                    String content = nome + " - " + numberClicks + " tiros\n";
                    sb.append(content);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
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




