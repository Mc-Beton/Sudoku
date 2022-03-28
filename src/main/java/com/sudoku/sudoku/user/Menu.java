package com.sudoku.sudoku.user;

import lombok.Data;

import java.util.ArrayList;
import java.util.Scanner;

@Data
public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    private static String menuText() {
        return "SUDOKU\n" +
                "Hello and welcome to the Great Sudoku Solver\n"+
                "To start, type in any command listed below\n"+
                "Type 3 numbers: RCV, where:\n" +
                "R is for row, C is for column and V is for value, example: 264\n" +
                "or multiple rcv values with one string, example: 153873469\n\n" +
                "Other options:\n" +
                "sudoku - try to solve the Sudoku\n" +
                "n - start a new game\n" +
                "x - exit the game";
    }

    public static ArrayList<UserChoice> getUserChoice() {
        System.out.println(menuText());
        System.out.println();

        String input = scanner.next();
        boolean isDigits = input.chars().allMatch(Character::isDigit);
        boolean digitsCorrectLength = input.length() % 3 == 0 || input.length() > 3;
        ArrayList<UserChoice> userChoices = new ArrayList<>();

        switch (input.toLowerCase()) {
            case "sudoku":
                userChoices.add(new UserChoice(ChoiceType.RESOLVE));
                return userChoices;
            case "n" :
                userChoices.add(startNewGame());
                return userChoices;
            case "x" :
                userChoices.add(exitGame());
                return userChoices;
            default:
                if(isDigits && digitsCorrectLength) {
                    char[] inputTab = input.toCharArray();
                    return getDigitLength(userChoices, inputTab);
                } else {
                    userChoices.add(new UserChoice(ChoiceType.NONE));
                    return userChoices;
                }
        }
    }

    private static ArrayList<UserChoice> getDigitLength(ArrayList<UserChoice> userChoices, char[] inputTab) {
        if (inputTab.length >= 3 && inputTab.length < 6) {
            int col = Character.getNumericValue(inputTab[0]);
            int row = Character.getNumericValue(inputTab[1]);
            int val = Character.getNumericValue(inputTab[2]);
            userChoices.add(new UserChoice(row, col, val));
            return userChoices;
        } else {
            int numberOfThrees = inputTab.length / 3;
            for (int i = 0; i < numberOfThrees; i++) {
                int col = Character.getNumericValue(inputTab[i*3]);
                int row = Character.getNumericValue(inputTab[i*3 + 1]);
                int val = Character.getNumericValue(inputTab[i*3 + 2]);
                userChoices.add(new UserChoice(row, col, val));
            }
            return userChoices;
        }
    }

    private static UserChoice startNewGame() {
        boolean correctInput = false;
        do {
            System.out.println("Do you want to start a new game? y/n");
            String input = scanner.next();
            if(input.equalsIgnoreCase("y")) {
                correctInput = true;
                return new UserChoice(ChoiceType.NEW_GAME);
            }
            if(input.equalsIgnoreCase("n")) {
                correctInput = true;
                return new UserChoice(ChoiceType.NONE);
            }
        } while (!correctInput);
        return new UserChoice(ChoiceType.NONE);
    }

    public static UserChoice gameAgain() {
        boolean correctInput = false;
        do {
            System.out.println("Do you want to play again? y/n");
            String input = scanner.next();
            if(input.equalsIgnoreCase("y")) {
                correctInput = true;
                return new UserChoice(ChoiceType.NEW_GAME);
            }
            if(input.equalsIgnoreCase("n")) {
                correctInput = true;
                return new UserChoice(ChoiceType.EXIT);
            }
        } while (!correctInput);
        return new UserChoice(ChoiceType.NONE);
    }

    private static UserChoice exitGame() {
        boolean correctInput = false;
        do {
            System.out.println("Do you want exit? y/n");
            String input = scanner.next();
            if(input.equalsIgnoreCase("y")) {
                correctInput = true;
                return new UserChoice(ChoiceType.EXIT);
            }
            if(input.equalsIgnoreCase("n")) {
                correctInput = true;
                return new UserChoice(ChoiceType.NONE);
            }
        } while (!correctInput);
        return new UserChoice(ChoiceType.NONE);
    }

    public static void printIncorrectValueToSet(UserChoice choice) {
        System.out.println("Incorrect value: " + choice);
    }

    public static void show(String text) {
        System.out.println(text);
    }
}

