package com.example.batalhanavalfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BombasController {
    @FXML private GridPane board;


    private int row;


    private int collumn;

    public void getButtonsXY(ActionEvent event){
        //pego a coordenada do botão que eu cliquei
        Button clickedButton = (Button) event.getSource();
        this.row = GridPane.getRowIndex(clickedButton);
        this.collumn = GridPane.getColumnIndex(clickedButton);
        //fazer um if para não retornar null na posição 0,0 (mudar de null para 0,0)
        //fazer array pra salvar os valores clicados
        System.out.println(row);
        }
    }



