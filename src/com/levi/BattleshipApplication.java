package com.levi;

/**
 * Main, starts the game.
 * @version 3.0
 * @since 2019
 * @author Levi Rosal
 */
public class BattleshipApplication {
    /**
     * Starts the game
     * Parameters:
     * --p1-name=
     * --p1-file=
     * --p2-name=
     * --p2-file=
     */
    public static void main(String[] args) {
        BattleshipLaunch game = new BattleshipLaunch();
        String nameP1 = args[0].substring(10,(args[0].length()));
        String locP1 = args[1].substring(10,(args[1].length()));
        String nameP2 = args[2].substring(10,(args[2].length()));
        String locP2 = args[3].substring(10,(args[3].length()));

        game.launch(nameP1, locP1, nameP2, locP2);
        game.start();
    }
}
