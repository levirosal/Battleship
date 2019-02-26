package com.levi;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    Game game;
    private List<String> locations1 = new ArrayList<>();;
    private List<String> locations2 = new ArrayList<>(); ;
    private String nameP1;
    private String nameP2;
    private String locFile1;
    private String locFile2;

    @Before
    public void game() {
        nameP1 = "Levi";
        locFile1 = "/home/levi-ia/Documentos/github/Battleship/src/com/levi/player1.txt";

        nameP2 = "Pedro";
        locFile2 = "/home/levi-ia/Documentos/github/Battleship/src/com/levi/player2.txt";

        game = new Game(nameP1, locFile1, nameP2, locFile2);

    }

    @Before
    public void createList() {
        locations1.add("a2");
        locations1.add("a3");
        locations1.add("a4");

        locations2.add("e6");
        locations2.add("f6");
        locations2.add("g6");
    }

    @Test
    public void getLocations1() {
        assertArrayEquals(locations1.toArray(), game.getLocations1().toArray());
    }

    @Test
    public void getLocations2() {
        assertArrayEquals(locations2.toArray(), game.getLocations2().toArray());
    }

    @Test
    public void getNameP1() {
        assertTrue(nameP1.equals(game.getNameP1()));
    }

    @Test
    public void getNameP2() {
        assertTrue(nameP2.equals(game.getNameP2()));
    }

    @Test
    public void reader() {
        List<String> locations = new ArrayList<>();
        locations.add("a2");
        locations.add("a3");
        locations.add("a4");

        assertArrayEquals(locations.toArray(), game.reader("/home/levi-ia/Documentos/github/Battleship/src/com/levi/player1.txt").toArray());
    }
}