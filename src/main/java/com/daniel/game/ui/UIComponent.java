package com.daniel.game.ui;

import com.daniel.game.layout.BoundingBox;
import com.daniel.game.layout.Insets;

public abstract class UIComponent implements Renderable{

    protected int x;
    protected int y;
    protected Insets margin;
    protected Insets padding;
    protected BoundingBox bounds;

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setBBox(int x0, int y0, int x1, int y1) {
        this.bounds = BoundingBox.fromCorner(x0, y0, x1, y1);
    }

    @Override
    public void setBBox(BoundingBox bBox) {
        this.bounds = bBox;
    }

    @Override
    public BoundingBox getBBox() {
        return this.bounds;
    }

    @Override
    public abstract AttributedString getAttrString();

    public int getX() {
        return x;
    }
}
