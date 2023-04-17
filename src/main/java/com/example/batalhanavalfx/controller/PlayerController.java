package com.example.batalhanavalfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.batalhanavalfx.model.Player;
import com.example.batalhanavalfx.model.Tabuleiro;
import java.io.IOException;
import com.example.batalhanavalfx.controller.DefesaController;


public class PlayerController {
    private Stage stage;
    private Scene scene;
    private String playerName;
    @FXML
    private Button voltar;
    @FXML
    private Button proximo;

    @FXML
    private TextField nomePlayerUm;

    @FXML
    private TextField nomePlayerDois;

    public Player playerUm;

    public Player playerDois;

    protected Tabuleiro tabuleiroUm;

    protected Tabuleiro tabuleiroDois;



    public void switchToMenuController(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/menu-view.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToDefesaController(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/defesa-view.fxml"));
        Parent root = loader.load();
        DefesaController controller = loader.getController();
        String nomeUm = nomePlayerUm.getText();
        String nomeDois = nomePlayerDois.getText();
        Player playerUm = new Player(nomeUm, new Tabuleiro());
        Player playerDois = new Player(nomeDois, new Tabuleiro());
        controller.setPlayer(playerUm, playerDois);
        controller.initialize();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
        //if(nomePlayerUm.getText() != null){
        //String nomeUm = nomePlayerUm.getText();
        //if(nomePlayerDois.getText() != null){
          //  String nomeDois = nomePlayerDois.getText();


