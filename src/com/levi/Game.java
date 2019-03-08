package com.levi;

import com.levi.model.Board;
import com.levi.model.Player;
import java.util.Scanner;

/**
 * Calls for the creation of ships and requests the user's guess.
 * @version 4.0
 * @since 2019
 * @author Levi Rosal
 */
public class Game {
    private Board boardOne;
    private Board boardTwo;

    /**
     * @param boardOne Board of player one.
     * @param boardTwo Board of player two.
     */
    public Game(final Board boardOne, final Board boardTwo) {
        this.boardOne = boardOne;
        this.boardTwo = boardTwo;
    }

    /**
     * Calls the method to insert your shot and method to check guess.
     * @return Player - Winner of the game
     */
    public Player start() {
        while (!boardOne.isAllShipDestroyed() && !boardTwo.isAllShipDestroyed()) {
            String userGuess;

            System.out.print(boardOne.getPlayer().getName());
            userGuess = getUserInput();
            boardTwo.checkShot(userGuess);

            if (boardTwo.isAllShipDestroyed()) {
                return boardOne.getPlayer();
            }

            System.out.print(boardTwo.getPlayer().getName());
            userGuess = getUserInput();
            boardOne.checkShot(userGuess);
        }
        return boardTwo.getPlayer();
    }

    /**
     * Gets guess player.
     * @return String - Value user guess.
     */
    public String getUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.println(", enter the location of your shot: ");
        String inputLine = in.nextLine();

        if (inputLine.length() == 0) {
            return null;
        }
        return inputLine.toLowerCase();
    }

    /**
     * Shows the result of game.
     */
    public void finish(Player winner) {
        System.out.println("All ships are dead !!!");
        System.out.println(winner.getName() + " Wins !!!");
    }

    /**
     * Prints Table Game.
     */
    public void printTable() {
        System.out.println("\nYour goal is to sink enemy ships.");
        System.out.println(" A *  *  *  *  *  *  *");
        System.out.println(" B *  *  *  *  *  *  *");
        System.out.println(" C *  *  *  *  *  *  *");
        System.out.println(" D *  *  *  *  *  *  *");
        System.out.println(" E *  *  *  *  *  *  *");
        System.out.println(" F *  *  *  *  *  *  *");
        System.out.println(" G *  *  *  *  *  *  *");
        System.out.println("   0  1  2  3  4  5  6\n");
    }
}
