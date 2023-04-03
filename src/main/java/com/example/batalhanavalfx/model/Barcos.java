package com.example.batalhanavalfx.model;

import java.util.ArrayList;

public class Barcos {


    private ArrayList<Celula> celulaOcupada;

    private int tamanho;

    public Barcos(int tamanho){
        this.tamanho = tamanho;
        celulaOcupada = new ArrayList<>();

    }
    public ArrayList<Celula> getCelulaOcupada() {
        return celulaOcupada;
    }

    public void setCelulaOcupada(ArrayList<Celula> celulaOcupada) {
        this.celulaOcupada = celulaOcupada;
    }
    public void defineTamanho(){

    }

    public boolean levouBomba() {
        //o return é apenas ilustrativo, o método deve retornar se o navio inteiro (não só a celula) levou bomba ou não.
        //se o numero de celulaBombada == o numero de celulasDoNavio, levou bomba retorna true, navioMorto == true.
        return true;
    }


    public int getTamanho() {
        return this.tamanho;
    }
}
