package com.daniel.game.ui;

import com.daniel.game.layout.BoundingBox;
import com.daniel.game.layout.FrameConstructor;
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
        return " ".repeat(getX() - 1) + input;
    }

    protected AttributedStyle getStyle() {
        return AttributedStyle.DEFAULT
                .foreground(AttributedStyle.GREEN)
                .bold();
    }

    @Override
    public void render(FrameConstructor frame) {
        frame.drawText(text, getStyle(), x, y);
    }

    @Override
    public BoundingBox getBBox() {
        return BoundingBox.fromPosAndSize(x, y, text.length(), 1);
    }
}
