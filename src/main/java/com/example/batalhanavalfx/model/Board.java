package com.example.batalhanavalfx.model;
import java.util.Arrays;

    public class Board {
        private char[][] tabuleiro = new char[10][10];
        private int[][] posicaoDefesa;
        private int[][] posicaoAtaque;

        public void teste(){
            for (char[] chars : tabuleiro) {
                for (int j = 0; j < tabuleiro.length; j++) {
                    System.out.print(chars[j]);
                }
                System.out.println();
            }
        }

        public int[][] getPosicaoDefesa() {
            return posicaoDefesa;
        }


        public void setPosicaoDefesa(int[][] posicaoDefesa) {
            this.posicaoDefesa = posicaoDefesa;
        }

        public int[][] getPosicaoAtaque() {
            return posicaoAtaque;
        }

        public void setPosicaoAtaque(int[][] posicaoAtaque) {
            this.posicaoAtaque = posicaoAtaque;
        }
        public void printarTabuleiro(){

        }
    }


