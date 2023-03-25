package com.example.batalhanavalfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class BombasController {
    private Button[][] button;
    private Label[][] labelP1;
    private Label[][] labelP2;
    @FXML
    private GridPane board;
    private boolean isPlayerUm;
    private int row;
    private int collumn;

    public void getButtonsXY(ActionEvent event){
        Button clickedButton = (Button) event.getSource();
        this.row = GridPane.getRowIndex(clickedButton);
        this.collumn = GridPane.getColumnIndex(clickedButton);
        System.out.println(this.collumn);
        if(isPlayerUm){
            if(labelP1[row][collumn].equals("1")){
                System.out.println("acertou miseravi");
            }
        }
        System.out.println(row);
    }

    public void setLabelP1(Label[][] labelP1) {
        this.labelP1 = labelP1;
    }

    public void setLabelP2(Label[][] labelP2) {
        this.labelP2 = labelP2;
    }

    public void setPlayerUm(boolean playerUm) {
        isPlayerUm = playerUm;
    }
}



