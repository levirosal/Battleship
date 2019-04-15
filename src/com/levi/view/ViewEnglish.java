package com.levi.view;

import com.levi.model.*;
import java.util.Scanner;

public class ViewEnglish implements GameView {
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
        System.out.println("\n");
        System.out.println("                         /\\ ");
        System.out.println("                        /  \\ ");
        System.out.println("                        \\   \\__");
        System.out.println("              _          \\   \\o\\ ");
        System.out.println("             0_|          \\   \\o\\= ");
        System.out.println("~~~~~~~~~~~~~~||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("              ||");
        System.out.println("             / |_  ");
        System.out.println("   ,--------'    '--------..._,.");
        System.out.println("  (                          _--+");
        System.out.println("   `----------------------''' `'");
        System.out.println("\n");
    }

    public void printShot(ResultShot resultShot) {
        System.out.println(resultShot + "\n");
    }

    public void printPlayer(final Board board) {
        System.out.print(board.getPlayer().getName());
    }

    /**
     * Gets guess player.
     * @return String - Value user guess.
     */
    public String getUserInput() {
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
