package com.ballardsoftware.idlebattle.Model;

//import static com.ballardsoftware.idlebattle.ViewModel.IdleViewModel.total;

import android.arch.lifecycle.MutableLiveData;

import com.ballardsoftware.idlebattle.Utilities.Stats;

import java.util.Timer;
import java.util.TimerTask;

public class Weapon {


    //todo: change multiplier for each weapon?
    //todo - different weapons are more efficient
    private final double MULTIPLIER = 1.12;
    private double rate = 4;

    private double baseIncome;
    private double basePrice;
    private long upgradeTime;
    private int level;
    private double upgradeCost;
    private double income;
    private Gamer gamer;
    private Team team;


    public Weapon(double baseIncome, double basePrice, long upgradeTime,
                  int level, double upgradeCost, double income, Gamer gamer,
                  Team team) {

        //super(name, basePrice, level, upgradeCost, income);
        //this.upgradeTime = upgradeTime;
        this.baseIncome = baseIncome;
        this.basePrice = basePrice;
        this.upgradeTime = upgradeTime;
        this.level = level;
        this.upgradeCost = upgradeCost;
        this.income = income;
        this.gamer = gamer;
        this.team = team;

    }

    public int getLevel() {
        return level;
    }
    public double getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(double cost) {
        upgradeCost = cost;
    }
    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double num) {
        income = num;
    }

    public void incomeMultiplier() {

    }

    public double calculateMaxNumber() {

        synchronized (this) {
            //todo: getMultiplier
            return (Math.floor((Math.log((
                    Stats.getCurrentTotal().getValue() * (MULTIPLIER-1)) /
                    (basePrice * Math.pow(MULTIPLIER, level)) + 1)) /
                    Math.log(MULTIPLIER)));
        }
    }

    //@Override
    //public double abstractCalculateUpgradePrice(double numberToUpgrade) {
    public double calculateUpgradePrice(double numberToUpgrade) {

        return (basePrice * (((Math.pow(MULTIPLIER, level)) *
                ((Math.pow(MULTIPLIER, numberToUpgrade)) - 1)) /
                (MULTIPLIER - 1)));
    }

    //Todo: increase income rate with ng+
    //@Override
    //public double abstractCalculateIncrease(double numberToUpgrade) {
    public double calculateIncrease(double numberToUpgrade) {
        //double income = getIncome();

        //Multiplier from manager
        //income = (baseIncome * level) * Multiplier
        //for (int i = 0; i < numberToUpgrade; i++) {
           // income+= income / rate;
        //}
        //level+=numberToUpgrade;
        //level*=team.getBonus();
        income=level*3 + baseIncome;
        income *= team.getBonus();
        return income;
    }

    //when to progress (total += income) and when to use weaponTime
    public double addIncome() {

        synchronized (this) {
            Stats.currentTotal.setValue(Stats.getCurrentTotal().getValue() + getIncome());
            return Stats.getCurrentTotal().getValue();
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

    //function to call when the upgrade button is clicked
    public void upgrade(int numberToUpgrade) { //parameter for numberToUpgrade

        //don't use amount -> just call this function x number of times
        //check if total > cost
        //todo: synchronization for total //max level is about 3000 -> 3138
        synchronized (this) {
            if(Stats.getCurrentTotal().getValue() >= upgradeCost) {
                //subtract cost from total
                Stats.currentTotal.setValue(Stats.getCurrentTotal().getValue()
                        - upgradeCost);

                //increase level
                level+= numberToUpgrade;

                //increase upgrade cost
                //abstractCalculateUpgradePrice(level, basePrice, 100);
                upgradeCost = calculateUpgradePrice(numberToUpgrade);

                //increase income
                income = calculateIncrease(numberToUpgrade);

            }

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

