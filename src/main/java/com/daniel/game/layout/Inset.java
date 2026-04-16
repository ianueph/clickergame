package com.daniel.game.layout;

public class Inset {
    public final int top, bottom, left, right;

    private Inset(int top, int bottom, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public static Inset all(int v) {
        return new Inset(v, v, v, v);
    }

    public static Inset symmetric(int vertical, int horizontal) {
        return new Inset(vertical, vertical, horizontal, horizontal);
    }

    public static Inset none() {
        return new Inset(0, 0, 0, 0);
    }

    public static Inset of(int top) {
        return new Inset(top, 0, 0, 0);
    }

    public static Inset of(int top, int bottom) {
        return new Inset(top, bottom,0 , 0);
    }

    public static Inset of(int top, int bottom, int left) {
        return new Inset(top, bottom, left, 0);
    }

    public static Inset of(int top, int bottom, int left, int right) {
        return new Inset(top, bottom, left, right);
    }
}
