package com.example.batalhanavalfx.model;

import java.util.Scanner;

public class Player {
    private String name1;
    private String name2;

    public void playerName(){
        Scanner name1 = new Scanner(System.in);
        Scanner name2 = new Scanner(System.in);
        System.out.println("Qual o seu nome, jogador 1? ");
        this.name1 = name1.nextLine();

        while (this.name1.length()<=2 || this.name1.length()>=16){
            System.out.println("Digite um nome entre 3 e 15 caracteres.");
            this.name1 = name1.nextLine();
        }
        System.out.println("Qual o seu nome, jogador 2? ");
        this.name2 = name2.nextLine();

        while (this.name2.length()<=2 || this.name2.length()>=16){
            System.out.println("Digite um nome entre 3 e 15 caracteres.");
            this.name2 = name1.nextLine();
        }

    }
    public boolean checkVitoria(int playerUmBarcos, int playerDoisBarcos ){
        //checa a quantidade de barcos de cada jogador
       // return boolean, o retorno true atual é só pra não dar erro;
        return true;
    }




    public static void main(String[] args) {
        Player p = new Player();
        p.playerName();
    }
}
