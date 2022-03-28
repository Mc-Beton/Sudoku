package com.sudoku.sudoku.engine;

import com.sudoku.sudoku.domain.SudokuBoard;
import lombok.Data;

@Data
public class SudokuSolver {

    private SudokuBoard board;

    public void solveBoard() {
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                if (board.getPossibleValuesInCell(row, col).size() == 1) {
                    int val = board.getPossibleValuesInCell(row, col).get(0);
                    board.setValueInCell(row, col, val);
                }
            }
        }
    }
}
