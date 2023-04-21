package com.example.batalhanavalfx.exception;

public class InputInvalidoException extends Exception{
    public InputInvalidoException() {
        super("Erro: o nome dos players deve ter ao menos três letras!");
    }

}
