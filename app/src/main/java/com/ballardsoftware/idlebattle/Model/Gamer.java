package com.ballardsoftware.idlebattle.Model;

import android.arch.lifecycle.MutableLiveData;

public class Gamer extends AbstractModel {
    
    public Gamer(String name, double basePrice, int level,
                 double upgradeCost, double income, MutableLiveData<String> incomeNumber) {
        super(name, basePrice, level, upgradeCost, income, incomeNumber);
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
