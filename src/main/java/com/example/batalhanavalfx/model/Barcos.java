package com.example.batalhanavalfx.model;

public class Barcos extends Celula{
    private int celulasDoNavio;
    private boolean navioMorto;


    public boolean levouBomba(){
        //o return é apenas ilustrativo, o método deve retornar se o navio inteiro (não só a celula) levou bomba ou não.
        //se o numero de celulaBombada == o numero de celulasDoNavio, levou bomba retorna true, navioMorto == true.
        return true;
    }


}
