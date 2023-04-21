package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.Player;
import com.example.batalhanavalfx.model.Tabuleiro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import com.example.batalhanavalfx.controller.DefesaController;
import javafx.stage.Stage;

import java.io.IOException;

public class BombasDoisController {
    private Button[][] button;
    @FXML
    private GridPane board;

    private int numCliques = 0;

    private int contaAcertos = 0;
    private Player playerUm;
    private Player playerDois;

    private Stage stage;
    private Scene scene;


    public void getButtonsXY(ActionEvent event) throws IOException{
        Button clickedButton = (Button) event.getSource();
        int row = GridPane.getRowIndex(clickedButton);
        int collumn = GridPane.getColumnIndex(clickedButton);
        int valorCelula = playerUm.getTabuleiro().getMatrizBarcos()[row][collumn].getValorCelula();
        System.out.println("entrou b2:"+playerDois.getNome()+" row "+row+" collumn "+collumn);
        System.out.println(""+playerUm.getTabuleiro().getMatrizBarcos()[row][collumn].getValorCelula());
        System.out.println(playerUm.getNumBarcos());
        if (valorCelula == 1) {
            clickedButton.setStyle("-fx-background-color: red");
            switchPlayers(event);
            checkVitoria();
            numCliques ++;
            contaAcertos ++;
            playerUm.getTabuleiro().getMatrizBarcos()[row][collumn].setValorCelula(2);
        }else{
            clickedButton.setStyle("-fx-background-color: blue");
            switchPlayers(event);
            numCliques ++;
            playerUm.getTabuleiro().getMatrizBarcos()[row][collumn].setValorCelula(3);
        }

    }
    public void setPlayer(Player playerUm, Player playerDois){
        this.playerUm = playerUm;
        this.playerDois = playerDois;
    }
    public void switchPlayers(ActionEvent event) throws IOException {
        if(numCliques == 4){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/bomba-view.fxml"));
            Parent root = loader.load();
            BombasController controller = loader.getController();
            controller.setPlayer(playerUm, playerDois);
            controller.updateBoard();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void updateBoard() {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                int cellValue = playerUm.getTabuleiro().getMatrizBarcos()[row][column].getValorCelula();
                Button button = (Button) board.getChildren().get(row + column * 10);
                if (cellValue == 2) {
                    button.setStyle("-fx-background-color: red;");
                } else if (cellValue == 3) {
                    button.setStyle("-fx-background-color: blue;");
                }

            }
        }
    }

    public void checkTamanhoDoBarco(){

    }
    public void checkVitoria(){
        if (contaAcertos == playerUm.getNumBarcos()){
            //tela de vitoria
        }

    }
}



