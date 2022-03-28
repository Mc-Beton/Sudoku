package com.sudoku.sudoku.visual;

import com.sudoku.sudoku.domain.SudokuBoard;
import lombok.Data;

@Data
public class SudokuShowBoard {

    SudokuBoard board = new SudokuBoard();

    public static void showBoard(SudokuBoard board) {
        String hori = "===================";
        StringBuilder strBoard = new StringBuilder();
        String ele;
        for (int col = 0; col < 9; col++) {
            StringBuilder strRow = new StringBuilder("|");
            for (int row = 0; row < 9; row++) {
                if(board.getBoard().get(col).getRow().get(row).getValue() != -1) {
                    ele = String.valueOf(board.getBoard().get(col).getRow().get(row).getValue());
                } else {
                    ele = " ";
                }
                strRow.append(ele).append("|");
            }
            strBoard.append("\n").append(hori).append("\n").append(strRow);
        }
        System.out.println(strBoard + "\n" + hori);
    }
}
