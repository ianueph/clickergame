package com.daniel.game.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Upgrade {

    private final String id;
    private final String targetBuildingID;
    private int count;
    private final double baseCost;
    private final double baseModifier;
    private final double costCoefficient;

    @JsonCreator
    public Upgrade(
        @JsonProperty("id") String id,
        @JsonProperty("targetBuildingID") String targetBuildingID,
        @JsonProperty("count") int count,
        @JsonProperty("baseCost") double baseCost,
        @JsonProperty("baseModifier") double baseModifier,
        @JsonProperty("costCoefficient") double costCoefficient
    ) {
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

    public double getBaseModifier() {
        return baseModifier;
    }
}
