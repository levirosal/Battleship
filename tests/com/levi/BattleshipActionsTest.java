package com.levi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class BattleshipActionsTest {
    private BattleshipActions actionsTest = new BattleshipActions();
    private List<String> locations1 = new ArrayList<>();
    private List<String> locations2 = new ArrayList<>();

    @Before
    public void createList() {
        locations1.add("b1");
        locations1.add("b2");
        locations1.add("b3");

        locations2.add("c1");
        locations2.add("c2");
        locations2.add("c3");

        actionsTest.setLocations1(locations1);
        actionsTest.setLocations2(locations2);
    }

    @Test
    public void removeLocation() {
        actionsTest.removeLocation(1, "c2");
        actionsTest.removeLocation(2, "b2");

        assertFalse(locations1.equals(actionsTest.getLocations(2)));
        assertFalse(locations2.equals(actionsTest.getLocations(1)));

    }

    @Test
    public void getLocations() {
        assertArrayEquals(locations1.toArray(), actionsTest.getLocations(2).toArray());
        assertArrayEquals(locations2.toArray(), actionsTest.getLocations(1).toArray());
    }

    @Test
    public void setLocations1() {
        assertArrayEquals(locations1.toArray(), actionsTest.getLocations(2).toArray());
    }

    @Test
    public void setLocations2() {
        assertArrayEquals(locations2.toArray(), actionsTest.getLocations(1).toArray());
    }

    @Test
    public void checkShot() {
        assertTrue(actionsTest.checkShot(1, "b2").equals("miss"));
        assertTrue(actionsTest.checkShot(1, "c1").equals("hit"));
        assertTrue(actionsTest.checkShot(1, "c2").equals("hit"));
        assertTrue(actionsTest.checkShot(1, "c3").equals("kill"));


        assertTrue(actionsTest.checkShot(2, "c2").equals("miss"));
        assertTrue(actionsTest.checkShot(2, "b1").equals("hit"));
        assertTrue(actionsTest.checkShot(2, "b2").equals("hit"));
        assertTrue(actionsTest.checkShot(2, "b3").equals("kill"));
    }
}