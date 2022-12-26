package com.example.batalhanavalfx.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TabuleiroController {
    @FXML private GridPane board;

    public void getButtonsXY(ActionEvent event){
        //pego a coordenada do botão que eu cliquei
        Button clickedButton = (Button) event.getSource();
        int row = GridPane.getRowIndex(clickedButton);
        int collumn = GridPane.getColumnIndex(clickedButton);

            }
        }


