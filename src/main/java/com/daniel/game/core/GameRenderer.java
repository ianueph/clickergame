package com.daniel.game.core;

import com.daniel.game.config.Settings;
import com.daniel.game.ui.Renderable;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.Display;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameRenderer extends Thread{

    private final Terminal terminal;
    private final GameUI gameUI;
    private final Display display;

    public GameRenderer(GameUI gameUI, Terminal terminal) {
        this.terminal = terminal;
        this.gameUI = gameUI;
        this.display = new Display(terminal, true);
        display.clear();
        display.resize(terminal.getHeight(), terminal.getWidth());
    }

    public void render() {
        List<AttributedString> lines = gameUI.getRenderables().stream()
                        .map(Renderable::getAttrString)
                        .toList();
        display.update(lines, 1);

        terminal.flush();
    }

    @Override
    public void run() {
        while (true) {
            long start = System.currentTimeMillis();

            render();

            try {
                long elapsed = System.currentTimeMillis() - start;
                long sleepTime = Settings.TICK_RATE_MS - elapsed;

                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
