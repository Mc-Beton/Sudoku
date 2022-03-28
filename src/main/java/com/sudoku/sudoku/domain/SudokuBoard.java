package com.sudoku.sudoku.domain;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class SudokuBoard {

    private List<SudokuRow> board = Stream.generate(SudokuRow::new)
            .limit(9).collect(Collectors.toList());

    public void setValueInCell(int row, int col, int val) {
        board.get(row).getRow().get(col).setValue(val);
        clearPossibleValues(row, col);
        deletePossibleValue(row, col, val);
    }

    public List<Integer> getPossibleValuesInCell(int row, int col) {
        return board.get(row).getRow().get(col).getPossibleValues();
    }

    private void clearPossibleValues(int row, int col) {
        board.get(row).getRow().get(col).getPossibleValues().clear();
    }

    private void deletePossibleValue(int row, int col, int val) {
        deletePossibleValueFromSquare(row, col, val);
        deletePossibleValueFromRow(row, val);
        deletePossibleValueFromCol(col, val);
    }

    private void deletePossibleValueFromCol(int col, int val) {
        for(int i=0; i<9; i++) {
            if(checkIfPossibleVal(i, col, val)) {
                board.get(i).getRow().get(col).getPossibleValues().remove(Integer.valueOf(val));
            }
        }
    }

    private void deletePossibleValueFromRow(int row, int val) {
        for(int i=0; i<9; i++) {
            if(checkIfPossibleVal(row, i, val)) {
                board.get(row).getRow().get(i).getPossibleValues().remove(Integer.valueOf(val));
            }
        }
    }

    private void deletePossibleValueFromSquare(int row, int col, int val) {
        int squareRow = determineSquare(col);
        int squareCol = determineSquare(row);
        for(int sc = squareCol; sc<squareCol + 3; sc++) {
            for (int sr = squareRow; sr < squareRow + 3; sr++) {
                if(checkIfPossibleVal(sr, sc, val)) {
                    board.get(sr).getRow().get(sc).getPossibleValues().remove(Integer.valueOf(val));
                }
            }
        }
    }

    private int determineSquare(int pos) {
        if(pos<=2) {return 0;}
        else if(pos>=3 && pos<=5) {return 3;}
        else {return 6;}
    }

    private boolean checkIfPossibleVal(int row, int col, int val) {
        return board.get(row).getRow().get(col).getPossibleValues().contains(Integer.valueOf(val));
    }
}
