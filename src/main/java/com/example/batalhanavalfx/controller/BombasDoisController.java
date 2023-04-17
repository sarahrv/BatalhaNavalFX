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
    private boolean isPlayerUm;
    private int row;
    private int collumn;

    private int numCliques = 0;
    private Player playerAtual;

    private int contaAcertos = 0;
    private Player playerUm;
    private Player playerDois;

    private Stage stage;
    private Scene scene;


    //começa com playerUm = playerAtual, depois analisa o numero de cliques pra ver se já vai trocar pra o playerDois
    //se playerAtual = playerUm, tem pegar o tabuleiro do player dois
    //ou seja,playerAtual mexe com tabuleiroInimigo
    //como atualizar o tabuleiro? se a celula for 2, o botão nessa coordenada fica vermelho
    //como atualizar a bombasview?
    //lembrar de fazer


    public void getButtonsXY(ActionEvent event) throws IOException{
        Button clickedButton = (Button) event.getSource();
        this.row = GridPane.getRowIndex(clickedButton);
        this.collumn = GridPane.getColumnIndex(clickedButton);
        int valorCelula = playerUm.getTabuleiro().getMatrizCelulas()[row][collumn].getValorCelula();
        if (valorCelula == 1) {
            clickedButton.setStyle("-fx-background-color: red;");

            switchPlayers(event);
            checkVitoria();
            numCliques ++;
            contaAcertos ++;
            playerUm.getTabuleiro().getMatrizCelulas()[row][collumn].setValorCelula(2);
            updateBoard();
        }else{
            clickedButton.setStyle("-fx-background-color: blue");
            switchPlayers(event);
            numCliques ++;
            valorCelula = 3;
            playerUm.getTabuleiro().getMatrizCelulas()[row][collumn].setValorCelula(3);
            updateBoard();
        }

    }
    public void setPlayer(Player playerUm, Player playerDois){
        this.playerUm = playerUm;
        this.playerDois = playerDois;
    }
    public void switchPlayers(ActionEvent event) throws IOException {
        if(numCliques == 4){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/bomba-dois-view.fxml"));
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
    public void updateBoard(){
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                if(playerUm.getTabuleiro().getMatrizCelulas()[row][collumn].getValorCelula() == 2){
                    Button button = (Button) board.getChildren().get(row * 10 + column);
                    button.setStyle("-fx-background-color: red;");
                } else if (playerUm.getTabuleiro().getMatrizCelulas()[row][collumn].getValorCelula() == 3){


                }

            }
        }

    }

    public void checkTamanhoDoBarco(){

    }
    public void checkVitoria(){
        //if contaAcertos do player atual == numero de celulas, player atual venceu
        //ir para nova tela//alert que mostra a vitoria do player

    }
}



