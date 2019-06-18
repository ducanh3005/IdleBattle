package com.ballardsoftware.idlebattle.Model;

public abstract class AbstractModel {


    private final String name;
    private double basePrice;
    private int level;
    private double upgradeCost;

    AbstractModel(String name, double basePrice, int level,
                  double upgradeCost) {
        this.name = name;
        this.basePrice = basePrice;
        this.level = level;
        this.upgradeCost = upgradeCost;
    }

    public double getUpgradeCost() {
        return upgradeCost;
    }

    void setUpgradeCost(double upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getLevel() {
        return level;
    }

    void setLevel(int level) {
        this.level = level;
    }

    abstract void upgrade(int i);

}
