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
    private static final String ALPHABET = "abcdefg";
    private static final int LINE_LIMIT = 7;
    private static final int COLUMN_LIMIT = 7;
    private final int[][] board = new int [LINE_LIMIT][COLUMN_LIMIT];
    private final List<Ship> shipList = new ArrayList<>();
    private List<String> locationsTemp = new ArrayList<>();
    private final Player player;

    public Board(final Player player) {
        this.player = player;
        reader(player.getFileLocation());
        readerOfBoard();
    }

    /**
     * Reads file and adds locations in the board[][].
     * @param locFile Location of file
     */
    private void reader(final String locFile) {
        BufferedReader read = null;
        String lineValue;
        try {
            read = new BufferedReader(new FileReader(locFile));
            lineValue = read.readLine();

            for (int i = 0 ; i < LINE_LIMIT; i++) {
                for (int j = 0; j < COLUMN_LIMIT; j++) {
                    board [i][j] = Character.getNumericValue(lineValue.charAt(j));
                }
                lineValue = read.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getLocalizedMessage());
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Reads board[][] and calls methods that adds the locations of the horizontal or vertical ships.
     */
    private void readerOfBoard() {
        for (int i = 0 ; i < LINE_LIMIT; i++) {
            for (int j = 0; j < COLUMN_LIMIT; j++) {
                if (isVerticalShip(i, j)) {
                    verticalShip(i, j);
                } else if (isHorizontalShip(i, j)) {
                    horizontalShip(i, j);
                }
            }
        }
    }

    /**
     * Checks the user's guess and removes the location if the guess is correct.
     * @param userInput User Guess.
     * @return String - Result of user's guess.
     */
    public String checkShot(final String userInput) {
        String result = "miss";
        player.addNumOfGuess();

        for(Ship ship : shipList) {
            if(ship.getLocations().contains(userInput)) {
                result = "hit";
                ship.removeLocation(userInput);
                if(ship.getLocations().size() == 0) {
                    result = "KILL";
                    shipList.remove(ship);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Adds the locations of the horizontal ships in the ArrayList "locationsTemp" and calls the method to create ships.
     * @param i number of line.
     * @param j number of column.
     */
    private void horizontalShip(int i, int j) {
        for (int k = j ; k <= 6 && board [i][k] == 1 ; k++) {
            locationsTemp.add(String.valueOf(ALPHABET.charAt(i)).concat(Integer.toString(k)));
            board[i][k] = 0;
        }
        createShip();
    }

    /**
     * Adds the locations of the vertical ships in the ArrayList "locationsTemp" and calls the method to create ships.
     * @param i number of line.
     * @param j number of column.
     */
    private void verticalShip(int i, int j) {
        for (int k = i ; k <= 6 && board [k][j] == 1 ; k++) {
            locationsTemp.add(String.valueOf(ALPHABET.charAt(k)).concat(Integer.toString(j)));
            board[k][j] = 0;
        }
        createShip();
    }

    /**
     * Create Ships.
     */
    private void createShip() {
        shipList.add(new Ship(locationsTemp));
        locationsTemp = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * @param i number of line.
     * @param j number of column.
     * @return Boolean - Is vertical ship or not.
     */
    private boolean isVerticalShip(int i, int j) {
        if (i > 5) {
            return false;
        }
        if (j >= 5) {
            return board [i][j] == 1 && board [i + 1][j] == 1;
        }
        return board [i][j] == 1 && board [i][j + 1] != 1 && board [i + 1][j] == 1;
    }

    /**
     * @param i number of line.
     * @param j number of column.
     * @return Boolean - Is horizontal ship or not.
     */
    private boolean isHorizontalShip(int i, int j) {
        if (j >= 5) {
            return false;
        }
        return board [i][j] == 1;
    }

    public boolean isAllShipDestroyed() {
        return shipList.isEmpty();
    }
}
