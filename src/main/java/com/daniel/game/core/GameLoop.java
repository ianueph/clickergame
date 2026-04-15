package com.daniel.game.core;

import com.daniel.game.config.Settings;
import com.daniel.game.MouseEventHandler;
import org.jline.terminal.*;
import org.jline.utils.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GameLoop {
    public static void main(String[] args) throws IOException {
        GameState gameState = new GameState(500);
        GameUI gameUI = new GameUI(gameState);
        Terminal terminal = TerminalBuilder.builder().build();
        GameRenderer renderer = new GameRenderer(gameUI, terminal);
        NonBlockingReader reader = terminal.reader();

        renderer.start();
        try {
            // Enable mouse tracking
            terminal.trackMouse(Terminal.MouseTracking.Normal);
            MouseEventHandler handler = new MouseEventHandler();

            terminal.flush();
            terminal.puts(InfoCmp.Capability.clear_screen);
            terminal.flush();

            while (true) {
                long start = System.currentTimeMillis();
                if (reader.available() > 0) {
                    int c = reader.read();

                    handler.handleMouseClick(c).ifPresent(mouseEvent -> {
                        gameUI.handleClick(mouseEvent.getX(), mouseEvent.getY());
                    });
                }

                gameState.tick();

                try {
                    long elapsed = System.currentTimeMillis() - start;
                    long sleepTime = Settings.TICK_RATE_MS - elapsed;

                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        } finally {
            // Disable mouse tracking before exiting
            terminal.trackMouse(Terminal.MouseTracking.Off);

            terminal.close();
        }
    }
}