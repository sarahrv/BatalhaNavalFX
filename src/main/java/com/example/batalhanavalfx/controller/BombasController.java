package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class  BombasController extends AbstractBombasController{
    @FXML
    private GridPane board;
    private int numCliques = 0;
    private int contaAcertos = 0;
    private Player playerUm;
    private Player playerDois;

    private Stage stage;
    private Scene scene;

    //criar classe abstrata ou interface
    //ajeitar os cliques (colocar sleep ou alert)
    //fazer ranking

    public void getButtonsXY(ActionEvent event) throws IOException{
        Button clickedButton = (Button) event.getSource();
        int row = GridPane.getRowIndex(clickedButton);
        int collumn = GridPane.getColumnIndex(clickedButton);
        int valorCelula = playerDois.getTabuleiro().getMatrizBarcos()[row][collumn].getValorCelula();
        System.out.println("entrou:" + playerUm.getNome() + " row " + row + " collumn " + collumn);
        System.out.println(playerDois.getNumBarcos());
        System.out.println("" + playerDois.getTabuleiro().getMatrizBarcos()[row][collumn].getValorCelula());
        if (valorCelula == 1) {
            clickedButton.setStyle("-fx-background-color: red;");
            numCliques++;
            contaAcertos++;
            clickedButton.setDisable(true);
            checkVitoria();
            switchPlayers(event);
            playerDois.getTabuleiro().getMatrizBarcos()[row][collumn].setValorCelula(2);

        } else {
            clickedButton.setStyle("-fx-background-color: blue;");
            clickedButton.setDisable(true);
            switchPlayers(event);
            numCliques++;
            playerDois.getTabuleiro().getMatrizBarcos()[row][collumn].setValorCelula(3);
        }

    }

    public void setPlayer(Player playerUm, Player playerDois) {
        this.playerUm = playerUm;
        this.playerDois = playerDois;
    }

    public void switchPlayers(ActionEvent event) throws IOException {
        if (numCliques == 4) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/bombas-dois-view.fxml"));
            Parent root = loader.load();
            BombasDoisController controller = loader.getController();
            controller.setPlayer(playerUm, playerDois);
            controller.updateBoard(playerUm);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }




    public void checkTamanhoDoBarco() {

    }

    public void checkVitoria() throws IOException{
        if (contaAcertos == playerDois.getNumBarcos()) {
            Player vecendor = playerUm;
            saveVencedor(vecendor);
            System.out.println("player um ganhou");
        }

    }
}



