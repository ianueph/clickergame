package com.daniel.game.ui;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

public class TextField extends UIComponent implements Renderable{

    protected String text;

    public TextField(String text) {
        this.text = text;
    }

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(
                padLeft(text),
                getStyle());
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
