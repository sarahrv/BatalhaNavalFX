package com.example.batalhanavalfx.model;

public class Barcos{
    private int celulasDoNavio;
    private boolean navioMorto;
    private boolean navio1Cano;
    private boolean navio2Canos;
    private boolean navio3Canos;
    private boolean navio4Canos;
    private boolean portaAviões;


    public boolean levouBomba(){
        //o return é apenas ilustrativo, o método deve retornar se o navio inteiro (não só a celula) levou bomba ou não.
        //se o numero de celulaBombada == o numero de celulasDoNavio, levou bomba retorna true, navioMorto == true.
        return true;
    }

    public boolean isNavio1Cano() {
        return navio1Cano;
    }

    public void setNavio1Cano(boolean navio1Cano) {
        this.navio1Cano = navio1Cano;
    }

    public boolean isNavio2Canos() {
        return navio2Canos;
    }

    public void setNavio2Canos(boolean navio2Canos) {
        this.navio2Canos = navio2Canos;
    }

    public boolean isNavio3Canos() {
        return navio3Canos;
    }

    public void setNavio3Canos(boolean navio3Canos) {
        this.navio3Canos = navio3Canos;
    }

    public boolean isNavio4Canos() {
        return navio4Canos;
    }

    public void setNavio4Canos(boolean navio4Canos) {
        this.navio4Canos = navio4Canos;
    }

    public boolean isPortaAviões() {
        return portaAviões;
    }

    public void setPortaAviões(boolean portaAviões) {
        this.portaAviões = portaAviões;
    }
}
