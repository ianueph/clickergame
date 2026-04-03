package com.daniel.game;

import org.jline.terminal.*;

import java.util.Optional;

import static org.jline.terminal.MouseEvent.*;

public class MouseEventHandler {
    private boolean esc = false;
    private boolean bracket = false;
    private boolean mouse = false;
    private final StringBuilder buffer = new StringBuilder();

    public Optional<MouseEvent> handleMouseClick(int c) {
        // Parse escape sequences for mouse events
        if (c == '\033') {
            esc = true;
            buffer.setLength(0);
        } else if (esc && c == '[') {
            bracket = true;
        } else if (esc && bracket && c == 'M') {
            mouse = true;
            buffer.setLength(0);
        } else if (mouse && buffer.length() < 3) {
            buffer.append((char) c);

            if (buffer.length() == 3) {
                int b = buffer.charAt(0) - 32;
                int x = buffer.charAt(1) - 32;
                int y = buffer.charAt(2) - 32;

                // Reset state
                reset();

                if ((b & 3) != 3 && (b & 64) == 0) {
                    return Optional.of(
                            new MouseEvent(Type.Pressed, Button.Button1, null, x, y)
                    );
                }
            }
        } else {
            // Not a mouse event or incomplete sequence
            reset();
        }
        return Optional.empty();
    }

    private void reset() {
        esc = false;
        bracket = false;
        mouse = false;
    }
}
