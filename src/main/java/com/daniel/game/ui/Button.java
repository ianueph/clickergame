package com.daniel.game.ui;

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
                " ".repeat(getX()) + text,
                AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE).bold());
    }

    @Override
    public boolean isInside(int mouseX, int mouseY) {
        return mouseY == super.y && mouseX > super.x && mouseX <= super.x + text.length();
    }

    @Override
    public void click() { action.run(); }
}
