package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BombasController extends AbstractBombasController {
    @FXML
    private GridPane board;

    public int getNumCliques() {
        return numCliques;
    }

    public void setNumCliques(int numCliques) {
        this.numCliques = numCliques;
    }

    private int numCliques = 0;
    private Player playerUm;
    private Player playerDois;

    private Stage stage;
    private Scene scene;


    public void getButtonsXY(ActionEvent event) throws IOException{
        switchPlayers(event);
        if (numCliques == 4) {
            return;
        }

        Button clickedButton = (Button) event.getSource();
        int row = GridPane.getRowIndex(clickedButton);
        int collumn = GridPane.getColumnIndex(clickedButton);
        int valorCelula = playerDois.getTabuleiro().getMatrizBarcos()[row][collumn].getValorCelula();
        System.out.println("entrou:" + playerUm.getNome() + " row " + row + " collumn " + collumn);
        System.out.println("" + playerDois.getTabuleiro().getMatrizBarcos()[row][collumn].getValorCelula());

        if (valorCelula == 1) {
            clickedButton.setStyle("-fx-background-color: red;");
            numCliques ++;
            playerUm.setNumTiros(numCliques);
            checkVitoria();
            clickedButton.setDisable(true);
            playerDois.getTabuleiro().getMatrizBarcos()[row][collumn].setValorCelula(2);

        } else {
            clickedButton.setStyle("-fx-background-color: blue;");
            numCliques ++;
            playerUm.setNumTiros(numCliques);
            clickedButton.setDisable(true);
            playerDois.getTabuleiro().getMatrizBarcos()[row][collumn].setValorCelula(3);
        }

    }


    public void setPlayer(Player playerUm, Player playerDois) {
        this.playerUm = playerUm;
        this.playerDois = playerDois;
    }

    public void switchPlayers(ActionEvent event) throws IOException {
        checkVitoria();
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




    public void escreveAqrquivo(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(content);
        writer.newLine();
        writer.close();
    }

    public void saveVencedor(Player vencedor) throws IOException {
        String fileName = "vencedores.txt";
        String nome = vencedor.getNome();
        int numCliques = vencedor.getNumTiros();
        String conteudo = nome + "-" + numCliques;
        escreveAqrquivo(fileName, conteudo);
    }

    public void checkVitoria() throws IOException {
        boolean playerAindaTemBarco = false;
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                int cellValue = playerDois.getTabuleiro().getMatrizBarcos()[row][column].getValorCelula();
                if (cellValue == 1) {
                    playerAindaTemBarco = true;
                    break;
                }
            }
            if (playerAindaTemBarco) {
                break;
            }


        }if (!playerAindaTemBarco) {
            saveVencedor(playerUm);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Você ganhou," + playerUm.getNome() + "!" +"Clique em 'OK' para voltar para o menu.", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/menu-view.fxml"));
                Parent root = loader.load();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

}



