package com.game.app;

/**
 * Reusable 2 dimensional Board class
 *
 * @author Franc dhe Ines
 * @version 2022-10-13
 */
public class Board {
    int[][] b;

    /**
     * Constructor for objects of the class Board
     * An empty board is initialized to 0s
     *
     * @param rows the number of rows in the Board
     * @param cols the number of cols in the Board
     */
    public Board(int rows, int cols) {
        this.b = new int[rows][cols];
    }

    /**
     * The get method returns the value stored at the specified
     * row, col location.
     *
     * @param row The row of the grid
     * @param col The column of the grid
     * @return the int value stored in the Board at that row and col
     */

    public int get(int row, int col) {
        return b[row][col];
    }

    /**
     * The set method sets the value specified in row and col location
     * in the Board.
     *
     * @param row The row of the grid
     * @param col The column of the grid
     * @param val The value to be set
     */

    public void set(int row, int col, int val) {
        b[row][col] = val;
    }

    /**
     * The getRows method returns the number of rows in the Board.
     *
     * @return the rows (or height) of the Board (grid)
     */

    public int getRows() {
        return b.length;
    }

    /**
     * The getCols method returns the number of columns in the Board.
     *
     * @return the columns (or width) of the Board (grid)
     */

    public int getCols() {
        return b[0].length;
    }

    /**
     * The toString method returns a String representation of the Board
     * that can be printed to display the grid.
     *
     * @return a String representing the grid.
     */

    public String toString() {
        StringBuilder board = new StringBuilder();

        for (int[] rows : b) {
            for (int col : rows) {
                board.append(col).append(" ");
            }
            board.append("\n");
        }

        return board.toString();
    }
}

