package com.example.batalhanavalfx.model;

import com.example.batalhanavalfx.controller.BombasController;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class Tabuleiro {

    private Celula[][] matrizCelulas;

    public Tabuleiro() {
        this.matrizCelulas = new Celula[10][10];
        defineTabuleiro();
    }


    public void defineTabuleiro(){
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                matrizCelulas[row][column] = new Celula(row, column, 0);
            }
        }
    }

    public void colocaBracosNaMatriz(Barcos barco) {
        ArrayList<Celula> celulaOcupada = barco.getCelulaOcupada();
        int valor = barco.getTamanho();
        for (Celula cell : celulaOcupada) {
            int row = cell.getRow();
            int column = cell.getCollumn();
            matrizCelulas[row][column].setValorCelula(valor);
            System.out.println(matrizCelulas[row][column].getValorCelula());
        }

    }

    public void turnoJogadores() {
        //metodo para definir turno dos jogadores (contar numero de celulas clicadas no BombasController, se for igual a 3, passa pra o outro jogador)
    }

    public boolean checkVitoria(int playerUmBarcos, int playerDoisBarcos) {
        //checa a quantidade de barcos de cada jogador
        // return boolean, o retorno true atual é só pra não dar erro;
        return true;
    }

    /*public void atacar(ActionEvent event) {
        /*BombasController t = new BombasController();
        int array[] = t.getButtonsXY(event);
        int arrayDuplo[][] = new int[3][3];
        for(int i = 0; i < 2; i++) {
            arrayDuplo[0][i] = array[i];
            arrayDuplo[1][i] = array[i+2];
            arrayDuplo[2][i] = array[i+4];
        }
    }

    public void turno() {
        int turno = 1;
        int contador = 0;
        while (true) {
            if ((contador % 2) == 0) {
                jogadorAtual = jogador1;
            } else {
                jogadorAtual = jogador2;
            }
            contador++;
        }


    }*/
}


