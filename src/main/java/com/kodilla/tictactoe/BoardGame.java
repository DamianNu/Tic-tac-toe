package com.kodilla.tictactoe;

import java.util.Random;


public class BoardGame {

    public void startGame() {
        BoardGame boardGame = new BoardGame();
        GameLogic gameLogic = new GameLogic();
        boardGame.newGame(gameLogic);
        boardGame.choiseBoardSize(gameLogic);
        gameLogic.newBoard();
        boardGame.newGameRounds(gameLogic);
        gameLogic.newAvailableMoves();
        boardGame.round(gameLogic);
    }

    public void newGame(GameLogic gameLogic) {
        gameLogic.setPlayer1(new Player());
        gameLogic.setPlayer2(new Player());
        gameLogic.setTurnPlayer1(true);
        System.out.println("Game for 1 or 2 people?");
        System.out.println("1 -> 'Single Player'\n2 -> 'Two Player'");
        int choise = new BoardDisplay().movePlayerC();
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
        int choise2 = new BoardDisplay().movePlayerC();
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
        gameLogic.setNumberRound(new BoardDisplay().movePlayerC());
        if (gameLogic.getNumberRound() < 1) {
            System.out.println("Please enter the number of rounds again!");
            newGameRounds(gameLogic);
        }
    }

    public void movePlayer(Player player, GameLogic gameLogic) {
        BoardDisplay boardDisplay = new BoardDisplay();
        String choise;
        boolean traffic;
        int a;
        int b;
        if (gameLogic.isPlayer2IsAComputer() && !gameLogic.isTurnPlayer1()) {
            choise = moveComputer(gameLogic);
        } else {
            System.out.println("Enter line number");
            a = new BoardDisplay().movePlayerC();
            System.out.println("Enter the column number");
            b = new BoardDisplay().movePlayerC();
            if (a >= gameLogic.getSize() || a < 0 || b >= gameLogic.getSize() || b < 0) {
                System.out.println("Movement impossible, please try again");
                System.out.println("Enter line number");
                a = new BoardDisplay().movePlayerC();
                System.out.println("Enter the column number");
                b = new BoardDisplay().movePlayerC();
            }
            choise = a + "" + b;
            boolean choiseX = false;
            try {
                choiseX = movePlayerX(gameLogic.getBoard(), player.getSymbol(), a, b);
            } catch (IllegalTrafficException e) {
                e.getMessage();
            }
            if (!choiseX) {
                movePlayer(player, gameLogic);
            }

        }
        System.out.println(gameLogic.getAvailableMoves());
        traffic = gameLogic.getAvailableMoves().stream()
                .anyMatch(u -> u.equals(choise));
        if (traffic) {
            char xx = choise.charAt(0);
            char yy = choise.charAt(1);
            int x = Integer.parseInt(String.valueOf(xx));
            int y = Integer.parseInt(String.valueOf(yy));
            gameLogic.setField(x, y, player.getSymbol());
            gameLogic.getAvailableMoves().remove(choise);
        } else {
            System.out.println("\u001B[33mThis field on the board is occupied\nTry again\u001B[0m");
            movePlayer(player, gameLogic);
        }
        if (gameLogic.winLine(player)) {
            boardDisplay.showBoard(gameLogic);
            gameLogic.newBoard();
            gameLogic.newAvailableMoves();
            player.setWinRounds(player.getWinRounds() + 1);
            System.out.println("Round won by " + player.getName() + " > " + player.getSymbol() + " <");
            if (gameLogic.checkWin()) {
                System.out.println("\u001B[33m" + player.getName() + " > " + player.getSymbol() + " < Winner!!\u001B[0m\nWould you like to start a new game?");
                System.out.println("Select 'Yes' or 'No'.");
                System.out.println("1 -> 'Yes'\n2 -> 'No'");
                int choise2 = new BoardDisplay().movePlayerC();
                switch (choise2) {
                    case 1 -> startGame();
                    case 2 -> System.exit(0);
                    default -> newGame(gameLogic);
                }
            }
        }
        if (gameLogic.checkDraw()) {
            System.out.println("Draw!! New round");
            boardDisplay.showBoard(gameLogic);
            gameLogic.newBoard();
            ;
            gameLogic.newAvailableMoves();
        }
        System.out.println("State of the game: " + gameLogic.getNumberRound());
        System.out.println(gameLogic.getPlayer1().getName() + " '" + gameLogic.getPlayer1().getSymbol() + "' -> \u001B[32m" + gameLogic.getPlayer1().getWinRounds() +
                " : " + gameLogic.getPlayer2().getWinRounds() + "\u001B[0m <- " + gameLogic.getPlayer2().getName() + " '" + gameLogic.getPlayer2().getSymbol() + "'");
    }

    public String moveComputer(GameLogic gameLogic) {
        Random random = new Random();
        if (AIChoise.choiseAI(gameLogic) != null) {
            String choiseComp = AIChoise.choiseAI(gameLogic);
            return choiseComp;
        } else {
            int choiseC = random.nextInt(0, gameLogic.getAvailableMoves().size());
            String choiseComputer = gameLogic.getAvailableMoves().get(choiseC);
            return choiseComputer;
        }
    }

    public void round(GameLogic gameLogic) {
        BoardDisplay boardDisplay = new BoardDisplay();
        while (true) {
            boardDisplay.showBoard(gameLogic);
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

    public boolean movePlayerX(char[][] board, char symbol, int x, int y) throws IllegalTrafficException {

        if (!(board[x][y] == ' ')) {
            throw new IllegalTrafficException();
        } else {
            return true;
        }
    }

    public void choiseBoardSize(GameLogic gameLogic) {
        System.out.println("Enter board size!\n");
        System.out.println("The minimum board size is 3x3 \nand the maximum is 10x10");
        System.out.println("Enter a number from 3 to 10");
        int choise2 = new BoardDisplay().movePlayerC();
        if (choise2 < 3 || choise2 > 10) {
            System.out.println("You entered incorrect data, try again");
            choiseBoardSize(gameLogic);
        }
        gameLogic.setSize(choise2);
        if (choise2 < 5) {
            gameLogic.setWinningSymbols(3);
        } else {
            gameLogic.setWinningSymbols(5);
        }
    }
}


