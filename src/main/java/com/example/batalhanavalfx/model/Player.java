package com.example.batalhanavalfx.model;

import java.util.Scanner;

public class Player {
    private String name;

    public void playerName(){
        Scanner name1 = new Scanner(System.in);
        System.out.println("Qual o seu nome? ");
        name = name1.nextLine();
    }

    public Player(String nome) {
        this.name = nome;
    }
}
