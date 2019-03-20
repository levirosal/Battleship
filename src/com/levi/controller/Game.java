package com.levi.controller;

import com.levi.model.*;
import com.levi.view.*;

/**
 * Calls for the creation of ships and requests the user's guess.
 * @version 4.0
 * @since 2019
 * @author Levi Rosal
 */
public class Game {
    private Board boardOne;
    private Board boardTwo;
    private PrintsGame printsGame;

    /**
     * @param boardOne Board of player one.
     * @param boardTwo Board of player two.
     */
    public Game(final Board boardOne, final Board boardTwo) {
        this.boardOne = boardOne;
        this.boardTwo = boardTwo;
        printsGame = new PrintsGame();
    }

    /**
     * Starts the game.
     * @return Player - Winner of the game
     */
    public Player start() {
        printsGame.printTable();

        while (!boardOne.isAllShipDestroyed()) {
            printsGame.printPlayer(boardOne);
            play(boardTwo);

            if (boardTwo.isAllShipDestroyed()) {
                return boardOne.getPlayer();
            }

            printsGame.printPlayer(boardTwo);
            play(boardOne);
        }
        return boardTwo.getPlayer();
    }

    /**
     * Calls the method to insert your shot and method to check guess.
     * @param board Board for check guess.
     */
    private void play(final Board board) {
        String userGuess;
        userGuess = printsGame.getUserInput();
        System.out.println(board.checkShot(userGuess) + "\n");
    }
}
