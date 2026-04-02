package com.daniel.game;

import org.jline.terminal.Terminal;

public interface Renderable {
    void render(Terminal terminal);
    int getX();
    int getY();
    default void positionCursor(int x, int y, Terminal terminal) {
        terminal.writer().write("\033[" + y + ";" + x + "H");
    }
}
