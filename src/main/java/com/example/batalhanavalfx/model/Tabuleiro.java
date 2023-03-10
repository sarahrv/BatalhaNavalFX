package com.example.batalhanavalfx.model;

import com.example.batalhanavalfx.controller.BombasController;
import javafx.event.ActionEvent;

public class Tabuleiro {
    private Player jogador1;
    private Player jogador2;
    private Player jogadorAtual;

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


