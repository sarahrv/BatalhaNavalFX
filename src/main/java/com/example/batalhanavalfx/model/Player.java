package com.example.batalhanavalfx.model;

import java.util.ArrayList;

public class Player {
    private String nome;
    private Tabuleiro tabuleiro;

    public int getNumBarcos() {
        return numBarcos;
    }

    public void setNumBarcos(int numBarcos) {
        this.numBarcos = numBarcos;
    }

    private int numBarcos;
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }




    public Player(String nome, Tabuleiro tabuleiro, int numBarcos) {
        this.numBarcos = numBarcos;
        this.nome = nome;
        this.tabuleiro = tabuleiro;
    }


}
