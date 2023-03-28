package com.example.batalhanavalfx.model;

import java.util.ArrayList;

public class Barcos {
    private ArrayList<Celula> celulaOcupada = new ArrayList<>();
    private int tamanho;

    public Barcos(int tamanho, ArrayList<Celula> celulaOcupada){
        this.tamanho = tamanho;
        this.celulaOcupada = celulaOcupada;
    }

    public boolean levouBomba() {
        //o return é apenas ilustrativo, o método deve retornar se o navio inteiro (não só a celula) levou bomba ou não.
        //se o numero de celulaBombada == o numero de celulasDoNavio, levou bomba retorna true, navioMorto == true.
        return true;
    }

}
