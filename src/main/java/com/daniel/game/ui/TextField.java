package com.daniel.game.ui;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

public class TextField implements Renderable{

    protected int x;
    protected int y;
    protected String text;

    public TextField(String text) {
        this.text = text;
    }

    @Override
    public void render(Terminal terminal) {
        // Position cursor
        positionCursor(0, y, terminal);

        //Draw button
        AttributedString buttonText = getAttrString();
        buttonText.print(terminal);
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(
                padLeft(text),
                getStyle());
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    protected String padLeft(String input) {
        return " ".repeat(getX()) + input;
    }

    protected AttributedStyle getStyle() {
        return AttributedStyle.DEFAULT
                .foreground(AttributedStyle.GREEN)
                .bold();
    }
}
