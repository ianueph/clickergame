package com.daniel.game.layout;

public class BoundingBox {
    private final int x0;
    private final int y0;
    private final int x1;
    private final int y1;

    /*
    (x0,y0)---------------------(x1,y0)
    |                                 |
    |                                 |
    |      Example of a bounding      |
    |              box                |
    |                                 |
    |                                 |
    (x0,y1)---------------------(x1,y1)

     */

    private BoundingBox(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public static BoundingBox fromCorner(int x0, int y0, int x1, int y1) {
        return new BoundingBox(x0, y0, x1, y1);
    }

    public static BoundingBox fromPosAndSize(int x0, int y0, int length, int height) {
        return new BoundingBox(x0, y0, x0 + length - 1, y0 + height - 1);
    }

    public boolean contains(int px, int py) {
        return px >= x0 && px <= x1 && py >= y0 && py <= y1;
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }
}
