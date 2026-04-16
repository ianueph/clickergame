package com.daniel.game.ui;

import com.daniel.game.layout.BoundingBox;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

public class Button extends UIComponent implements Renderable, Clickable{

    protected String text;
    protected Runnable action;

    public Button(String text, Runnable action) {
        this.text = text;
        this.action = action;
    }

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(
                " ".repeat(getX() - 1) + text,
                AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE).bold());
    }

    @Override
    public boolean isInside(int mouseX, int mouseY) {
        return this.bounds.contains(mouseX, mouseY);
    }

    @Override
    public void click() { action.run(); }

    @Override
    public void setPos(int x, int y) {
        super.setBBox(BoundingBox.fromCorner(x, y, x + text.length() - 1, y));
    }

    @Override
    public int getX() {
        return bounds.getX0();
    }
}
