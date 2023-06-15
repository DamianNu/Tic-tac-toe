package com.kodilla.tictactoe;

public class IllegalTrafficException extends Exception{
    @Override
    public String getMessage() {
        return "An impossible movement. The field on the board is occupied.";
    }
}
