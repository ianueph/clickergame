package com.daniel.game.core;

import com.daniel.game.ui.Clickable;
import com.daniel.game.GameStateRenderer;
import com.daniel.game.MouseEventHandler;
import com.daniel.game.ui.Renderable;
import org.jline.terminal.*;
import org.jline.utils.*;

import java.io.IOException;

public class GameLoop {
    public static void main(String[] args) throws IOException {
        GameState gameState = new GameState(50);
        Terminal terminal = TerminalBuilder.builder().build();
        GameStateRenderer renderer = new GameStateRenderer(gameState, terminal);
        NonBlockingReader reader = terminal.reader();

        try {
            // Enable mouse tracking
            terminal.trackMouse(Terminal.MouseTracking.Normal);

            MouseEventHandler handler = new MouseEventHandler();

            while (true) {
                if (reader.available() > 0) {
                    int c = reader.read();

                    handler.handler(c).ifPresent(mouseEvent -> {
                        for (Renderable r: gameState.getRenderables()) {
                            if (r instanceof Clickable clickable) {

                                if (clickable.isInside(mouseEvent.getX(), mouseEvent.getY())) {
                                    clickable.click();
                                    break;
                                }
                            }
                        }
                    });
                }

                try {
                    renderer.render();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }

                gameState.tick();
            }
        } finally {
            // Disable mouse tracking before exiting
            terminal.trackMouse(Terminal.MouseTracking.Off);

            terminal.close();
        }
    }
}