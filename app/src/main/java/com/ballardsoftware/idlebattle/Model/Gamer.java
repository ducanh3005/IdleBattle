package com.ballardsoftware.idlebattle.Model;

public class Gamer extends AbstractModel {
    
    public Gamer(String name, double basePrice, int level,
                 double upgradeCost, double income) {
        super(name, basePrice, level, upgradeCost, income);
    }

    @Override
    public double abstractCalculateUpgradePrice(double numberToUpgrade) {
        return 0;
    }

    @Override
    public double abstractCalculateIncrease(double numberToUpgrade) {
        return 0;
    }
}
