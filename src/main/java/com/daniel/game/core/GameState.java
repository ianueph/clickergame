package com.daniel.game.core;

import com.daniel.game.ui.BuildingButton;
import com.daniel.game.ui.CurrencyTextField;
import com.daniel.game.ui.IncrementButton;
import com.daniel.game.ui.Renderable;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private double currency;
    private final List<Building> buildings;
    private final List<Renderable> renderables = new ArrayList<>();

    public GameState(int currency) {
        this.currency = currency;
        this.buildings = new ArrayList<>();
        setupUI();
    }

    //TODO: move UI stuff out of GameState
    private void setupUI() {
        renderables.add(new CurrencyTextField(5, 3, this::getCurrency));
        renderables.add(new IncrementButton(5, 5, "Increment",
                this::increment
        ));
        Building matterCondenser = instantiateBuilding(10, 2);

        renderables.add(new BuildingButton(
                5,
                7,
                "1x Matter Condenser",
                () -> buyBuilding(matterCondenser)
        ));

        Building matterCondenser10 = instantiateBuilding(100, 10);
        renderables.add(new BuildingButton(
                5,
                9,
                "10x Matter Condenser",
                () -> buyBuilding(matterCondenser10)
        ));
    }

    public List<Renderable> getRenderables() {
        return this.renderables;
    }

    public void increment() {
        this.currency += 1;
    }

    public double getCurrency() {
        return this.currency;
    }

    public void tick() {
        currency += buildings.stream()
                .mapToDouble(Building::getIncomePerTick)
                .sum();
    }

    public void buyBuilding(Building building) {
        double cost = building.getBaseCost();

        if (currency >= cost) {
            currency -= cost;
            building.addBuilding();
        }
    }

    private Building instantiateBuilding(int baseCost, int baseIncome) {
        Building newBuilding = new Building(baseCost, baseIncome, 0);
        buildings.add(newBuilding);
        return newBuilding;
    }
}
