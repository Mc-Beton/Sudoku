package com.sudoku.sudoku.user;

import lombok.Data;

@Data
public class UserChoice {

    private ChoiceType choiceType;
    private int row;
    private int col;
    private int val;

    public UserChoice(ChoiceType userChoiceType) {
        this.choiceType = userChoiceType;
    }

    public UserChoice(int row, int col, int val) {
        this.choiceType = ChoiceType.SET_VALUE;
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
