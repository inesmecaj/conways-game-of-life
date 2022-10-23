package com.game.app;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Board board = new Board(Life.ROWS, Life.COLS);
        Board nextBoard = new Board(Life.ROWS, Life.COLS);
        Life.initializeBoard(board);
        for (int i = 0; i < Life.ITERATION_NUMBER; i++) {
            Life.clearConsole();
            Life.displayBoard(board);
            Life.slow(Life.TIME_DELAY);
            Life.calculateNextGeneration(board, nextBoard);
            Life.transferNextToCurrent(board, nextBoard);
        }
    }
}
