package com.example.batalhanavalfx.model;

import java.util.ArrayList;

public class Player {
    private String nome;
    private Tabuleiro tabuleiro;
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




    public Player(String nome, Tabuleiro tabuleiro) {
        this.nome = nome;
        this.tabuleiro = tabuleiro;
    }



    /*public void playerName(){
        Scanner nameUm = new Scanner(System.in);
        Scanner nameDois = new Scanner(System.in);
        System.out.println("Qual o seu nome, jogador 1? ");
        this.nameUm = nameUm.nextLine();

        while (this.nameUm.length()<=2 || this.nameUm.length()>=16){
            System.out.println("Digite um nome entre 3 e 15 caracteres.");
            this.nameUm = nameUm.nextLine();
        }
        System.out.println("Qual o seu nome, jogador 2? ");
        this.nameDois = nameDois.nextLine();

        while (this.nameDois.length()<=2 || this.nameDois.length()>=16){
            System.out.println("Digite um nome entre 3 e 15 caracteres.");
            this.nameDois = nameUm.nextLine();
        }

    }*/



}
