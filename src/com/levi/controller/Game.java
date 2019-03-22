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
    private GameView view;

    /**
     * @param boardOne Board of player one.
     * @param boardTwo Board of player two.
     */
    public Game(final Board boardOne, final Board boardTwo) {
        this.boardOne = boardOne;
        this.boardTwo = boardTwo;
    }

    public void setView(GameView view) {
        this.view = view;
    }

    /**
     * Starts the game.
     * @return Player - Winner of the game
     */
    public Player start() {
        view.printTable();

        while (!boardOne.isAllShipDestroyed()) {
            view.printPlayer(boardOne);
            play(boardTwo);

            if (boardTwo.isAllShipDestroyed()) {
                return boardOne.getPlayer();
            }

            view.printPlayer(boardTwo);
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
        ResultShot resultShot;

        userGuess = view.getUserInput();
        resultShot = board.checkShot(userGuess);

        view.printShot(resultShot);
    }
}
