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
     */
    public static void main(String[] args) {
        BattleshipLaunch game = new BattleshipLaunch();
        game.launch();
        game.start();
    }
}
