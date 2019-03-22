package com.levi.view;

import com.levi.model.*;

public interface GameView {

    void printTable();

    void printShot(ResultShot resultShot);

    void printPlayer(final Board board);

    String getUserInput();

    void finish(final Player winner);
}
