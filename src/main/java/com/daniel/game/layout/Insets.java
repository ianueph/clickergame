package com.daniel.game.layout;

public class Insets {
    public int top, bottom, left, right;

    private Insets(int top, int bottom, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public Insets all(int v) {
        return new Insets(v, v, v, v);
    }

    public Insets symmetric(int vertical, int horizontal) {
        return new Insets(vertical, vertical, horizontal, horizontal);
    }
}
