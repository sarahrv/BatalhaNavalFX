package com.example.batalhanavalfx.model;

import java.util.ArrayList;

public class Player {
    private String nome;
    private Tabuleiro tabuleiro;
    private String modo;
    private int numTiros;

    public Player(String nome, Tabuleiro tabuleiro, int numBarcos, String modo) {
        this.modo = modo;
        this.numTiros = numBarcos;
        this.nome = nome;
        this.tabuleiro = tabuleiro;
    }

    public int getNumTiros() {
        return numTiros;
    }

    public void setNumTiros(int numTiros) {
        this.numTiros = numTiros;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

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


}
