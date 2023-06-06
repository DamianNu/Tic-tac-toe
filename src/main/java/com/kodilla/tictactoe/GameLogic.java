package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private char[] board = new char[9];
    private Player player1;
    private Player player2;
    private ArrayList<Integer> availableMoves = new ArrayList<>();
    private int numberRound;
    private boolean turnPlayer1;
    private boolean player2IsAComputer;

    public boolean isPlayer2IsAComputer() {
        return player2IsAComputer;
    }

    public void setPlayer2IsAComputer(boolean player2IsAComputer) {
        this.player2IsAComputer = player2IsAComputer;
    }

    public boolean isTurnPlayer1() {
        return turnPlayer1;
    }

    public void setTurnPlayer1(boolean turnPlayer1) {
        this.turnPlayer1 = turnPlayer1;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setBoard(char[] board) {
        this.board = board;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getNumberRound() {
        return numberRound;
    }

    public void setNumberRound(int numberRound) {
        this.numberRound = numberRound;
    }


    public List<Integer> getAvailableMoves() {
        return availableMoves;
    }

    public char[] setField(int x, char y) {
        board[x] = y;
        return board;
    }

    public char[] getBoard() {
        return board;
    }

    public char[] newCleanBoard() {
        char[] cleanBoard = new char[9];
        setBoard(cleanBoard);
        return board;
    }


    public ArrayList<Integer> newAvailableMoves() {
        for (int i = 1; i < 10; i++) {
            availableMoves.add(i - 1, i);
        }
        return availableMoves;
    }

    public boolean checkDraw() {
        if (getAvailableMoves().size() < 1) {
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        if (numberRound == player1.getWinRounds() || numberRound == player2.getWinRounds()) {
            return true;
        }
        return false;
    }

    public boolean winLine(Player player) {
        char[] tabWin = getBoard();
        if ((player.getSymbol() == tabWin[0] && player.getSymbol() == tabWin[1] && player.getSymbol() == tabWin[2]) ||
                (player.getSymbol() == tabWin[3] && player.getSymbol() == tabWin[4] && player.getSymbol() == tabWin[5]) ||
                (player.getSymbol() == tabWin[6] && player.getSymbol() == tabWin[7] && player.getSymbol() == tabWin[8]) ||
                (player.getSymbol() == tabWin[0] && player.getSymbol() == tabWin[3] && player.getSymbol() == tabWin[6]) ||
                (player.getSymbol() == tabWin[1] && player.getSymbol() == tabWin[4] && player.getSymbol() == tabWin[7]) ||
                (player.getSymbol() == tabWin[2] && player.getSymbol() == tabWin[5] && player.getSymbol() == tabWin[8]) ||
                (player.getSymbol() == tabWin[0] && player.getSymbol() == tabWin[4] && player.getSymbol() == tabWin[8]) ||
                (player.getSymbol() == tabWin[6] && player.getSymbol() == tabWin[4] && player.getSymbol() == tabWin[2])) {
            player.setWinRounds(player.getWinRounds() + 1);
            return true;
        }
        return false;
    }
}



