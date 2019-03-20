package com.levi.controller;

import com.levi.model.Board;
import com.levi.model.Player;
import com.levi.view.PrintsGame;

/**
 * Main, starts the game.
 * @version 4.0
 * @since 2019
 * @author Levi Rosal
 */
public class BattleshipApplication {
    private static final Player PLAYER_ONE = new Player();
    private static final Player PLAYER_TWO = new Player();
    private static final PrintsGame PRINT = new PrintsGame();

    /**
     * Gets names and locations of files, start and finish the game.
     */
    public static void main(String[] args) {
        for (int i = 0; i < args.length ; i++) {
            setPlayers(args[i]);
        }

        Board boardOne = new Board(PLAYER_ONE);
        Board boardTwo = new Board(PLAYER_TWO);

        Game game = new Game(boardOne, boardTwo);

        Player winner = game.start();
        PRINT.finish(winner);
    }

    /**
     * Receives argument and sets name and location of file.
     * @param arg Argument received when starting the application.
     */
    private static void setPlayers(final String arg) {
        if (arg.substring(0, 10).equals("--p1-name=")) {
            PLAYER_ONE.setName(arg.substring(10));
        } else if (arg.substring(0, 10).equals("--p1-file=")) {
            PLAYER_ONE.setFileLocation(arg.substring(10));
        } else if (arg.substring(0, 10).equals("--p2-name=")) {
            PLAYER_TWO.setName(arg.substring(10));
        } else if (arg.substring(0, 10).equals("--p2-file=")) {
            PLAYER_TWO.setFileLocation(arg.substring(10));
        }
    }
}
