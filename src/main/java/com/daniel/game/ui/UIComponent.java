package com.daniel.game.ui;

import com.daniel.game.layout.BoundingBox;
import com.daniel.game.layout.Inset;

public abstract class UIComponent implements Renderable{

    protected int x;
    protected int y;
    protected Inset margin;
    protected Inset padding;
    protected BoundingBox bounds;

    public UIComponent() {
        this.margin = Inset.none();
        this.padding = Inset.none();
    }

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

    public int getMarginTop() {
        return margin.top;
    }

    public int getMarginBottom() {
        return margin.bottom;
    }
}
