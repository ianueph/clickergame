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

        layout.add(new DynamicTextField("Currency: %,.3f",gameState::getCurrency));
        layout.add(new DynamicTextField("Income: %,.3f /sec", gameState::getTotalIncomePerSecond));

        layout.addSpacing(2);
        layout.add(new IncrementButton("Increment", gameState::increment));

        layout.addSpacing(2);
        layout.add(new TextField("Buildings"));
        Building matterCondenserX1 = gameState.instantiateBuilding("1xmat",10, 1, 0.15);
        layout.add(new BuildingButton(
                "its u (1/s)",
                () -> gameState.buyBuilding(matterCondenserX1)
        ));
        layout.add(new DynamicTextField("Rate: %,.3f /t", matterCondenserX1::getIncomePerTick));
        layout.add(new DynamicTextField("Cost: %,.3f", matterCondenserX1::getCost));

        layout.addSpacing(1);
        Building matterCondenserX10 = gameState.instantiateBuilding("10xmat",100, 3, 0.20);
        layout.add(new BuildingButton(
                "wallsocket (3/s)",
                () -> gameState.buyBuilding(matterCondenserX10)
        ));
        layout.add(new DynamicTextField("Rate: %,.3f /t", matterCondenserX10::getIncomePerTick));
        layout.add(new DynamicTextField("Cost: %,.3f", matterCondenserX10::getCost));

        layout.addSpacing(2);
        layout.add(new TextField("Upgrades"));
        Upgrade soundcloud = gameState.instantiateUpgrade("soundcloud", "1xmat", 400, 0.2, 0.5);
        layout.add(new Button(
                "soundcloud (+0.2x its u)",
                () -> gameState.buyUpgrade(soundcloud)
        ));
        layout.add(new DynamicTextField("Current modifier: %,.3fx", soundcloud::getModifier));
        layout.add(new DynamicTextField("Cost: %,.3f", soundcloud::getCost));

        layout.addSpacing(1);
        Upgrade bandcamp = gameState.instantiateUpgrade("bandcamp", "10xmat", 1000, 0.75, 0.75);
        layout.add(new Button(
                "bandcamp (+0.75x wallsocket)",
                () -> gameState.buyUpgrade(bandcamp)
        ));
        layout.add(new DynamicTextField("Current modifier: %,.3fx", bandcamp::getModifier));
        layout.add(new DynamicTextField("Cost: %,.3f", bandcamp::getCost));

        renderables = layout.getRenderables();
    }

    public void handleClick(int x, int y) {
        for (Renderable r : renderables) {
            if (r instanceof Clickable clickable) {
                if (clickable.isInside(x, y)) {
                    clickable.click();
                    return;
                }
            }
        }
    }

    public List<Renderable> getRenderables() {
        return this.renderables;
    }
}
