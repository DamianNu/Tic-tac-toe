package com.kodilla.tictactoe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BoardGame {

    public void startGame() {
        BoardGame boardGame = new BoardGame();
        GameLogic gameLogic = new GameLogic();
        boardGame.showInstruction();
        boardGame.newGame(gameLogic);
        boardGame.newGameRounds(gameLogic);
        gameLogic.newAvailableMoves();
        boardGame.round(gameLogic);
    }

    public void showBoard(GameLogic gameLogic) {
        char[] board = gameLogic.getBoard();
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|");
                System.out.print(board[j + k]);
            }
            System.out.print("|");
            System.out.println("");
            k = k + 3;
        }
        System.out.println();
    }

    public void showInstruction() {
        System.out.println("\u001B[33mWelcome to tic-tac-toe!\u001B[0m \nTo place a symbol," +
                " press the corresponding number on the keyboard from 1 to 9. \nHere's an example:");
        char[] board1 = {'7', '8', '9', '4', '5', '6', '1', '2', '3'};
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|");
                System.out.print(board1[j + k]);
            }
            System.out.print("|");
            System.out.println("");
            k = k + 3;
        }
        System.out.println();
    }

    public int movePlayerC() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            return choice;
        } catch (InputMismatchException e) {
            System.out.println("Prohibited action : " + e);
            movePlayerC();
        }
        return 0;
    }

    public void newGame(GameLogic gameLogic) {
        gameLogic.setPlayer1(new Player());
        gameLogic.setPlayer2(new Player());
        gameLogic.setTurnPlayer1(true);
        System.out.println("Game for 1 or 2 people?");
        System.out.println("1 -> 'Single Player'\n2 -> 'Two Player'");
        int choise = new BoardGame().movePlayerC();
        switch (choise) {
            case 1 -> {
                gameLogic.setPlayer2IsAComputer(true);
                gameLogic.getPlayer1().setName("Player");
                gameLogic.getPlayer2().setName("Computer");

            }
            case 2 -> {
                gameLogic.setPlayer2IsAComputer(false);
                gameLogic.getPlayer1().setName("Player I");
                gameLogic.getPlayer2().setName("Player II");
            }
            default -> newGame(gameLogic);
        }
        System.out.println("Player1 select your symbol 'X' or 'O'.");
        System.out.println("1 -> 'X'\n2 -> 'O'");
        int choise2 = new BoardGame().movePlayerC();
        switch (choise2) {
            case 1 -> {
                gameLogic.getPlayer1().setSymbol('X');
                gameLogic.getPlayer2().setSymbol('O');
            }
            case 2 -> {
                gameLogic.getPlayer1().setSymbol('O');
                gameLogic.getPlayer2().setSymbol('X');
            }
            default -> newGame(gameLogic);
        }
    }

    public void newGameRounds(GameLogic gameLogic) {
        System.out.println("Select Choose how many rounds.");
        gameLogic.setNumberRound(new BoardGame().movePlayerC());
        if (gameLogic.getNumberRound() < 1) {
            System.out.println("Please enter the number of rounds again!");
            newGameRounds(gameLogic);
        }
    }


    public void movePlayer(Player player, GameLogic gameLogic) {
        int choise;
        boolean traffic;
        if (gameLogic.isPlayer2IsAComputer() && !gameLogic.isTurnPlayer1()) {
            choise = moveComputer(gameLogic);
        } else {
            choise = new BoardGame().movePlayerC();
        }
        traffic = gameLogic.getAvailableMoves().stream()
                .anyMatch(u -> u.equals(choise));
        if (traffic) {
            switch (choise) {
                case 1 -> gameLogic.setField(6, player.getSymbol());
                case 2 -> gameLogic.setField(7, player.getSymbol());
                case 3 -> gameLogic.setField(8, player.getSymbol());
                case 4 -> gameLogic.setField(3, player.getSymbol());
                case 5 -> gameLogic.setField(4, player.getSymbol());
                case 6 -> gameLogic.setField(5, player.getSymbol());
                case 7 -> gameLogic.setField(0, player.getSymbol());
                case 8 -> gameLogic.setField(1, player.getSymbol());
                case 9 -> gameLogic.setField(2, player.getSymbol());
                default -> movePlayer(player, gameLogic);
            }
            gameLogic.getAvailableMoves().remove((Object) choise);
            if (gameLogic.winLine(player)) {
                showBoard(gameLogic);
                gameLogic.newCleanBoard();
                gameLogic.newAvailableMoves();
                if (gameLogic.checkWin()) {
                    System.out.println("\u001B[33m" + player.getName() + " > " + player.getSymbol() + " < Winner!!\u001B[0m\nWould you like to start a new game?");
                    System.out.println("Select 'Yes' or 'No'.");
                    System.out.println("1 -> 'Yes'\n2 -> 'No'");
                    int choise2 = new BoardGame().movePlayerC();
                    switch (choise2) {
                        case 1 -> startGame();
                        case 2 -> System.exit(0);
                        default -> newGame(gameLogic);
                    }

                }
            }
            if (gameLogic.checkDraw()) {
                System.out.println("Draw!! New round");
                showBoard(gameLogic);
                gameLogic.newCleanBoard();
                gameLogic.newAvailableMoves();
            }
            System.out.println("State of the game: " + gameLogic.getNumberRound());
            System.out.println(gameLogic.getPlayer1().getName() + " '" + gameLogic.getPlayer1().getSymbol() + "' -> \u001B[32m" + gameLogic.getPlayer1().getWinRounds() +
                    " : " + gameLogic.getPlayer2().getWinRounds() + "\u001B[0m <- " + gameLogic.getPlayer2().getName() + " '" + gameLogic.getPlayer2().getSymbol() + "'");
        } else if (gameLogic.isTurnPlayer1() || gameLogic.getPlayer2().getName().equals("Player II")) {
            System.out.println("Movement impossible, please try again");
            movePlayer(player, gameLogic);
        } else {
            movePlayer(player, gameLogic);
        }
    }

    public int moveComputer(GameLogic gameLogic) {
        Random random = new Random();
        int choiseC = random.nextInt(0, gameLogic.getAvailableMoves().size());
        int choiseComputer = gameLogic.getAvailableMoves().get(choiseC);
        return choiseComputer;
    }

    public void round(GameLogic gameLogic) {
        while (gameLogic.getAvailableMoves().size() != 0) {
            showBoard(gameLogic);
            actualPlayerTurn(gameLogic);
            boolean p1 = gameLogic.isTurnPlayer1();
            if (p1) {
                movePlayer(gameLogic.getPlayer1(), gameLogic);
                gameLogic.setTurnPlayer1(false);
            } else {
                movePlayer(gameLogic.getPlayer2(), gameLogic);
                gameLogic.setTurnPlayer1(true);
            }
        }
    }

    public void actualPlayerTurn(GameLogic gameLogic) {
        boolean playerTurn = gameLogic.isTurnPlayer1();
        if (playerTurn) {
            System.out.println("The current turn belongs to the " + gameLogic.getPlayer1().getName() + " \u001B[33m>" + gameLogic.getPlayer1().getSymbol() + "<\u001B[0m");
        } else {
            System.out.println("The current turn belongs to the " + gameLogic.getPlayer2().getName() + " \u001B[34m>" + gameLogic.getPlayer2().getSymbol() + "<\u001B[0m");
        }
    }

}

