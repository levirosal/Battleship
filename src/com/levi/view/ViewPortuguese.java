package com.levi.view;

import com.levi.model.*;
import java.util.Scanner;

public class ViewPortuguese implements GameView{
    /**
     * Prints Table Game.
     */
    public void printTable() {
        System.out.println("\nSeu objetivo é afundar os navios inimigos.");
        System.out.println(" A *  *  *  *  *  *  *");
        System.out.println(" B *  *  *  *  *  *  *");
        System.out.println(" C *  *  *  *  *  *  *");
        System.out.println(" D *  *  *  *  *  *  *");
        System.out.println(" E *  *  *  *  *  *  *");
        System.out.println(" F *  *  *  *  *  *  *");
        System.out.println(" G *  *  *  *  *  *  *");
        System.out.println("   0  1  2  3  4  5  6\n");
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
        if (resultShot == ResultShot.HIT){
            System.out.println("Acertou\n");
        } else if (resultShot == ResultShot.KILL) {
            System.out.println("Destruiu\n");
        } else {
            System.out.println("Errou\n");
        }
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
        System.out.print(", insira a localização do seu tiro: ");

        while (true) {
            inputLine = in.nextLine();
            if (inputLine.length() > 0) {
                break;
            } else {
                System.out.print("Localização do tiro não pode ser vazio.\n" + "\n" + "Insira a localização do seu tiro: ");
            }
        }
        return inputLine.toLowerCase();
    }

    /**
     * Shows the result of game.
     */
    public void finish(final Player winner) {
        System.out.println("Todos os navios foram destruidos !!!");
        System.out.println(winner.getName() + " Venceu !!!");

        if(winner.getNumOfGuess() >= 18) {
            System.out.println("Demorou o suficiente. " + winner.getNumOfGuess() + " palpites.");
            System.out.println("Os peixes estão dançando com seus tiros.");
            return;
        }

        System.out.println("Só levou " + winner.getNumOfGuess() + " palpites, parabéns !!!");
    }


}
