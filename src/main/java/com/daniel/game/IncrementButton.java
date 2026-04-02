package com.daniel.game;

import org.jline.terminal.Terminal;
import org.jline.utils.*;

public class IncrementButton implements Renderable, Clickable {
    private final int x;
    private final int y;
    private final String text;
    private final GameState gameState;

    public IncrementButton(int x, int y, String text, GameState gameState) {
        this.x = x;
        this.y = y;
        this.text = "[ " + text + " ]";
        this.gameState = gameState;
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
    public void click() {
        gameState.increment();
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
