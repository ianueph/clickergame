package com.daniel.game.ui;

import com.daniel.game.core.Building;
import com.daniel.game.core.GameState;

public class BuildingButton extends Button {

    private final GameState gameState;
    private final Building building;

    /*TODO: GameState should not exist in the UI elements, UI elements should be dumb.
       (apparently?, need more inquiry to this*/
    public BuildingButton(int x, int y, String text, GameState gameState, Building building) {
        super(x, y, text);
        this.gameState = gameState;
        this.building = building;
    }

    @Override
    public void click() {
        gameState.buyBuilding(building);
    }
}
