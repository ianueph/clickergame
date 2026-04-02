package com.daniel.game.ui;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

import java.util.function.Supplier;

public class CurrencyTextField implements Renderable{

    private final int x;
    private final int y;
    private final Supplier<Double> fieldSupplier;

    /*TODO: GameState should not exist in the UI elements, UI elements should be dumb.
       (apparently?, need more inquiry to this*/

    public CurrencyTextField(int x, int y, Supplier<Double> fieldSupplier) {
        this.x = x;
        this.y = y;
        this.fieldSupplier = fieldSupplier;
    }

    @Override
    public void render(Terminal terminal) {
        // Position cursor
        positionCursor(x, y, terminal);

        //Draw button
        AttributedString buttonText = new AttributedString(
                String.format("Currency: %.3f", fieldSupplier.get()),
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
