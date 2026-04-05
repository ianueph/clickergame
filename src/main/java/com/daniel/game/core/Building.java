package com.daniel.game.core;

import com.daniel.game.config.Settings;

public class Building{

    private final String id;
    private final double baseCost;
    private final double baseIncome; // per second income
    private int count;
    private final double costCoefficient;
    private double mult;

    public Building(String id, double baseCost, double baseIncome, int count, double costCoefficient) {
        this.id = id;
        this.baseCost = baseCost;
        this.baseIncome = baseIncome;
        this.count = count;
        this.costCoefficient = costCoefficient;
        this.mult = 1;
    }

    public double getCost() {
        return baseCost * (Math.pow(1 + costCoefficient, count));
    }

    public void addBuilding() {
        count++;
    }

    public double getIncomePerTick() {
        return (baseIncome * count / Settings.FRAME_RATE) * mult;
    }

    public void setMult(double mult) {
        this.mult = mult;
    }

    public double getMult() {
        return mult;
    }

    public String getId() {
        return id;
    }
}
