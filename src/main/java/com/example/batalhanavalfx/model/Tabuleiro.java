package com.example.batalhanavalfx.model;

import com.example.batalhanavalfx.controller.BombasController;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class Tabuleiro {
    private Barcos[][] matrizBarcos;
    public Barcos[][] getMatrizBarcos() {
        return matrizBarcos;
    }

    public Tabuleiro() {
        this.matrizBarcos = new Barcos[10][10];
        defineTabuleiro();
    }

    public void defineTabuleiro(){
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                matrizBarcos[row][column] = new Barcos(row, column, 0);
            }
        }
    }


}


