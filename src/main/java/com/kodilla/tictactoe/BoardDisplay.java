package com.kodilla.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardDisplay {

    public void showBoard(char[][] board, int sizeBoard) {
        System.out.print("  ");
        for (int i = 0; i < sizeBoard; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < sizeBoard; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < sizeBoard; j++) {
                System.out.print("\u001B[33m|\u001B[0m");
                System.out.print(board[i][j]);
            }
            System.out.print("\u001B[33m|\u001B[0m");
            System.out.println("");
        }
        System.out.println();
    }

    public static int movePlayerC() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return choice;
    }
}