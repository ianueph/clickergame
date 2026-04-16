package com.daniel.game.core;

import com.daniel.game.layout.VerticalLayout;
import com.daniel.game.ui.*;

import java.util.List;

public class GameUI {

    private final GameState gameState;
    private final VerticalLayout layout = new VerticalLayout(5, 3);

    public GameUI(GameState gameState) {
        this.gameState = gameState;
        setupUI();
    }

    private void setupUI() {

        layout.addElement(new DynamicTextField("Currency: %,.3f",gameState::getCurrency));
        layout.addElement(new DynamicTextField("Income: %,.3f /sec", gameState::getTotalIncomePerSecond));
        layout.addElement(new IncrementButton("Increment", gameState::increment));

        setupBuildings(layout);
        setupUpgrades(layout);
    }

    private void setupBuildings(VerticalLayout layout) {
        layout.addElement(new TextField("Buildings"));

        gameState.getBuildings().forEach((name, building) -> {
            layout.addElement(new BuildingButton(
                    String.format("%s (%,.3f/s)", name, building.getBaseIncome()),
                    () -> gameState.buyBuilding(building)
            ));
            layout.addElement(new DynamicTextField("Rate: %,.3f /t", building::getIncomePerTick));
            layout.addElement(new DynamicTextField("Cost: %,.3f", building::getCost));
        });
    }

    private void setupUpgrades(VerticalLayout layout) {
        layout.addElement(new TextField("Upgrades"));

        gameState.getUpgrades().forEach((name, upgrade) -> {
            layout.addElement(new Button(
                    String.format("%s (+%,.3fx %s)", name, upgrade.getBaseModifier(), upgrade.getTargetBuildingID()),
                    () -> gameState.buyUpgrade(upgrade)
            ));
            layout.addElement(new DynamicTextField("Current modifier: %,.3fx", upgrade::getModifier));
            layout.addElement(new DynamicTextField("Cost: %,.3f", upgrade::getCost));
        });
    }

    public void handleClick(int x, int y) {
        for (Renderable r : layout.getRenderables()) {
            if (r instanceof Clickable clickable) {
                if (clickable.isInside(x, y)) {
                    clickable.click();
                    return;
                }
            }
        }
    }

    public List<Renderable> getRenderables() {
        return layout.getRenderables();
    }
}
