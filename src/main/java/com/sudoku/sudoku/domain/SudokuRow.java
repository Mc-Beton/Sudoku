package com.sudoku.sudoku.domain;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class SudokuRow {

    private List<SudokuElement> row = Stream.generate(SudokuElement::new)
            .limit(9).collect(Collectors.toList());
}
