package com.example.batalhanavalfx.model;

import java.util.Scanner;

public class Player {
    private String name;

    public void playerName(){
        Scanner name1 = new Scanner(System.in);
        System.out.println("Qual o seu nome? ");
        name = name1.nextLine();

        while (name.length()<=2 || name.length()>=16){
            System.out.println("Digite um nome entre 3 e 15 caracteres.");
            name = name1.nextLine();
        }
    }


    public static void main(String[] args) {
        Player p = new Player();
        p.playerName();
    }
}
