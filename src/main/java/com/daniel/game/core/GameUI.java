package com.daniel.game.core;

import com.daniel.game.layout.VerticalLayout;
import com.daniel.game.ui.*;

import java.io.IOException;
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

        try {
            setupBuildings(layout);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //TODO: also do this dynamically with xml parsing, use upgrades.xml
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

    private void setupBuildings(VerticalLayout layout) throws IOException {
        layout.addSpacing(2); //margin top 2 lines
        layout.addElement(new TextField("Buildings"));

        gameState.getBuildings().forEach((name, building) -> {
            layout.addSpacing(1);
            layout.addElement(new BuildingButton(
                    String.format("%s (%,.3f/s)", name, building.getBaseIncome()),
                    () -> gameState.buyBuilding(building)
            ));
            layout.addElement(new DynamicTextField("Rate: %,.3f /t", building::getIncomePerTick));
            layout.addElement(new DynamicTextField("Cost: %,.3f", building::getCost));
        });
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
