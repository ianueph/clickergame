package com.daniel.game.ui;

import com.daniel.game.layout.FrameConstructor;
import com.daniel.game.layout.Inset;

import java.util.function.Supplier;

public class DynamicTextField extends TextField implements Renderable{

    private final Supplier<Double> fieldSupplier;

    public DynamicTextField(String text, Supplier<Double> fieldSupplier) {
        super(text);
        this.fieldSupplier = fieldSupplier;
    }

    public DynamicTextField(String text, Supplier<Double> fieldSupplier, Inset margin) {
        super(text, margin);
        this.fieldSupplier = fieldSupplier;
    }

    @Override
    public void render(FrameConstructor frame) {
        frame.drawText(formatText(text), getStyle(), x, y);
    }

    private String formatText(String input) {
        return  String.format(input, fieldSupplier.get());
    }
}
