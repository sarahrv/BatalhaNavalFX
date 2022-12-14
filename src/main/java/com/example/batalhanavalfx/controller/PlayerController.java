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
    private String playerName;
    @FXML
    private Button voltar;
    @FXML
    private Button proximo;




    public void switchToHelloController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/batalhanavalfx/view/hello-view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void name(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu nome");
        playerName = input.nextLine();

        if (playerName.length()<=2 || playerName.length()>=16){
            System.out.println("Digite um nome entre 3 e 15 caracteres.");
            playerName = input.nextLine();
        }
    }
    public void switchToTabuleiroController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/batalhanavalfx/view/tabuleiroController.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*public void playerName(){
        Scanner name1 = new Scanner(System.in);
        System.out.println("Qual o seu nome? ");
        playerName = name1.nextLine();
        System.out.println("Digite seu nome");
        playerName = input.nextLine();

        if (playerName.length()<=2 || playerName.length()>=16){
            while (playerName.length()<=2 || playerName.length()>=16){
                System.out.println("Digite um nome entre 3 e 15 caracteres.");
                playerName = input.nextLine();
            }
        }
    }*/
}
