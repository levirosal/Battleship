package com.levi.model;

import java.util.List;

/**
 * Create new ship.
 * @version 4.0
 * @since 2019
 * @author Levi Rosal
 */
public class Ship {
    private List<String> locations;

    public Ship(final List<String> locations) {
        this.locations = locations;
//        System.out.println("Ship: " + locations);
    }

    public List<String> getLocations() {
        return locations;
    }

    public void removeLocation(final String location) {
        locations.remove(location);
    }
}
