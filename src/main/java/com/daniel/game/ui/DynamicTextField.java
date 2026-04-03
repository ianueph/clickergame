package com.daniel.game.ui;

import org.jline.utils.AttributedString;

import java.util.function.Supplier;

public class DynamicTextField extends TextField implements Renderable{

    private final Supplier<Double> fieldSupplier;

    public DynamicTextField(String text, Supplier<Double> fieldSupplier) {
        super(text);
        this.fieldSupplier = fieldSupplier;
    }

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(
                padLeft(formatText(text)),
                getStyle());
    }

    private String formatText(String input) {
        return  String.format(input, fieldSupplier.get());
    }
}
