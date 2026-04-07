package com.daniel.game.core;

import com.daniel.game.config.Settings;
import com.daniel.game.data.BuildingLoader;
import com.daniel.game.data.UpgradeLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameState {

    private double currency;
    private final Map<String, Building> buildings;
    private final Map<String, Upgrade> upgrades;

    public GameState(int currency) throws IOException {
        BuildingLoader buildingLoader = new BuildingLoader();
        UpgradeLoader upgradeLoader = new UpgradeLoader();

        this.currency = currency;
        this.buildings = buildingLoader.load();
        this.upgrades = upgradeLoader.load();
    }

    public void increment() {
        this.currency += 1;
    }

    public void tick() {
        currency += getTotalIncomePerTick();
    }

    public double getCurrency() {
        return this.currency;
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

    public Map<String, Upgrade> getUpgrades() {
        return upgrades;
    }
}
