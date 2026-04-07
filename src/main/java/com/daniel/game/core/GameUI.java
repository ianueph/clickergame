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

        layout.addElement(new DynamicTextField("Currency: %,.3f",gameState::getCurrency));
        layout.addElement(new DynamicTextField("Income: %,.3f /sec", gameState::getTotalIncomePerSecond));

        layout.addSpacing(2);
        layout.addElement(new IncrementButton("Increment", gameState::increment));

        layout.addSpacing(1);
        Building matterCondenserX10 = gameState.instantiateBuilding("10xmat",100, 3, 0.20);
        layout.add(new BuildingButton(
                "wallsocket (3/s)",
                () -> gameState.buyBuilding(matterCondenserX10)
        ));
        layout.add(new DynamicTextField("Rate: %,.3f /t", matterCondenserX10::getIncomePerTick));
        layout.add(new DynamicTextField("Cost: %,.3f", matterCondenserX10::getCost));

        layout.addSpacing(2);
        layout.addElement(new TextField("Upgrades"));
        Upgrade soundcloud = gameState.instantiateUpgrade("soundcloud", "its u", 400, 0.2, 0.5);
        layout.addElement(new Button(
                "soundcloud (+0.2x its u)",
                () -> gameState.buyUpgrade(soundcloud)
        ));
        layout.addElement(new DynamicTextField("Current modifier: %,.3fx", soundcloud::getModifier));
        layout.addElement(new DynamicTextField("Cost: %,.3f", soundcloud::getCost));

        layout.addSpacing(1);
        Upgrade bandcamp = gameState.instantiateUpgrade("bandcamp", "wallsocket", 1000, 0.75, 0.75);
        layout.addElement(new Button(
                "bandcamp (+0.75x wallsocket)",
                () -> gameState.buyUpgrade(bandcamp)
        ));
        layout.addElement(new DynamicTextField("Current modifier: %,.3fx", bandcamp::getModifier));
        layout.addElement(new DynamicTextField("Cost: %,.3f", bandcamp::getCost));

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
