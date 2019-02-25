package com.levi;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Creates ships and reads locations files.
 * @version 3.0
 * @since 2019
 * @author Levi Rosal
 */
public class Game {
    private List<String> locations1;
    private List<String> locations2;
    private String nameP1;
    private String nameP2;
    private static final String alphabet = "abcdefg";


    /**
     * Sets player and location of ship.
     * @param name1 Name of player 1.
     * @param locFile1 Location of ships of player 1.
     * @param name2 Name of player 2.
     * @param locFile2 Location of ships of player 2.
     */
    public Game(String name1, String locFile1, String name2, String locFile2) {
        locations1 = reader(locFile1);
        locations2 = reader(locFile2);
        nameP1 = name1;
        nameP2 = name2;

        System.out.println("Location " + nameP1 + ": " + locations1);  // Show locations of ships.
        System.out.println("Location " + nameP2 + ": " + locations2);  // Show locations of ships.
    }

    /**
     * Returns locations of player 1 ships.
     * @return List - List of locations.
     */
    public List<String> getLocations1() {
        return locations1;
    }

    /**
     * Returns locations of player 2 ships.
     * @return List - List of locations.
     */
    public List<String> getLocations2() {
        return locations2;
    }

    /**
     * Returns name of player 1.
     * @return String - Name of player 1.
     */
    public String getNameP1() {
        return nameP1;
    }

    /**
     * Returns name of player 2.
     * @return String - Name of player 2.
     */
    public String getNameP2() {
        return nameP2;
    }

    /**
     * Reads file and insert locations.
     * @param file Location of file.
     * @return List of locations.
     */
    public List<String> reader(String file) {
        List<String> locations = new ArrayList<>();
        int line = 0;
        String temp;

        try {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {

                for (int i = 0; i < linha.length(); i++){
                    if(linha.charAt(i) == '1'){
                        temp = String.valueOf(alphabet.charAt(line));
                        locations.add(temp.concat(Integer.toString(i)));
                    }
                }
                linha = lerArq.readLine();
                line++;
            }

            arq.close();

        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getLocalizedMessage());
        }

        return locations;
    }

    /**
     * Shows the result of game.
     */
    public void finish(final String name) {
        System.out.println("All ships are dead !!!");
        System.out.println(name + " Wins !!!");
    }

}
