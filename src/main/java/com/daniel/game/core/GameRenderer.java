package com.daniel.game.core;

import com.daniel.game.ui.Renderable;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.Display;
import org.jline.utils.InfoCmp;

import java.util.List;

public class GameRenderer {

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
}
