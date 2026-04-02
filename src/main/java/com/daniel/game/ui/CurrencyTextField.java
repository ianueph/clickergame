package com.daniel.game.ui;

import com.daniel.game.core.GameState;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

public class CurrencyTextField implements Renderable{

    private final GameState gameState;
    private final int x;
    private final int y;

    /*TODO: GameState should not exist in the UI elements, UI elements should be dumb.
       (apparently?, need more inquiry to this*/

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
                String.format("Currency: %.3f", gameState.getCurrency()),
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
