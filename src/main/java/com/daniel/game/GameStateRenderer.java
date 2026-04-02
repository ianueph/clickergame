package com.daniel.game;

import com.daniel.game.config.Settings;
import com.daniel.game.core.GameState;
import com.daniel.game.ui.Renderable;
import org.jline.terminal.Terminal;
import org.jline.utils.InfoCmp;

import java.util.concurrent.TimeUnit;

public class GameStateRenderer {

    private final Terminal terminal;
    private final GameState gameState;

    public GameStateRenderer(GameState gameState, Terminal terminal) {
        this.terminal = terminal;
        this.gameState = gameState;

        terminal.puts(InfoCmp.Capability.clear_screen);
    }

    public void render() throws InterruptedException {

        for (Renderable r: gameState.getRenderables()) {
            terminal.puts(InfoCmp.Capability.cursor_address, r.getX(), r.getY());
            r.render(terminal);
        }

        terminal.flush();
        int refreshRate = 1000 / 960;
        TimeUnit.MILLISECONDS.sleep(refreshRate);
    }
}
