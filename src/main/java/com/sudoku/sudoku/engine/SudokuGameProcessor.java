package com.sudoku.sudoku.engine;

import com.sudoku.sudoku.domain.SudokuBoard;
import com.sudoku.sudoku.user.Menu;
import com.sudoku.sudoku.user.UserChoice;
import com.sudoku.sudoku.visual.SudokuShowBoard;

import java.util.ArrayList;

public class SudokuGameProcessor {

    private SudokuBoard board;

    public boolean resolveSudoku() {
        board = new SudokuBoard();

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
                case SET_VALUE:
                    if (userChoices.size() >= 1) {
                        for (UserChoice userChoice: userChoices) {
                            setValue(userChoice);
                        }
                    }
                    Menu.show(board.toString());
                    SudokuShowBoard.showBoard(board);
                    break;
                case RESOLVE:
                    try {
                        SudokuSolver.solveBoard(board);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SudokuShowBoard.showBoard(board);
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
