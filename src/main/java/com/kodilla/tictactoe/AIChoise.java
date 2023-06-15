package com.kodilla.tictactoe;

public class AIChoise {

    //horizontally
    public static String choiseAI(GameLogic gameLogic) {
        char[][] tab = gameLogic.getBoard();
        int number;
        int x;
        int y;
        int c = 0;
        int d = 0;
        String choise;
        for (int j = 0; j < gameLogic.getSize(); j++) {
            x = j;
            number = 0;
            for (int i = 0; i < gameLogic.getSize(); i++) {
                y = i;
                if (tab[x][y] == gameLogic.getPlayer2().getSymbol()) {
                    number = number + 1;
                    if (number == gameLogic.getSize() - 1 && c > 999 && d < 2) {
                        choise = "" + (c - 1000);
                        if (choise.length() < 2) {
                            choise = "0" + choise;
                            return choise;
                        } else return choise;
                    }
                    d = 0;
                } else {
                    if (tab[x][y] == ' ') {
                        c = 1000 + 10 * x + y;
                        d = d + 1;
                        if (number == gameLogic.getSize() - 1 && c > 999 && d == 1) {
                            choise = "" + (c - 1000);
                            if (choise.length() < 2) {
                                choise = "0" + choise;
                                return choise;
                            } else return choise;
                        }
                    } else {
                        number = 0;
                        c = 0;
                        d = 0;
                    }
                }
            }
        }

        c = 0;
        d = 0;
        choise = null;
        for (int j = 0; j < gameLogic.getSize(); j++) {
            y = j;
            number = 0;
            for (int i = 0; i < gameLogic.getSize(); i++) {
                x = i;
                if (tab[x][y] == gameLogic.getPlayer2().getSymbol()) {
                    number = number + 1;
                    if (number == gameLogic.getSize() - 1 && c > 999 && d < 2) {
                        choise = "" + (c - 1000);
                        if (choise.length() < 2) {
                            choise = "0" + choise;
                            return choise;
                        } else return choise;
                    }
                    d = 0;
                } else {
                    if (tab[x][y] == ' ') {
                        c = 1000 + 10 * x + y;
                        d = d + 1;
                        if (number == gameLogic.getSize() - 1 && c > 999 && d == 1) {
                            choise = "" + (c - 1000);
                            if (choise.length() < 2) {
                                choise = "0" + choise;
                                return choise;
                            } else return choise;
                        }
                    } else {
                        number = 0;
                        c = 0;
                        d = 0;

                    }
                }
            }
        }
        System.out.println(choise + " 3");
        return choise;
    }
}

