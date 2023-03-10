package com.example.batalhanavalfx.model;


public class Celula {
    protected boolean celulaBombada, celulaComAgua, celulaComNavio, celulaComNavioBombado, celulaClicada;

    private int row;
    private int column;

    public Celula(int row, int column) {
        this.row = row;
        this.column = column;
    }


}
