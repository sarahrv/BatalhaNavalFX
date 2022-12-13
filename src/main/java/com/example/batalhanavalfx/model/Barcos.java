package com.example.batalhanavalfx.model;

public class Barcos {
    private int navio4Canos(){
        for(int i=1;i<5;i++){
            System.out.println("X");
        } return 0;
    }

    private int navio3Canos(){
        for(int i=1;i<4;i++){
            System.out.println("X");
        } return 0;
    }

    private int navio2Canos(){
        for(int i=1;i<3;i++){
            System.out.println("X");
        } return 0;
    }

    private int navio1Cano(){
            System.out.println("X");
         return 0;
    }

    public int portaAvioes(int i,int j){
        for (i=0;i<=2;i++){
            for(j=0;j<=2;j++){
                if(i==0 || i>=1 && i<=2 && j==1){
                    System.out.print("*");

                } else{
                    System.out.print(" ");

                }
            }
            System.out.println();

        }
        return 0;
    }

}
