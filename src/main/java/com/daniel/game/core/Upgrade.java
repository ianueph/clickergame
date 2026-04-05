package com.daniel.game.core;

public class Upgrade {

    private final String id;
    private final String targetBuildingID;
    private int count;
    private final double baseCost;
    private final double baseModifier;
    private final double costCoefficient;

    public Upgrade(String id, String targetBuildingID, int count, double baseCost, double baseModifier, double costCoefficient) {
        this.id = id;
        this.targetBuildingID = targetBuildingID;
        this.count = count;
        this.baseCost = baseCost;
        this.baseModifier = baseModifier;
        this.costCoefficient = costCoefficient;
    }

    public void applyUpgrade(Building building) {
        building.setMult(building.getMult() + getModifier());
    }

    public double getModifier() {
        return 1 + (count * baseModifier);
    }

    public void addUpgrade() {
        count++;
    }

    public double getCost() {
        return baseCost * (Math.pow(1 + costCoefficient, count));
    }

    public String getTargetBuildingID() {
        return targetBuildingID;
    }

    public String getId() {
        return id;
    }
}
