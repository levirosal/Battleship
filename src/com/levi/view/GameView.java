package com.levi.view;

import com.levi.model.ResultShot;
import com.levi.model.Board;
import com.levi.model.Player;

public interface GameView {

    void printTable();

    void printShot(ResultShot resultShot);

    void printPlayer(final Board board);

    String getUserInput();

    void finish(final Player winner);
}
