package com.daniel.game.ui;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

public class Button implements Renderable, Clickable{
    protected int x;
    protected int y;
    protected String text;

    public Button(int x, int y, String text) {
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
                AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE).bold());
        buttonText.print(terminal);
    }

    @Override
    public boolean isInside(int mouseX, int mouseY) {
        return mouseY == y && mouseX >= x && mouseX <= x + text.length();
    }

    @Override
    public void click() { }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
