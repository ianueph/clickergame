package com.daniel.game.ui;

import org.jline.utils.AttributedString;

public class EmptyLine implements Renderable {

    @Override
    public void setPos(int x, int y) {}

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(" ");
    }

    @Override
    public int getX() {
        return 0;
    }
}
