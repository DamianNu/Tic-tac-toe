package com.kodilla.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardDisplay {


    public void showBoard(GameLogic gameLogic) {
        int size = gameLogic.getSize();
        char[][] board = gameLogic.getBoard();
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print("|");
                System.out.print(board[i][j]);
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println();
    }

    public int movePlayerC() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.getMessage();
            movePlayerC();
            return 0;
        }
        return choice;
    }
}