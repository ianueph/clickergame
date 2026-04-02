package com.daniel.game.ui;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;

public record EmptyLine(int y) implements Renderable {

    @Override
    public void render(Terminal terminal) {
        positionCursor(0, y, terminal);
        terminal.writer().write(" ");
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
    public int y() {
        return 0;
    }
}
