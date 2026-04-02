package com.daniel.game.ui;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

import java.util.function.Supplier;

public class CurrencyTextField extends TextField implements Renderable{

    private final Supplier<Double> fieldSupplier;

    public CurrencyTextField(int x, int y, String text, Supplier<Double> fieldSupplier) {
        super(x, y, text);
        this.x = x;
        this.y = y;
        this.fieldSupplier = fieldSupplier;
    }

    @Override
    public void render(Terminal terminal) {
        // Position cursor
        positionCursor(x, y, terminal);

        //Draw button
        AttributedString fieldText = getAttrString();
        fieldText.print(terminal);
    }

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(
                " ".repeat(getX()) + String.format(text, fieldSupplier.get()),
                AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN).bold());
    }
}
