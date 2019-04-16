package com.ballardsoftware.idlebattle.Model;

import android.arch.lifecycle.MutableLiveData;

public class Manager extends AbstractModel {
    
    public Manager(String name, double basePrice, int level,
                   double upgradeCost, double income, MutableLiveData<String> incomeNumber) {
        super(name, basePrice, level, upgradeCost, income, incomeNumber);
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
