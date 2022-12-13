package com.example.batalhanavalfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class PlayerController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String name;
    @FXML
    private Button voltar;




    public void switchToHelloController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/batalhanavalfx/view/hello-view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void playerName(){
        Scanner name1 = new Scanner(System.in);
        System.out.println("Qual o seu nome? ");
        name = name1.nextLine();
    }
}
