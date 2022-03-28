package com.sudoku.sudoku.visual;

import com.sudoku.sudoku.domain.SudokuBoard;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SudokuShowBoardTest {

    @Test
    public void printTheBoard() {
        //Given
        SudokuShowBoard sudokuShowBoard = new SudokuShowBoard();
        SudokuBoard board = new SudokuBoard();

        System.out.println(sudokuShowBoard.showBoard(board));
    }

    @Test
    public void deletePossibleValues() {
        //Given
        List<Integer> possibleValues = IntStream.rangeClosed(1, 9)
                .boxed().collect(Collectors.toList());
        System.out.println(possibleValues);
        int x = 8;

        //When
        possibleValues.remove(Integer.valueOf(x));

        //Then
        System.out.println(possibleValues);
    }

}