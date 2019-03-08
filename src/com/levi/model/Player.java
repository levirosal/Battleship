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

    public int getNumOfGuess() {
        return numOfGuess;
    }

    public void addNumOfGuess() {
        numOfGuess += 1;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setFileLocation(final String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getName() {
        return name;
    }

    public String getFileLocation() {
        return fileLocation;
    }

}
