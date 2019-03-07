package com.levi.model;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Creates ships and reads locations files.
 * @version 4.0
 * @since 2019
 * @author Levi Rosal
 */
public class Board {
    private final List<Ship> shipList = new ArrayList<>();
    private static final String ALPHABET = "abcdefg";
    private static final int LINE_LIMIT = 7;
    private static final int COLUMN_LIMIT = 7;
    private Player player;

    public Board(Player player) {
        this.player = player;
        reader(this.player.getLocFile());
    }


    public void reader(String locFile) {
        try {
            String temp;
            List<String> locationsTemp = new ArrayList<>();
            FileReader file = new FileReader(locFile);
            BufferedReader read = new BufferedReader(file);
            String lineValue = read.readLine();

            for (int i = 0 ; i < LINE_LIMIT; i++) {

                for (int j = 0; j < COLUMN_LIMIT; j++) {
                    if (lineValue.charAt(j) == '1') {
                        temp = String.valueOf(ALPHABET.charAt(i));
                        locationsTemp.add(temp.concat(Integer.toString(j)));
                    }
                    if (locationsTemp.size() == 3) {
                        shipList.add(new Ship(locationsTemp));
                        locationsTemp = new ArrayList<>();
                    }
                }
                lineValue = read.readLine();
            }

            file.close();

        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getLocalizedMessage());
        }
    }

    public String checkShot(final String userInput) {
        String result = "miss";

        for(Ship ship : shipList) {
            if(ship.getLocations().contains(userInput)) {
                result = "hit";
                ship.removeLocation(userInput);
                if(ship.getLocations().size() == 0) {
                    result = "kill";
                    shipList.remove(ship);
                    if (shipList.isEmpty()) {
                        return "killAll";
                    }
                    break;
                }
            }
        }
        System.out.println(result + "\n");
        return result;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isAllShipDestroyed() {
        return shipList.isEmpty();
    }
}
