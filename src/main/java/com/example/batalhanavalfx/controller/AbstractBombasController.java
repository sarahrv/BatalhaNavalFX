package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractBombasController implements IControllerTabuleiros {

        @FXML
        private GridPane board;
        private int numCliques = 0;
        private int contaAcertos = 0;
        private Player playerUm;
        private Player playerDois;

        private Stage stage;
        private Scene scene;


        public abstract void getButtonsXY(ActionEvent event) throws IOException;

        public abstract void setPlayer(Player playerUm, Player playerDois);

        public abstract void switchPlayers(ActionEvent event) throws IOException;

        public void updateBoard(Player player) {
            for (int row = 0; row < 10; row++) {
                for (int column = 0; column < 10; column++) {
                    int cellValue = player.getTabuleiro().getMatrizBarcos()[row][column].getValorCelula();
                    Button button = (Button) board.getChildren().get(row + column * 10);
                    if (cellValue == 2) {
                        button.setStyle("-fx-background-color: red;");
                        button.setDisable(true);
                    } else if (cellValue == 3) {
                        button.setStyle("-fx-background-color: blue;");
                        button.setDisable(true);
                    }

                }
            }
        }


        public abstract void checkVitoria() throws IOException;
    }





