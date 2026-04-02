package com.daniel.game.ui;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;

public interface Renderable {
    void render(Terminal terminal);
    AttributedString getAttrString();
    int getX();
    int y();
    default void positionCursor(int x, int y, Terminal terminal) {
        terminal.writer().write("\033[" + y + ";" + x + "H");
    }
}
