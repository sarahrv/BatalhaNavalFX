package com.example.batalhanavalfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class BombasController {
    private Button[][] button;
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
        }
        System.out.println(row);
    }

    public void setPlayerUm(boolean playerUm) {
        isPlayerUm = playerUm;
    }
}



