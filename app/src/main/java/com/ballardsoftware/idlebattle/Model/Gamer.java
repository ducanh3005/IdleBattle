package com.ballardsoftware.idlebattle.Model;

import com.ballardsoftware.idlebattle.Utilities.Stats;

public class Gamer extends AbstractModel {

    private double upgradeCost;
    private int level;
    private int time;

    //doesn't need name or income (same with team)
    //or income changes to rate - rate of increased time
    public Gamer(String name, double basePrice, int level,
                 double upgradeCost, int time) {
        super(name, basePrice, level, upgradeCost, time);
        this.upgradeCost = upgradeCost;
        this.level = level;
        this.time = time;
    }

    @Override
    public double abstractCalculateUpgradePrice(double numberToUpgrade) {
        return 0;
    }

    @Override
    public double abstractCalculateIncrease(double numberToUpgrade) {
        return 0;
    }

    public int getTime() {
        return time;
    }

    public int getLevel() {
        return level;
    }

    public double getUpgradeCost() {
        return upgradeCost;
    }

    //hook to listener
    public void gamerUpgrade() {
        Double total = Stats.currentTotal.getValue();
        //int level = getLevel();
        //double upgradeCost = getUpgradeCost();
        if(total >= Double.valueOf(upgradeCost)) {
            //Double d = new Double(upgradeCost);

            if(level < 10) {
                total-=(upgradeCost);
                Stats.currentTotal.setValue(total);
                upgradeCost *= 10;

                setLevel(level++);


                if(level > 1) {
                    time -= 1000;
                }
                //IdleViewModel.weaponsArray.level++;
            }
        }
    }
}
