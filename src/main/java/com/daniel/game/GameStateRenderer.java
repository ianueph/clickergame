package com.daniel.game;

import com.daniel.game.core.GameUI;
import com.daniel.game.ui.Renderable;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.Display;
import org.jline.utils.InfoCmp;

import java.util.List;

public class GameStateRenderer {

    private final Terminal terminal;
    private final GameUI gameUI;
    private final Display display;

    public GameStateRenderer(GameUI gameUI, Terminal terminal) {
        this.terminal = terminal;
        this.gameUI = gameUI;
        this.display = new Display(terminal, true);

        terminal.puts(InfoCmp.Capability.clear_screen);
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
}
