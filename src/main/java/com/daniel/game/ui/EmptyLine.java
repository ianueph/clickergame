package com.daniel.game.ui;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;

public class EmptyLine implements Renderable {

    private int x;
    private int y;

    public EmptyLine(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Terminal terminal) {
        positionCursor(0, y, terminal);
        terminal.writer().write(" ");
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(" ");
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return y;
    }
}
