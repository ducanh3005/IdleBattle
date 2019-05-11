package com.ballardsoftware.idlebattle.Model;

//import static com.ballardsoftware.idlebattle.ViewModel.IdleViewModel.total;

import android.arch.lifecycle.MutableLiveData;

import com.ballardsoftware.idlebattle.Utilities.Stats;

import java.util.Timer;
import java.util.TimerTask;

public class Weapon {


    //todo: change multiplier for each weapon?
    //todo - different weapons are more efficient
    //private transient final double MULTIPLIER = 1.12;
    //private transient double rate = 4;

    private final String name;
    private final double baseIncome;
    private double currentIncome;
    private final double baseUpgradeCost;
    private double currentUpgradeCost;
    private long time;
    private int level;
    
    
    private Gamer gamer;
    private Team team;


    public Weapon(String name, double baseIncome, double currentIncome,
                  double baseUpgradeCost, double currentUpgradeCost, 
                  long time, int level, Gamer gamer, Team team) {

        //super(name, basecurrentUpgradeCost, level, currentUpgradeCost, currentIncome);
        //this.time = time;
        this.name = name;
        this.baseIncome = baseIncome;
        this.currentIncome = currentIncome;
        this.baseUpgradeCost = baseUpgradeCost;
        this.currentUpgradeCost = currentUpgradeCost;
        this.time = time;
        this.level = level;
        
        
        this.gamer = gamer;
        this.team = team;

    }
    public String getName() {
        return name;
    }
    public double getBaseIncome() {
        return baseIncome;
    }
    public double getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(double num) {
        currentIncome = num;
    }
    public double getBaseUpgradeCost() {
        return baseUpgradeCost;
    }
    public double getCurrentUpgradeCost() {
        return currentUpgradeCost;
    }

    public void setCurrentUpgradeCost(double cost) {
        currentUpgradeCost = cost;
    }
    public long getTime() {
        return time;
    }
    public int getLevel() {
        return level;
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




    public double calculateMaxNumber() {

        synchronized (this) {
            //todo: getMultiplier
            return (Math.floor((Math.log((
                    Stats.getCurrentTotal().getValue() * (Stats.multiplier-1))
                    /(baseUpgradeCost * Math.pow(Stats.multiplier,
                    level)) + 1)) / Math.log(Stats.multiplier)));
        }
    }

    //@Override
    //public double abstractCalculateUpgradePrice(double numberToUpgrade) {
    public double calculateUpgradePrice(double numberToUpgrade) {

        return (baseUpgradeCost * (((Math.pow(Stats.multiplier, level))
                *((Math.pow(Stats.multiplier, numberToUpgrade)) - 1)) /
                (Stats.multiplier - 1)));
    }

    //Todo: increase currentIncome rate with ng+
    //@Override
    //public double abstractCalculateIncrease(double numberToUpgrade) {
    public double calculateIncrease(double numberToUpgrade) {
        //double currentIncome = getcurrentIncome();

        //Multiplier from manager
        //currentIncome = (basecurrentIncome * level) * Multiplier
        //for (int i = 0; i < numberToUpgrade; i++) {
           // currentIncome+= currentIncome / rate;
        //}
        //level+=numberToUpgrade;
        //level*=team.getBonus();
        currentIncome=level*3 + baseIncome;
        currentIncome *= team.getBonus();
        currentIncome *= Stats.prestigeXP;
        return currentIncome;
    }

    //when to progress (total += currentIncome) and when to use time
    public double addcurrentIncome() {

        synchronized (this) {
            Stats.currentTotal.setValue(Stats.getCurrentTotal().getValue() +
                    getCurrentIncome());
            return Stats.getCurrentTotal().getValue();
        }
    }

    //Todo: custom progress bar in View (xml)
    void weaponProgress() {
        //runs addcurrentIncome function after time

        final Timer progressTime = new Timer();
        progressTime.schedule(new TimerTask() {
            @Override
            public void run() {
                addcurrentIncome();
            }
        }, 2*60*time);

    }

    private static MutableLiveData<String> currentIncomeNumber;

    public static MutableLiveData<String> getcurrentIncomeNumber() {
        if(currentIncomeNumber == null) {
            currentIncomeNumber = new MutableLiveData<String>();
        }
        return currentIncomeNumber;
    }

    public void setcurrentIncomeNumber(MutableLiveData<String>
                                               currentIncomeNumber) {
        Weapon.currentIncomeNumber = currentIncomeNumber;
    }

    //function to call when the upgrade button is clicked
    public void upgrade(int numberToUpgrade) { //parameter for numberToUpgrade

        //don't use amount -> just call this function x number of times
        //check if total > cost
        //todo: synchronization for total //max level is about 3000 -> 3138
        synchronized (this) {
            if(Stats.getCurrentTotal().getValue() >= currentUpgradeCost) {
                //subtract cost from total
                Stats.currentTotal.setValue(Stats.getCurrentTotal().getValue()
                        - currentUpgradeCost);

                //increase level
                level+= numberToUpgrade;

                //increase upgrade cost
                //abstractCalculateUpgradePrice(level, basecurrentUpgradeCost, 100);
                currentUpgradeCost = calculateUpgradePrice(numberToUpgrade);

                //increase currentIncome
                currentIncome = calculateIncrease(numberToUpgrade);

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
        //rate = rate / 1.2;
    }

}

