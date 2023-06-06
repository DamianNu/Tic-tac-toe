package com.kodilla.tictactoe;

public class Player {
    private char symbol;
    private String name;
    private int winRounds;

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getWinRounds() {
        return winRounds;
    }

    public void setWinRounds(int winRounds) {
        this.winRounds = winRounds;
    }
}
