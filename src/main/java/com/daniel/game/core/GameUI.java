package com.daniel.game.core;

import com.daniel.game.layout.VerticalLayout;
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

        Building matterCondenserX1 = gameState.instantiateBuilding(10, 1, 0.15);
        layout.add(new BuildingButton(
                "1x Matter Condenser",
                () -> gameState.buyBuilding(matterCondenserX1)
        ));
        layout.add(new DynamicTextField("Cost: %.3f", matterCondenserX1::getCost));

        layout.addSpacing(1);

        Building matterCondenserX10 = gameState.instantiateBuilding(100, 3, 0.20);
        layout.add(new BuildingButton(
                "10x Matter Condenser",
                () -> gameState.buyBuilding(matterCondenserX10)
        ));
        layout.add(new DynamicTextField("Cost: %.3f", matterCondenserX10::getCost));

        renderables = layout.getRenderables();
    }

    public List<Renderable> getRenderables() {
        return this.renderables;
    }
}
