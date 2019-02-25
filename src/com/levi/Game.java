package com.levi;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * Creates ships and reads locations files.
 * @version 3.0
 * @since 2019
 * @author Levi Rosal
 */
public class Game {
    private List<String> locations1;
    private List<String> locations2;
    private static final String alphabet = "abcdefg";

    /**
     * Sets player and location of ship.
     */
    public Game() {
        locations1 = reader(1);
        locations2 = reader(2);

        System.out.println("Location Player 1: " + locations1);  // Show location ship.
        System.out.println("Location Player 2: " + locations2);  // Show location ship.
    }

    /**
     * Returns locations of player 1 ships.
     * @return List - List of locations.
     */
    public List<String> getLocations1() {
        return locations1;
    }

    /**
     * Returns locations of player2 ships.
     * @return List - List of locations.
     */
    public List<String> getLocations2() {
        return locations2;
    }

    /**
     * Reads file and insert locations.
     * @param player Player.
     * @return List of locations.
     */
    public List<String> reader(final int player) {
        Scanner in = new Scanner(System.in);
        List<String> alphaCells = new ArrayList<>();
        int line = 0;
        String temp;

        System.out.print("Insert file location of Player " + player + ": ");
        String file = in.nextLine();

        try {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {

                for (int i = 0; i < linha.length(); i++){
                    if(linha.charAt(i) == '1'){
                        temp = String.valueOf(alphabet.charAt(line));
                        alphaCells.add(temp.concat(Integer.toString(i)));
                    }
                }
                linha = lerArq.readLine();
                line++;
            }

            arq.close();

        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getLocalizedMessage());
        }

        return alphaCells;
    }

}
