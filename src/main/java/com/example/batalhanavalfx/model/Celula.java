package com.example.batalhanavalfx.model;
import com.example.batalhanavalfx.controller.DefesaController;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class Celula {
    private int row;
    private int collumn;

    private int valorCelula;

    public Celula(int row, int column, int valorCelula) {
        this.row = row;
        this.collumn = column;
        this.valorCelula = valorCelula;
    }


    public void print(Celula celula) {
        /*Barcos b1 = new Barcos();
        DefesaController d = new DefesaController();
        for (int i = 0; i < d.getGridDefesa())*/
    }

    public int getCollumn() {
        return collumn;
    }

    public int getRow() {
        return row;
    }

    public int getValorCelula() {
        return valorCelula;
    }

    public void setValorCelula(int valorCelula) {
        this.valorCelula = valorCelula;
    }

    /* Button clickedButton = (Button) event.getSource();
        this.row = GridPane.getRowIndex(clickedButton);
        this.collumn = GridPane.getColumnIndex(clickedButton);*/
}
