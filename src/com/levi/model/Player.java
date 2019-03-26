package com.levi.model;

/**
 * Create new player.
 * @version 4.0
 * @since 2019
 * @author Levi Rosal
 */
public class Player {
    private String name;
    private String fileLocation;
    private int numOfGuess = 0;

    public void setName(final String name) {
        this.name = name;
    }

    public void setFileLocation(final String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getName() {
        return name;
    }

    public int getNumOfGuess() {
        return numOfGuess;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void addNumOfGuess() {
        numOfGuess += 1;
    }

}
