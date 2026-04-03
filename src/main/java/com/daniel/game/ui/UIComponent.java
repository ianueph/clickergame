package com.daniel.game.ui;

import org.jline.utils.AttributedString;

public abstract class UIComponent implements Renderable{

    protected int x;
    protected int y;

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public abstract AttributedString getAttrString();

    @Override
    public int getX() {
        return x;
    }
}
