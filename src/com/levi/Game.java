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
     * Starts the game.
     * @return Player - Winner of the game
     */
    public Player start() {
        printTable();

        while (!boardOne.isAllShipDestroyed()) {
            System.out.print(boardOne.getPlayer().getName());
            play(boardTwo);

            if (boardTwo.isAllShipDestroyed()) {
                return boardOne.getPlayer();
            }

            System.out.print(boardTwo.getPlayer().getName());
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
        userGuess = getUserInput();
        System.out.println(board.checkShot(userGuess) + "\n");
    }

    /**
     * Gets guess player.
     * @return String - Value user guess.
     */
    private String getUserInput() {
        Scanner in = new Scanner(System.in);
        String inputLine;
        System.out.print(", enter the location of your shot: ");

        while (true) {
            inputLine = in.nextLine();
            if (inputLine.length() > 0) {
                break;
            } else {
                System.out.print("The location of your shot can't be empty.\n" + "\n" + "Enter the location of your shot: ");
            }
        }
        return inputLine.toLowerCase();
    }

    /**
     * Prints Table Game.
     */
    private void printTable() {
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

    /**
     * Shows the result of game.
     */
    public void finish(final Player winner) {
        System.out.println("All ships are dead !!!");
        System.out.println(winner.getName() + " Wins !!!");

        if(winner.getNumOfGuess() >= 18) {
            System.out.println("Took you long enough. " + winner.getNumOfGuess() + " guesses.");
            System.out.println("The fish are dancing with their shots.");
            return;
        }

        System.out.println("It only took you " + winner.getNumOfGuess() + " guesses, congratulations !!!");
    }
}
