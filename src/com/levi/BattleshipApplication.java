package com.levi;

import com.levi.model.Board;
import com.levi.model.Player;

/**
 * Main, starts the game.
 * @version 4.0
 * @since 2019
 * @author Levi Rosal
 */
public class BattleshipApplication {

    /**
     * Gets names and locations of files, starts and finish the game.
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        Player playerTwo = new Player();

        for (int i = 0; i < args.length ; i++) {
            if (args[i].substring(0, 10).equals("--p1-name=")) {
                playerOne.setName(args[i].substring(10));
            } else if (args[i].substring(0, 10).equals("--p1-file=")) {
                playerOne.setLocFile(args[i].substring(10));
            } else if (args[i].substring(0, 10).equals("--p2-name=")) {
                playerTwo.setName(args[i].substring(10));
            } else if (args[i].substring(0, 10).equals("--p2-file=")) {
                playerTwo.setLocFile(args[i].substring(10));
            }
        }
        Board boardOne = new Board(playerOne);
        Board boardTwo = new Board(playerTwo);

        Game game = new Game(boardOne, boardTwo);
        game.printTable();
        Player winner = game.start();
        game.finish(winner);
    }
}
