package com.levi.model;

import java.util.List;

public class Ship {
    private List<String> locations;

    public Ship(List<String> locations) {
        this.locations = locations;
        System.out.println("Ship: " + locations);
    }

    public List<String> getLocations() {
        return locations;
    }

    public void removeLocation(final String location) {
        locations.remove(location);
    }
}
