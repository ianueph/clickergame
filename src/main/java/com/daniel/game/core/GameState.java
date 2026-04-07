package com.daniel.game.core;

import com.daniel.game.config.Settings;
import com.daniel.game.ui.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameState {

    private double currency;
    private final Map<String, Building> buildings;
    private final Map<String, Upgrade> upgrades;

    public GameState(int currency) throws IOException {
        this.currency = currency;
        BuildingLoader buildingLoader = new BuildingLoader();
        this.buildings = buildingLoader.load();
        this.upgrades = new HashMap<>();
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

    public Map<String, Building> getBuildings() {
        return buildings;
    }

    public void buyUpgrade(Upgrade upgrade) {
        double cost = upgrade.getCost();

        if (currency >= cost) {
            currency -= cost;
            upgrade.addUpgrade();
            upgrade.applyUpgrade(buildings.get(upgrade.getTargetBuildingID()));
        }
    }

    public Upgrade instantiateUpgrade(String id, String targetBuildingID, double baseCost, double baseModifier, double costCoefficient) {
        Upgrade newUpgrade = new Upgrade(id, targetBuildingID, 0, baseCost, baseModifier, costCoefficient);

        enforceUpgradeIDUniqueness(newUpgrade);

        upgrades.put(newUpgrade.getId(), newUpgrade);
        return newUpgrade;
    }

    private void enforceUpgradeIDUniqueness(Upgrade upgrade) {
        if (upgrades.containsKey(upgrade.getId())) {
            throw new IllegalArgumentException(
                    "Duplicate Upgrade ID: " + upgrade.getId()
            );
        }
    }
}
