package com.ballardsoftware.idlebattle.Model;

//import static com.ballardsoftware.idlebattle.ViewModel.IdleViewModel.total;

import android.arch.lifecycle.MutableLiveData;

import java.util.Timer;
import java.util.TimerTask;

public class Weapon extends AbstractModel {


    //todo: change multiplier for each weapon?
    //todo - different weapons are more efficient
    private final double MULTIPLIER = 1.12;
    private double rate = 4;
    //upgradeTime is milliseconds
    private long upgradeTime;

    public Weapon(String name, double basePrice, int level,
                  double upgradeCost, double income,
                  MutableLiveData<String> incomeNumber, long upgradeTime) {

        super(name, basePrice, level, upgradeCost, income, incomeNumber);
        this.upgradeTime = upgradeTime;
    }

    public double calculateMaxNumber() {

        synchronized (this) {
            //todo: getMultiplier
            return (Math.floor((Math.log((
                    Stats.getCurrentTotal() * (MULTIPLIER-1)) /
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
    public double addIncome() {

        synchronized (this) {
            Stats.setCurrentTotal(Stats.getCurrentTotal() + getIncome());
            return Stats.getCurrentTotal();
        }
    }

    //Todo: custom progress bar in View (xml)
    void weaponProgress() {
        //runs addIncome function after time

        final Timer progressTime = new Timer();
        progressTime.schedule(new TimerTask() {
            @Override
            public void run() {
                addIncome();
            }
        }, 2*60*upgradeTime);

    }

    private static MutableLiveData<String> incomeNumber;

    public static MutableLiveData<String> getIncomeNumber() {
        if(incomeNumber == null) {
            incomeNumber = new MutableLiveData<String>();
        }
        return incomeNumber;
    }

    public void setIncomeNumber(MutableLiveData<String> incomeNumber) {
        Weapon.incomeNumber = incomeNumber;
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

