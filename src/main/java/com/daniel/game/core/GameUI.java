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
        renderables.add(new CurrencyTextField(5, 3, "Currency: %.3f",gameState::getCurrency));
        renderables.add(new EmptyLine(4));
        renderables.add(new IncrementButton(5, 5, "Increment",
                gameState::increment
        ));
        renderables.add(new EmptyLine(6));
        renderables.add(new BuildingButton(
                5,
                7,
                "1x Matter Condenser",
                () -> gameState.buyBuilding(gameState.instantiateBuilding(10, 2))
        ));
        renderables.add(new EmptyLine(8));
        renderables.add(new BuildingButton(
                5,
                9,
                "10x Matter Condenser",
                () -> gameState.buyBuilding(gameState.instantiateBuilding(100, 10))
        ));
    }

    public List<Renderable> getRenderables() {
        return this.renderables;
    }
}
