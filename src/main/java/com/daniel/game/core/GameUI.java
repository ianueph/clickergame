package com.daniel.game.core;

import com.daniel.game.ui.*;

import java.util.ArrayList;
import java.util.List;

public class GameUI {

    private final GameState gameState;
    private final List<Renderable> renderables = new ArrayList<>();

    public GameUI(GameState gameState) {
        this.gameState = gameState;
        setupUI();
    }

    private void setupUI() {
        renderables.add(new EmptyLine(1));
        renderables.add(new EmptyLine(2));
        renderables.add(new DynamicTextField(5, 3, "Currency: %.3f",gameState::getCurrency));
        renderables.add(new DynamicTextField(5, 4, "Income: %.3f /sec", gameState::getTotalIncomePerSecond));
        renderables.add(new EmptyLine(5));
        renderables.add(new IncrementButton(5, 6, "Increment",
                gameState::increment
        ));
        renderables.add(new EmptyLine(7));
        renderables.add(new BuildingButton(
                5,
                8,
                "1x Matter Condenser",
                () -> gameState.buyBuilding(gameState.instantiateBuilding(10, 2))
        ));
        renderables.add(new EmptyLine(9));
        renderables.add(new BuildingButton(
                5,
                10,
                "10x Matter Condenser",
                () -> gameState.buyBuilding(gameState.instantiateBuilding(100, 10))
        ));
    }

    public List<Renderable> getRenderables() {
        return this.renderables;
    }
}
