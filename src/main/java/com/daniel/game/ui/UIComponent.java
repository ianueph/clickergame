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
    public void setBBox(BoundingBox bBox) {
        this.bounds = bBox;
    }

    @Override
    public abstract BoundingBox getBounds();
}
