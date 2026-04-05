package com.daniel.game.core;

import com.daniel.game.config.Settings;
import com.daniel.game.ui.*;

import java.util.HashMap;
import java.util.Map;

public class GameState {

    private double currency;
    private final Map<String, Building> buildings;

    public GameState(int currency) {
        this.currency = currency;
        this.buildings = new HashMap<>();
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
        return buildings.values()
                .stream()
                .mapToDouble(Building::getIncomePerTick)
                .sum();
    }

    public void buyBuilding(Building building) {
        double cost = building.getCost();

        if (currency >= cost) {
            currency -= cost;
            building.addBuilding();
        }
    }

    public Building instantiateBuilding(String id, int baseCost, int baseIncome, double costCoefficient) {
        Building newBuilding = new Building(id, baseCost, baseIncome, 0, costCoefficient);


        if (buildings.containsKey(newBuilding.getId())) {
            throw new IllegalArgumentException(
                    "Duplicate Building ID: " + newBuilding.getId()
            );
        }

        buildings.put(newBuilding.getId(), newBuilding);
        return newBuilding;
    }
}
