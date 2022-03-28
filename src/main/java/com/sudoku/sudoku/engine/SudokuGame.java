package com.sudoku.sudoku.engine;

public class SudokuGame {
    public static void main(String[] args) throws Exception {
        boolean gameFinished = false;

        while (!gameFinished) {
            SudokuGameProcessor theGame = new SudokuGameProcessor();
            gameFinished = theGame.resolveSudoku();
        }
    }
}
