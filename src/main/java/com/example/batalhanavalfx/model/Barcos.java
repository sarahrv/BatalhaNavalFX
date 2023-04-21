package com.example.batalhanavalfx.model;

    public class Barcos {
        private int row;
        private int collumn;

        private int valorCelula;

        public Barcos(int row, int column, int valorCelula) {
            this.row = row;
            this.collumn = column;
            this.valorCelula = valorCelula;
        }


        public int getCollumn() {
            return collumn;
        }

        public int getRow() {
            return row;
        }

        public int getValorCelula() {
            return valorCelula;
        }

        public void setValorCelula(int valorCelula) {
            this.valorCelula = valorCelula;
        }

    }


