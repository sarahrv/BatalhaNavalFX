package com.example.batalhanavalfx.model;

import java.util.ArrayList;

public class Player {
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;

    public ArrayList<Barcos> getBarcosDoPlayer() {
        return barcosDoPlayer;
    }

    public void setBarcosDoPlayer(ArrayList<Barcos> barcosDoPlayer) {
        this.barcosDoPlayer = barcosDoPlayer;
    }

    private ArrayList<Barcos> barcosDoPlayer;

    public Player(String nome, ArrayList<Barcos> barcosDoPlayer) {
        this.nome = nome;
        barcosDoPlayer = new ArrayList<>();
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
