package com.daniel.game.core;

import com.daniel.game.ui.*;

import java.util.ArrayList;
import java.util.List;

public class GameUI {

    private final GameState gameState;
    private List<Renderable> renderables = new ArrayList<>();

    public GameUI(GameState gameState) {
        this.gameState = gameState;
        setupUI();
    }

    private void setupUI() {
        VerticalLayout layout = new VerticalLayout(5, 3);

        layout.add(new DynamicTextField("Currency: %.3f",gameState::getCurrency));
        layout.add(new DynamicTextField("Income: %.3f /sec", gameState::getTotalIncomePerSecond));
        layout.addSpacing(2);
        layout.add(new IncrementButton("Increment", gameState::increment));
        layout.addSpacing(1);
        layout.add(new BuildingButton(
                "1x Matter Condenser",
                () -> gameState.buyBuilding(gameState.instantiateBuilding(10, 2))
        ));
        layout.addSpacing(1);
        layout.add(new BuildingButton(
                "10x Matter Condenser",
                () -> gameState.buyBuilding(gameState.instantiateBuilding(100, 10))
        ));

        renderables = layout.getRenderables();
    }

    public List<Renderable> getRenderables() {
        return this.renderables;
    }
}
