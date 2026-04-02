package com.daniel.game.ui;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

public class TextField implements Renderable{

    protected int x;
    protected int y;
    protected String text;

    public TextField(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    @Override
    public void render(Terminal terminal) {
        // Position cursor
        positionCursor(x, y, terminal);

        //Draw button
        AttributedString buttonText = new AttributedString(
                text,
                AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN).bold());
        buttonText.print(terminal);
    }

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(
                " ".repeat(getX()) + text,
                AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN).bold());
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
