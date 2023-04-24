package com.example.batalhanavalfx.exception;

public class NumeroDeBarcosCustomException extends Exception{
    public NumeroDeBarcosCustomException(){
        super("Para o jogo ser possível, cada usuário deve colocar ao menos um barco!");
    }
}
