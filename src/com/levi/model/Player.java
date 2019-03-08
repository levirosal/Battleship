package com.levi.model;

/**
 * Create new player.
 * @version 4.0
 * @since 2019
 * @author Levi Rosal
 */
public class Player {
    private String name;
    private String locFile;

    public void setName(final String name) {
        this.name = name;
    }

    public void setLocFile(final String locFile) {
        this.locFile = locFile;
    }

    public String getName() {
        return name;
    }

    public String getLocFile() {
        return locFile;
    }

}
