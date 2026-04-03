package com.daniel.game.core;

import com.daniel.game.config.Settings;
import com.daniel.game.ui.*;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private double currency;
    private final List<Building> buildings;

    public GameState(int currency) {
        this.currency = currency;
        this.buildings = new ArrayList<>();
    }

    public void increment() {
        this.currency += 1;
    }

    public double getCurrency() {
        return this.currency;
    }

    public void tick() {
        currency += getTotalIncomePerTick();
    }

    public double getTotalIncomePerSecond() {
        return getTotalIncomePerTick() * Settings.FRAME_RATE;
    }

    private double getTotalIncomePerTick() {
        return buildings.stream()
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

    public Building instantiateBuilding(int baseCost, int baseIncome) {
        Building newBuilding = new Building(baseCost, baseIncome, 0);
        buildings.add(newBuilding);
        return newBuilding;
    }
}
