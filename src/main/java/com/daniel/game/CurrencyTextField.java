package com.daniel.game;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

public class CurrencyTextField implements Renderable{

    private final GameState gameState;
    private final int x;
    private final int y;

    public CurrencyTextField(int x, int y, GameState gameState) {
        this.gameState = gameState;
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Terminal terminal) {
        // Position cursor
        positionCursor(x, y, terminal);

        //Draw button
        AttributedString buttonText = new AttributedString(
                "Currency: " + gameState.getCurrency(),
                AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN).bold());
        buttonText.print(terminal);
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
