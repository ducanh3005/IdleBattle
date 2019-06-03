package com.ballardsoftware.idlebattle.Model;

import com.ballardsoftware.idlebattle.Utilities.Stats;

public class Weapon {

    private final int weaponNumber;
    private final String name;
    private final double baseIncome;
    private double currentIncome;
    private final double baseUpgradeCost;
    private double currentUpgradeCost;
    private int baseTime;
    private int currentTime;
    private int level;
    
    
    private Gamer gamer;
    private Team team;


    public Weapon(int weaponNumber, String name, double baseIncome,
                  double currentIncome, double baseUpgradeCost,
                  double currentUpgradeCost, int baseTime, int currentTime,
                  int level, Gamer gamer, Team team) {

        this.weaponNumber = weaponNumber;
        this.name = name;
        this.baseIncome = baseIncome;
        this.currentIncome = currentIncome;
        this.baseUpgradeCost = baseUpgradeCost;
        this.currentUpgradeCost = currentUpgradeCost;
        this.baseTime = baseTime;
        this.currentTime = currentTime;
        this.level = level;
        
        
        this.gamer = gamer;
        this.team = team;

    }
    public int getWeaponNumber() {
        return weaponNumber;
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
    public double getBaseUpgradeCost() {
        return baseUpgradeCost;
    }
    public double getCurrentUpgradeCost() {
        return currentUpgradeCost;
    }

    public void setCurrentUpgradeCost(double cost) {
        currentUpgradeCost = cost;
    }
    public int getCurrentTime() {
        return currentTime;
    }
    public int getBaseTime() {
        return baseTime;
    }
    public void setCurrentTime(int time) {
        currentTime = time;
    }
    public int getLevel() {
        return level;
    }
    public Gamer getGamer() {
        return gamer;
    }
    public Team getTeam() {
        return team;
    }




    public double calculateMaxNumber() {

        synchronized (this) {
            return (Math.floor((Math.log((
                    Stats.getCurrentTotal().getValue() * (Stats.multiplier-1))
                    /(baseUpgradeCost * Math.pow(Stats.multiplier,
                    level)) + 1)) / Math.log(Stats.multiplier)));
        }
    }

    public double calculateUpgradePrice(double numberToUpgrade) {

        return (baseUpgradeCost * (((Math.pow(Stats.multiplier, level))
                *((Math.pow(Stats.multiplier, numberToUpgrade)) - 1)) /
                (Stats.multiplier - 1)));
    }

    double calculateIncrease() {
        currentIncome=level*3 + baseIncome;
        currentIncome *= team.getBonus();
        currentIncome *= Stats.prestigeXP;
        return currentIncome;
    }

    double addcurrentIncome() {

        synchronized (this) {
            Stats.currentTotal.setValue(Stats.getCurrentTotal().getValue() +
                    getCurrentIncome());
            return Stats.getCurrentTotal().getValue();
        }
    }



    //function to call when the upgrade button is clicked
    public void upgrade(int numberToUpgrade) {

        //max level is about 3000 -> 3138
        synchronized (this) {
            if(Stats.getCurrentTotal().getValue() >= currentUpgradeCost) {
                //subtract cost from total
                Stats.currentTotal.setValue(Stats.getCurrentTotal().getValue()
                        - currentUpgradeCost);

                //increase level
                level+= numberToUpgrade;

                currentUpgradeCost = calculateUpgradePrice(numberToUpgrade);

                //increase currentIncome
                currentIncome = calculateIncrease();

            }

        }

    }


}

