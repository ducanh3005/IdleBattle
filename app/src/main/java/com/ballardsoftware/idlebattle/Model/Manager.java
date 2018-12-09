package com.ballardsoftware.idlebattle.Model;

public class Manager extends AbstractModel {
    
    public Manager(String name, long basePrice, long level,
                   long upgradeCost, long income) {
        super(name, basePrice, level, upgradeCost, income);
    }

    @Override
    public long abstractCalculateUpgradePrice() {
        return 0;
    }

    @Override
    public long abstractCalculateIncrease() {
        return 0;
    }
}
