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
        readerOfFile(player.getFileLocation());
        readerOfBoard();
    }

    /**
     * Reads file and adds locations in the board[][].
     * @param locFile Location of file
     */
    private void readerOfFile(final String locFile) {
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
    public ResultShot checkShot(final String userInput) {
        ResultShot result = ResultShot.MISS;
        player.addNumOfGuess();

        for(Ship ship : shipList) {
            if(ship.getLocations().contains(userInput)) {
                result = ResultShot.HIT;
                ship.removeLocation(userInput);
                if(ship.getLocations().size() == 0) {
                    result = ResultShot.KILL;
                    shipList.remove(ship);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @param line number of line.
     * @param column number of column.
     * @return Boolean - Is vertical ship or not.
     */
    private boolean isVerticalShip(final int line, final int column) {
        if (line > 5) {
            return false;
        }
        if (column >= 5) {
            return board [line][column] == 1 && board [line + 1][column] == 1;
        }
        return board [line][column] == 1 && board [line][column + 1] != 1 && board [line + 1][column] == 1;
    }

    /**
     * Adds the locations of the vertical ships in the ArrayList "locationsTemp" and calls the method to create ships.
     * @param line number of line.
     * @param column number of column.
     */
    private void verticalShip(final int line, final int column) {
        for (int k = line ; k <= 6 && board [k][column] == 1 ; k++) {
            locationsTemp.add(String.valueOf(ALPHABET.charAt(k)).concat(Integer.toString(column)));
            board[k][column] = 0;
        }
        createShip();
    }

    /**
     * @param line number of line.
     * @param column number of column.
     * @return Boolean - Is horizontal ship or not.
     */
    private boolean isHorizontalShip(final int line, final int column) {
        if (column >= 5) {
            return false;
        }
        return board [line][column] == 1;
    }

    /**
     * Adds the locations of the horizontal ships in the ArrayList "locationsTemp" and calls the method to create ships.
     * @param line number of line.
     * @param column number of column.
     */
    private void horizontalShip(final int line, final int column) {
        for (int k = column ; k <= 6 && board [line][k] == 1 ; k++) {
            locationsTemp.add(String.valueOf(ALPHABET.charAt(line)).concat(Integer.toString(k)));
            board[line][k] = 0;
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

    /**
     * @return  Boolean - All ships have been destroyed or not.
     */
    public boolean isAllShipDestroyed() {
        return shipList.isEmpty();
    }

    public Player getPlayer() {
        return player;
    }
}
