package com.sudoku.sudoku.visual;

import com.sudoku.sudoku.domain.SudokuBoard;
import lombok.Data;

import static com.sudoku.sudoku.domain.SudokuElement.EMPTY;

@Data
public class SudokuShowBoard {

    SudokuBoard board = new SudokuBoard();

    public String showBoard(SudokuBoard board) {
        String hori = "============================";
        String strBoard = "";
        String ele = "";
        for (int col = 0; col < 9; col++) {
            String strRow = "|";
            for (int row = 0; row < 9; row++) {
                if(board.getBoard().get(col).getRow().get(row).getValue() != -1) {
                    ele = String.valueOf(board.getBoard().get(col).getRow().get(row).getValue());
                } else {
                    ele = "  ";
                }
                strRow = strRow + ele + "|";
            }
            strBoard = strBoard + "\n" + hori + "\n" + strRow;
        }
        return strBoard + "\n" + hori;
    }
}
