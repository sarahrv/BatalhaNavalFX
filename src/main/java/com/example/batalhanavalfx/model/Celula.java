package com.example.batalhanavalfx.model;

import javafx.scene.shape.Rectangle;

//so fazer assim se não coneguir pegar coord direto do button
public class Celula extends Rectangle {
    private int coordX,coordY;
    private boolean bombada;

    public Celula(int coordX, int coordY){
        this.coordX = coordX;
        this.coordY = coordY;

    }
    //metodo que retorna se é um ponto valido (pegar o ponto e fazer um array)
    //metodo que retorna se posso colocar o navio ou não (se for um ponto valido, analisar tamanho do navio)

}
