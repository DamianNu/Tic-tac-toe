package com.kodilla.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardDisplay {

    public void showBoard(char[][] board) {
        System.out.print("  ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board.length; j++) {
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
        int choice = 0;
        boolean spr = true;
        try {
            while (spr) {
                choice = scanner.nextInt();
                spr = false;
            }

            } catch(InputMismatchException e){
                System.out.println("Invalid data please enter again");
            }

        return choice;
    }

}
