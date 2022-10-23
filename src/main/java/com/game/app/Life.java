package com.game.app;

import java.io.IOException;

/**
 * The Life class simulates Conway's game of life.
 *
 * @author Franc dhe Ines
 * @version 2022-10-13
 */
public class Life {
    // TODO: check if there is a need to change the grid values
    public static final int ROWS = 25;
    public static final int COLS = 100;
    public static final int TIME_DELAY = 20; // ms
    public static final int ITERATION_NUMBER = 500;

    /**
     * The initializeBoard static method sets up the initial board with
     * a random set of cells.
     *
     * @param board a Board, defined as empty
     */
    public static void initializeBoard(Board board) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int randVal = (int) (Math.random() * 4); // 0, 1, 2 ose 3 (25% shanc)
                if (randVal == 0) {
                    board.set(r, c, 1);
                }
            }
        }
    }

    /**
     * The displayBoard static method displays the board on the screen of the user.
     * A board is a 2-dimensional int[][] array. Special characters ("-", "|", ".")
     * will need to be printed on the screen after checking the int value of the location.
     *
     * @param board The board to be displayed
     */
    public static void displayBoard(Board board) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board.get(r, c) == 0) {
                    System.out.print(".");
                } else if (board.get(r, c) == 1) {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }


    /**
     * The calculateNextGeneration static method takes the current board and a new empty board
     * and calculates the next generation for that second board based on the standard rules
     * from Conway's game of life:
     * 1. existing cell dies if fewer than 2 neighbours (underpopulation)
     * 2. existing cell lives if 2-3 neighbours ("this is the right amount of NEIGHBOURS!")
     * 3. existing cell dies if greater than 3 neighbours (overpopulation)
     * 4. empty cell becomes alive if exactly 3 neighbours (reproduction)
     *
     * @param b     the current board
     * @param nextB a board with the new generation in it
     */
    public static void calculateNextGeneration(Board b, Board nextB) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int neighboursCounted = countNeighbours(r, c, b);

                if (b.get(r, c) == 1 && neighboursCounted < 2) {
                    nextB.set(r, c, 0);
                } else if (b.get(r, c) == 1 && neighboursCounted < 4) {
                    nextB.set(r, c, 1);
                } else if (b.get(r, c) == 1 && neighboursCounted > 3) {
                    nextB.set(r, c, 0);
                } else if (b.get(r, c) == 0 && neighboursCounted == 3) {
                    nextB.set(r, c, 1);
                } else {
                    nextB.set(r, c, 0);
                }
            }
        }
    }


    /**
     * The countNeighbours static method counts the eight cells around the given cell
     * and makes sure not to count the cell itself or count out of bounds!
     *
     * @param row row of the current cell
     * @param col col of the current cell
     * @param b   the board we are investigating
     * @return the number of non-zero neighbours (min 0, max 8)
     */
    public static int countNeighbours(int row, int col, Board b) {
        int count = 0;

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                // i want a legal cell in the board
                if (r >= 0 && r < ROWS && c >= 0 && c < COLS && !(r == row && c == col) && b.get(r, c) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * The static method transferNextToCurrent takes the board with the
     * next generation and copies it to the board with the current generation
     * in order to give us the possibility to display and analyze the next generation.
     *
     * @param b         the current board that we will copy to
     * @param nextBoard the next board containing a calculated new generation
     */
    public static void transferNextToCurrent(Board b, Board nextBoard) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                b.set(r, c, nextBoard.get(r, c));
            }
        }
    }

    /**
     * The clearConsole method attempts to clear the console so that successive
     * generations can be shown to the user.
     */

    public static void clearConsole() throws IOException, InterruptedException {
        // Windows related solution to clear the console
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void slow(int TIME_DELAY) {
        try {
            Thread.sleep(TIME_DELAY); // TIME_DELAY is an integer in milliseconds
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

