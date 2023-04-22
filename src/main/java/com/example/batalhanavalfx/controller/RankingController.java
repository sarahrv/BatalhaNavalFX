package com.example.batalhanavalfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

import java.io.*;
import java.util.Scanner;

public class RankingController {

    //um ranking pra cada modo?
    @FXML
    private TextArea winnerTextArea;
    public void displayWinners() throws NullPointerException{
        winnerTextArea.setEditable(false);
        try (BufferedReader reader = new BufferedReader(new FileReader("vencedores.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            winnerTextArea.setPromptText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}




