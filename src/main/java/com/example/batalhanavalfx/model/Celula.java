package com.example.batalhanavalfx.model;
import com.example.batalhanavalfx.controller.DefesaController;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class Celula {
    protected boolean celulaBombada, celulaComAgua, celulaComNavio, celulaComNavioBombado, celulaClicada;
    private int row;
    private int collumn;

    public Celula(int row, int column) {
        this.row = row;
        this.collumn = column;
    }


    public void print(Celula celula) {
        /*Barcos b1 = new Barcos();
        DefesaController d = new DefesaController();
        for (int i = 0; i < d.getGridDefesa())*/
    }

    /* Button clickedButton = (Button) event.getSource();
        this.row = GridPane.getRowIndex(clickedButton);
        this.collumn = GridPane.getColumnIndex(clickedButton);*/
}
