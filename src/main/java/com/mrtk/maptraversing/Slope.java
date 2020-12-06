package com.mrtk.maptraversing;

public class Slope {

    private final int right;
    private final int down;

    public Slope(int right, int down) {
        this.right = right;
        this.down = down;
    }

    public int getRight() {
        return right;
    }

    public int getDown() {
        return down;
    }
}
