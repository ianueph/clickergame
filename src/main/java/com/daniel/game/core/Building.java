package com.daniel.game.core;

import com.daniel.game.config.Settings;

public class Building{

    private final double baseCost;
    private final double baseIncome; // per second income
    private int count;

    public Building(double baseCost, double baseIncome, int count) {
        this.baseCost = baseCost;
        this.baseIncome = baseIncome;
        this.count = count;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public double getBaseIncome() {
        return baseIncome;
    }

    public int getCount() {
        return count;
    }

    public void addBuilding() {
        count++;
    }

    public double getIncomePerTick() {
        return baseIncome * count / Settings.FRAME_RATE;
    }
}
