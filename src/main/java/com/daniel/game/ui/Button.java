package com.daniel.game.ui;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

public class Button implements Renderable, Clickable{
    protected int x;
    protected int y;
    protected String text;
    protected Runnable action;

    public Button(String text, Runnable action) {
        this.text = text;
        this.action = action;
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(
                " ".repeat(getX()) + text,
                AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE).bold());
    }

    @Override
    public boolean isInside(int mouseX, int mouseY) {
        return mouseY == y && mouseX > x && mouseX <= x + text.length();
    }

    @Override
    public void click() { action.run(); }

    @Override
    public int getX() {
        return x;
    }
}
