package com.ballardsoftware.idlebattle.Model;

//import static com.ballardsoftware.idlebattle.ViewModel.IdleViewModel.total;

public class Weapon extends AbstractModel {


    //todo: change multiplier for each weapon?
    //todo - different weapons are more efficient
    private final double MULTIPLIER = 1.12;
    private double rate = 4;
    private long upgradeTime;

    public Weapon(String name, double basePrice, int level, double upgradeCost,
                  double income, long upgradeTime) {
        super(name, basePrice, level, upgradeCost, income);
        this.upgradeTime = upgradeTime;
    }

    public double calculateMaxNumber() {

        synchronized (this) {
            //todo: getMultiplier
            return (Math.floor((Math.log((
                    Stat.getCurrentTotal() * (MULTIPLIER-1)) /
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
            income+= income / rate;
        }
        return income;
    }

    //when to progress (total += income) and when to use weaponTime
    public double weaponProgress(long time) {

        synchronized (this) {
            Stat.setCurrentTotal(Stat.getCurrentTotal() + getIncome());
            return Stat.getCurrentTotal();
        }
    }

    //ng+ = 3.5
    //ng+1 = 3
    //       2.5
    //       2
    //       1.75
    //       1.5
    //ng+6   1
    //       .75
    //       .5
    //       .25
    //ng+10  .1
    //todo: maybe about 100 ng? or infinate ng?
    //todo: ng+ based on total earned in lifetime or since reset
    //rate = rate/2   double
    //rate = rate/5   20% increase
    public void increaseRate() {
        rate = rate / 1.2;
    }
}

