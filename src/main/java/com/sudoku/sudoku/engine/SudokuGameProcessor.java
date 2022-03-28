package com.sudoku.sudoku.engine;

import com.sudoku.sudoku.domain.SudokuBoard;
import com.sudoku.sudoku.user.UserChoice;

import java.util.ArrayList;

public class SudokuGameProcessor {

    private SudokuBoard board;
    private SudokuSolver sudokuSolver;

    public boolean resolveSudoku() throws Exception {
        board = new SudokuBoard();
        sudokuSolver = new SudokuSolver();

        boolean finishGame = false;
        do {
            ArrayList<UserChoice> userChoices = Menu.getUserChoice();
            UserChoice choice = userChoices.get(0);
            switch (choice.getChoiceType()) {
                case EXIT:
                    finishGame = true;
                    break;
                case NONE:
                    break;
                case NEW_GAME:
                    board = new SudokuBoard();
                    sudokuSolver = new SudokuSolver();
                case SET_VALUE:
                    if (userChoices.size() >= 1) {
                        for (UserChoice userChoice: userChoices) {
                            setValue(userChoice);
                        }
                    }
                    Menu.show(board.toString());
                    break;
                case RESOLVE:
                    try {
                        sudokuSolver.solveBoard();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Menu.show(board.toString());
                    Menu.gameAgain();
                    break;
            }
        } while (!finishGame);
        return true;
    }

    private void setValue(UserChoice choice) {
        try {
            board.setValueInCell(choice.getRow() - 1, choice.getCol() - 1, choice.getVal());
        } catch (Exception e) {
            Menu.printIncorrectValueToSet(choice);
        }
    }
}
