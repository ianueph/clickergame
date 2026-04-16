package com.daniel.game.ui;

import com.daniel.game.layout.BoundingBox;
import com.daniel.game.layout.FrameConstructor;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

public class Button extends UIComponent implements Renderable, Clickable{

    protected String text;
    protected Runnable action;

    public Button(String text, Runnable action) {
        this.text = text;
        this.action = action;
    }

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(
                " ".repeat(getX() - 1) + text,
                AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE).bold());
    }

    @Override
    public boolean isInside(int mouseX, int mouseY) {
        return this.bounds.contains(mouseX, mouseY);
    }

    @Override
    public void click() { action.run(); }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
        super.setBBox(BoundingBox.fromPosAndSize(x, y, text.length(), 1));
    }

    @Override
    public void render(FrameConstructor frame) {
        frame.drawText(
                text,
                AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE).bold(),
                x,
                y);
    }

    @Override
    public BoundingBox getBBox() {
        return bounds;
    }

    public int getX() {
        return bounds.getX0();
    }
}
