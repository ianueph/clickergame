package com.daniel.game.ui;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;

import java.util.function.Supplier;

public class DynamicTextField extends TextField implements Renderable{

    private final Supplier<Double> fieldSupplier;

    public DynamicTextField(String text, Supplier<Double> fieldSupplier) {
        super(text);
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
                padLeft(formatText(text)),
                getStyle());
    }

    private String formatText(String input) {
        return  String.format(text, fieldSupplier.get());
    }
}
