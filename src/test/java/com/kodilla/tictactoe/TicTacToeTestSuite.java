package com.kodilla.tictactoe;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("TDD: Forum Test Suite ")
public class TicTacToeTestSuite {


    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Test #" + testCounter);
    }

    @Nested
    @DisplayName("Test Win 3 symbols")
    class TestWin3Symbols {

        GameLogic gameLogic = new GameLogic();

        @Test
        @DisplayName("Test Win 3X in horizontal line")
        void testWin3_X_InHorizontalLine() {
            //Given
            char[][] boardTest = {{'X', 'O', 'O'},
                    {'O', 'O', 'X'},
                    {'X', 'X', 'X'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('X');
            gameLogic.setSize(3);
            gameLogic.setWinningSymbols(3);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test Win 3X in vertical line")
        void testWin3_X_InVerticalLine() {
            //Given
            char[][] boardTest = {{'X', 'O', 'X'},
                    {'O', 'O', 'X'},
                    {'X', 'X', 'X'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('X');
            gameLogic.setSize(3);
            gameLogic.setWinningSymbols(3);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test Win 3X in bevel line")
        void testWin3_X_InBevelLine() {
            //Given
            char[][] boardTest = {{'X', 'O', 'O'},
                    {'O', 'X', 'X'},
                    {'O', 'O', 'X'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('X');
            gameLogic.setSize(3);
            gameLogic.setWinningSymbols(3);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test Draw")
        void testDraw() {
            //Given
            char[][] boardTest = {{'X', 'X', 'O'},
                    {'O', 'O', 'X'},
                    {'X', 'O', 'O'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('X');
            gameLogic.setSize(3);
            gameLogic.setWinningSymbols(3);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        @DisplayName("Test Win 3O in horizontal line")
        void testWin3_O_InHorizontalLine() {
            //Given
            char[][] boardTest = {{'O', 'O', 'O'},
                    {'O', ' ', 'X'},
                    {'X', ' ', 'X'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('O');
            gameLogic.setSize(3);
            gameLogic.setWinningSymbols(3);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test Win 3O in vertical line")
        void testWin3_O_InVerticalLine() {
            //Given
            char[][] boardTest = {{'O', 'O', 'X'},
                    {'O', ' ', ' '},
                    {'O', 'X', 'X'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('O');
            gameLogic.setSize(3);
            gameLogic.setWinningSymbols(3);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test Win 3O in bevel line")
        void testWin3_O_InBevelLine() {
            //Given
            char[][] boardTest = {{' ', ' ', 'O'},
                    {'O', 'O', 'X'},
                    {'O', ' ', 'X'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('O');
            gameLogic.setSize(3);
            gameLogic.setWinningSymbols(3);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Test Win 5 symbols")
    class TestWin5Symbols {

        GameLogic gameLogic = new GameLogic();

        @Test
        @DisplayName("Test Win 5X in horizontal line")
        void testWin5_X_InHorizontalLine() {
            //Given
            char[][] boardTest = {{'X', 'O', 'X', 'O', 'O', 'O'},
                    {'X', 'O', 'O', 'O', ' ', ' '},
                    {'O', 'O', 'X', 'O', ' ', 'O'},
                    {' ', ' ', 'O', ' ', 'O', 'O'},
                    {' ', 'X', 'X', 'X', 'X', 'X'},
                    {'X', 'O', 'O', 'X', 'O', 'O'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('X');
            gameLogic.setSize(6);
            gameLogic.setWinningSymbols(5);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test Win 5X in vertical line")
        void testWin5_X_InVerticalLine() {
            //Given
            char[][] boardTest = {{'X', ' ', ' ', ' ', 'O', 'O'},
                    {'X', 'O', ' ', 'X', 'O', 'O'},
                    {' ', ' ', 'O', 'X', 'O', 'O'},
                    {'X', 'O', 'O', 'X', 'X', ' '},
                    {'X', 'O', ' ', 'X', 'O', 'O'},
                    {'X', ' ', 'O', 'X', ' ', 'O'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('X');
            gameLogic.setSize(6);
            gameLogic.setWinningSymbols(5);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test Win 5X in bevel line")
        void testWin5_X_InBevelLine() {
            //Given
            char[][] boardTest = {{' ', ' ', ' ', ' ', ' ', ' '},
                    {'X', ' ', 'O', 'O', 'O', 'X'},
                    {'X', ' ', ' ', ' ', 'X', ' '},
                    {' ', 'O', ' ', 'X', ' ', ' '},
                    {'X', 'O', 'X', 'X', 'O', 'O'},
                    {'X', 'X', 'O', 'O', 'O', 'O'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('X');
            gameLogic.setSize(6);
            gameLogic.setWinningSymbols(5);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test Draw")
        void testDraw() {
            //Given
            char[][] boardTest = {{'X', 'O', 'X', 'O', 'X', 'O'},
                    {'X', 'X', 'O', 'O', 'O', 'O'},
                    {'O', 'O', 'O', 'X', 'O', 'O'},
                    {'X', 'X', 'O', 'X', 'X', 'X'},
                    {'X', 'O', 'O', 'O', 'X', 'O'},
                    {'O', 'X', 'O', 'O', 'O', 'O'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('X');
            gameLogic.setSize(6);
            gameLogic.setWinningSymbols(5);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        @DisplayName("Test Win 5 O in horizontal line")
        void testWin5_O_InHorizontalLine() {
            //Given
            char[][] boardTest = {{'X', 'O', ' ', 'O', 'O', 'O'},
                    {'X', 'O', 'O', 'O', 'O', 'O'},
                    {'X', 'O', ' ', 'O', 'O', 'O'},
                    {' ', ' ', ' ', ' ', ' ', ' '},
                    {'X', ' ', ' ', 'O', 'O', 'O'},
                    {'X', ' ', ' ', 'O', 'O', 'O'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('O');
            gameLogic.setSize(6);
            gameLogic.setWinningSymbols(5);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test Win 5 O in vertical line")
        void testWin5_O_InVerticalLine() {
            //Given
            char[][] boardTest = {{'X', 'O', 'O', ' ', 'O', 'O'},
                    {'X', 'O', 'X', 'O', 'O', 'O'},
                    {'X', 'O', 'O', 'O', ' ', 'O'},
                    {'X', ' ', ' ', ' ', ' ', 'O'},
                    {' ', 'O', 'O', ' ', 'O', 'O'},
                    {'X', 'O', 'X', 'O', ' ', 'X'}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('O');
            gameLogic.setSize(6);
            gameLogic.setWinningSymbols(5);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test Win 5 O in bevel line")
        void testWin5_O_InBevelLine() {
            //Given
            char[][] boardTest = {{' ', 'O', ' ', ' ', 'O', 'O'},
                    {'O', ' ', 'O', 'O', ' ', ' '},
                    {' ', 'O', ' ', ' ', ' ', ' '},
                    {' ', 'O', 'O', ' ', 'O', ' '},
                    {' ', ' ', 'X', 'O', ' ', 'O'},
                    {'X', 'O', 'O', ' ', 'O', ' '}};
            gameLogic.setPlayer1(new Player());
            gameLogic.getPlayer1().setSymbol('O');
            gameLogic.setSize(6);
            gameLogic.setWinningSymbols(5);
            Player player1 = gameLogic.getPlayer1();
            player1.setWinRounds(0);
            gameLogic.setBoard(boardTest);
            //When
            boolean result = gameLogic.winLine(player1);
            //Then
            Assertions.assertTrue(result);
        }

        @Nested
        @DisplayName("Exception test")
        class TestException {

            BoardGame boardGame = new BoardGame();

            @Test
            @DisplayName("Test : Trying to insert a symbol off the array")
            void testTryingToInsertASymbolOffTheArray() {
                //Given
                char[][] boardTest = {{' ', 'O', ' ', ' ', 'O', 'O'},
                        {'O', ' ', 'O', 'O', ' ', ' '},
                        {' ', 'O', ' ', ' ', ' ', ' '},
                        {' ', 'O', 'O', ' ', 'O', ' '},
                        {' ', ' ', 'X', 'O', ' ', 'O'},
                        {'X', 'O', 'O', ' ', 'O', ' '}};
                //When & //Then
                assertThrows(ArrayIndexOutOfBoundsException.class, () -> boardGame.movePlayerX(boardTest, 'X', 10, 10));
            }

            @Test
            @DisplayName("Test : Trying to insert a symbol into a occupied field")
            void testTryingToInsertASymbolIntoAOccupiedField() {
                //Given
                char[][] boardTest = {{'X', 'O', ' ', ' ', 'O', 'O'},
                        {'O', ' ', 'O', 'O', ' ', ' '},
                        {' ', 'O', ' ', ' ', ' ', ' '},
                        {' ', 'O', 'O', ' ', 'O', ' '},
                        {' ', ' ', 'X', 'O', ' ', 'O'},
                        {'X', 'O', 'O', ' ', 'O', ' '}};
                //When & //Then
                assertThrows(IllegalTrafficException.class, () -> boardGame.movePlayerX(boardTest, 'X', 0, 0));
            }

        }
    }
}



