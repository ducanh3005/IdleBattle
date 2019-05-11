package com.ballardsoftware.idlebattle.Model;

import com.ballardsoftware.idlebattle.Utilities.Stats;

public class Gamer extends AbstractModel {

    //private double gamerUpgradeCost;
    //private int gamerLevel;
    private int gamerTime;

    //doesn't need name or income (same with team)
    //or income changes to rate - rate of increased time
    public Gamer(String name, double basePrice, int level,
                 double upgradeCost, int time) {
        super(name, basePrice, level, upgradeCost);
        //this.gamerUpgradeCost = upgradeCost;
        //this.gamerLevel = level;
        this.gamerTime = time;
    }

    public int getTime() {
        return gamerTime;
    }
    public void setTime(int time) {
        this.gamerTime = time;
    }

    @Override
    public void upgrade(int i) {
        Double total = Stats.currentTotal.getValue();
        //int level = getLevel();
        //double upgradeCost = getUpgradeCost();
        if(total >= Double.valueOf(getUpgradeCost())) {
            //Double d = new Double(upgradeCost);

            if(getLevel() < 10) {
                total-=(getUpgradeCost());
                Stats.currentTotal.setValue(total);
                //gamerUpgradeCost *= 10;
                setUpgradeCost(getUpgradeCost() * 10);
                setLevel(getLevel()+1);


                if(getLevel() > 1) {
                    gamerTime -= 1000;
                }
                //IdleViewModel.weaponsArray.level++;
            }
        }
    }

/*
    public double getUpgradeCost() {
        return upgradeCost;
    }

    //hook to listener
    public void gamerUpgrade() {

    }*/
}
