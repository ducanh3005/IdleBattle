package com.ballardsoftware.idlebattle.Model;

import static com.ballardsoftware.idlebattle.ViewModel.IdleViewModel.total;

public class Weapon extends AbstractModel {


    //todo: change multiplier for each weapon?
    //todo - different weapons are more efficient
    private final double MULTIPLIER = 1.12;

    public Weapon(String name, double basePrice, int level, double upgradeCost,
                  double income) {
        super(name, basePrice, level, upgradeCost, income);
    }

    @Override
    double calculateMaxNumber() {

        synchronized (this) {
            return (Math.floor((Math.log((total*(MULTIPLIER-1)) /
                    (getBasePrice() * Math.pow(MULTIPLIER, getLevel())) + 1)) /
                    Math.log(MULTIPLIER)));
        }
    }

    @Override
    public double abstractCalculateUpgradePrice(double numberToUpgrade) {

        return (getBasePrice() * (((Math.pow(MULTIPLIER, getLevel())) *
                ((Math.pow(MULTIPLIER, numberToUpgrade)) - 1)) /
                (MULTIPLIER - 1)));
    }

    //Todo: increase income rate with ng+
    @Override
    public double abstractCalculateIncrease(double numberToUpgrade) {
        double income = getIncome();

        //Multiplier from manager
        //income = (baseIncome * level) * Multiplier
        for (int i = 0; i < numberToUpgrade; i++) {
            income+= income / 4;
        }
        return income;
    }

    //when to progress (total += income) and when to use weaponTime
    public double weaponProgress(long time) {

        return 0;
    }
}
