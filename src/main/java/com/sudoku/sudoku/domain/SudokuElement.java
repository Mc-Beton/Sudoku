package com.sudoku.sudoku.domain;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class SudokuElement {

    public static int EMPTY = -1;

    private int value = EMPTY;
    private List<Integer> possibleValues = IntStream.rangeClosed(1, 9)
            .boxed().collect(Collectors.toList());
}
