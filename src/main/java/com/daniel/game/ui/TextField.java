package com.daniel.game.ui;

import com.daniel.game.layout.BoundingBox;
import com.daniel.game.layout.FrameConstructor;
import com.daniel.game.layout.Inset;
import org.jline.utils.AttributedStyle;

public class TextField extends UIComponent implements Renderable {

    protected String text;

    public TextField(String text) {
        this.text = text;
    }

    public TextField(String text, Inset margin) {
        this.text = text;
        this.margin = margin;
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
    public BoundingBox getBounds() {
        return BoundingBox.fromPosAndSize(x, y, text.length(), 1);
    }
}
