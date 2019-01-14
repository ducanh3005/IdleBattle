package com.ballardsoftware.idlebattle.Model;

public class Manager extends AbstractModel {
    
    public Manager(String name, double basePrice, int level,
                   double upgradeCost, double income) {
        super(name, basePrice, level, upgradeCost, income);
    }

    @Override
    double abstractCalculateUpgradePrice(double numberToUpgrade) {
        return 0;
    }

    @Override
    double abstractCalculateIncrease(double numberToUpgrade) {
        return 0;
    }
}
