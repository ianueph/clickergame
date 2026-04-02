package com.daniel.game.ui;

import com.daniel.game.core.GameState;
import org.jline.utils.*;

public class IncrementButton extends Button {

    private final GameState gameState;

    /*TODO: GameState should not exist in the UI elements, UI elements should be dumb.
       (apparently?, need more inquiry to this*/
    public IncrementButton(int x, int y, String text, GameState gameState) {
        super(x, y, "[ " + text + " ]");
        this.gameState = gameState;
    }

    @Override
    public void click() {
        gameState.increment();
    }
}
