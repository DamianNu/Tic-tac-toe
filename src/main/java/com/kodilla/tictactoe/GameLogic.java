package com.kodilla.tictactoe;

import java.util.ArrayList;

public class GameLogic {
    private int size;
    private int winningSymbols;
    private char[][] board;
    private Player player1;
    private Player player2;
    private ArrayList<String> availableMoves = new ArrayList<>();
    private int numberRound;
    private boolean turnPlayer1;
    private boolean player2IsAComputer;

    public int getWinningSymbols() {
        return winningSymbols;
    }

    public void setWinningSymbols(int winningSymbols) {
        this.winningSymbols = winningSymbols;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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

    public void setBoard(char[][] board) {
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


    public ArrayList<String> getAvailableMoves() {
        return availableMoves;
    }


    public char[][] newBoard() {
        int size = getSize();
        char[][] board1 = new char[size][size];
        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1[i].length; j++) {
                board1[i][j] = ' ';
            }
        }
        board = board1;
        return board;
    }

    public void setField(int x, int y, char z) {
        board[x][y] = z;
    }

    public char[][] getBoard() {
        return board;
    }

    public char[][] newCleanBoard() {
        char[][] cleanBoard = new char[size][size];
        setBoard(cleanBoard);
        return board;
    }


    public ArrayList<String> newAvailableMoves() {
        availableMoves = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                availableMoves.add(i + "" + j);
            }
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

    public boolean winLine(Player player){
        if(winLineHorizontally(player)==true ||
        winLineVertically(player)==true ||
        winLineDiagonalR(player)==true ||
        winLineDiagonalRR(player)==true ||
        winLineDiagonalLineL(player)==true ||
        winLineDiagonalLineLL(player)==true ){
            return true;
        }
        return false;
    }

    public boolean winLineHorizontally(Player player) {
        char[][] tabWin = getBoard();
        int number;
        int x;
        int y;
        // Check the win in the line horizontally
        for (int j = 0; j < size; j++) {
            x = j;
            number = 0;
            for (int i = 0; i < size; i++) {
                y = i;
                if (tabWin[x][y] == player.getSymbol()) {
                    number = number + 1;
                    if (number == getWinningSymbols()) {
                        return true;
                    }
                } else {
                    number = 0;
                }
            }
        }
        return false;
    }
    public boolean winLineVertically(Player player) {
        char[][] tabWin = getBoard();
        int number, x, y;
        // Check the win in the line vertically
        for (int j = 0; j < size; j++) {
            y = j;
            number = 0;
            for (int i = 0; i < size; i++) {
                x = i;
                if (tabWin[x][y] == player.getSymbol()) {
                    number = number + 1;
                    if (number == getWinningSymbols()) {
                        return true;
                    }
                } else {
                    number = 0;
                }
            }
        }
        return false;
    }
    public boolean winLineDiagonalR(Player player) {
        char[][] tabWin = getBoard();
        int number, x, y;
        // Check the win in the line towards the bottom right - first side
        int k = -1;
        for (int j = 0; j < size; j++) {
            number = 0;
            k = k + 1;
            for (int i = 0; i < size; i++) {
                y = i + k;
                x = i;
                try {
                    boolean spr = tabWin[x][y] == player.getSymbol();
                } catch (ArrayIndexOutOfBoundsException e) {
                    number = 0;
                    break;
                }
                if (tabWin[x][y] == player.getSymbol()) {
                    number = number + 1;
                    if (number == getWinningSymbols()) {
                        return true;
                    }
                } else {
                    number = 0;
                }
            }
        }
        return false;
    }

    public boolean winLineDiagonalRR(Player player) {
        char[][] tabWin = getBoard();
        int number, x, y;
        // Check the win in the line towards the bottom right - second side
        int k = -1;
        for (int j = 0; j < size; j++) {
            number = 0;
            k = k + 1;
            for (int i = 0; i < size; i++) {
                y = i;
                x = i + k;
                try {
                    boolean spr = tabWin[x][y] == player.getSymbol();
                } catch (ArrayIndexOutOfBoundsException e) {
                    number = 0;
                    break;
                }
                if (tabWin[x][y] == player.getSymbol()) {
                    number = number + 1;
                    if (number == getWinningSymbols()) {
                        return true;
                    }
                } else {
                    number = 0;
                }
            }
        }
        return false;
    }
    public boolean winLineDiagonalLineL(Player player) {
        char[][] tabWin = getBoard();
        int number, x, y;
        // Check the win in the line towards left down - first side
        int l = -1;
        for (int j = size; j > 0; j--) {
            number = 0;
            l = l + 1;

            for (int i = 0; i < size; i++) {
                y = size - i - 1 - l;
                x = i;
                try {
                    boolean spr = tabWin[x][y] == player.getSymbol();
                } catch (ArrayIndexOutOfBoundsException e) {
                    number = 0;
                    break;
                }
                if (tabWin[x][y] == player.getSymbol()) {
                    number = number + 1;
                    if (number == getWinningSymbols()) {
                        return true;
                    }
                } else {
                    number = 0;
                }
            }
        }
        return false;
    }
    public boolean winLineDiagonalLineLL(Player player) {
        char[][] tabWin = getBoard();
        int number, x, y;
        // Check the win in the line towards left down - second side
        int m = -1;
        for (int j = size; j > 0; j--) {
            number = 0;
            m = m + 1;

            for (int i = 0; i < size; i++) {
                y = size - i - 1;
                x = i + m;
                try {
                    boolean spr = tabWin[x][y] == player.getSymbol();
                } catch (ArrayIndexOutOfBoundsException e) {
                    number = 0;
                    break;
                }
                if (tabWin[x][y] == player.getSymbol()) {
                    number = number + 1;
                    if (number == getWinningSymbols()) {
                        return true;
                    }
                } else {
                    number = 0;
                }
            }
        }
        return false;
    }
}




