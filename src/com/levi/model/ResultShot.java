package com.levi.model;

public enum ResultShot {
    MISS(0), HIT(1), KILL(2);
    public int value;

    ResultShot(int value) {
        this.value = value;
    }
}
