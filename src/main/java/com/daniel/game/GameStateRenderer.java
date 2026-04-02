package com.daniel.game;

import com.daniel.game.config.Settings;
import com.daniel.game.core.GameState;
import com.daniel.game.ui.Renderable;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.Display;
import org.jline.utils.InfoCmp;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameStateRenderer {

    private final Terminal terminal;
    private final GameState gameState;
    private final Display display;

    public GameStateRenderer(GameState gameState, Terminal terminal) {
        this.terminal = terminal;
        this.gameState = gameState;
        this.display = new Display(terminal, true);

        terminal.puts(InfoCmp.Capability.clear_screen);
        display.clear();
        display.resize(terminal.getHeight(), terminal.getWidth());
    }

    public void render() throws InterruptedException {

        List<AttributedString> lines = gameState.getRenderables().stream()
                        .map(Renderable::getAttrString)
                        .toList();
        display.update(lines, 1);

        terminal.flush();
        int refreshRate = Settings.TICK_RATE_MS;
        TimeUnit.MILLISECONDS.sleep(refreshRate);
    }
}
