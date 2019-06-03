package com.ballardsoftware.idlebattle.Model;

import com.ballardsoftware.idlebattle.Utilities.Stats;

public class Gamer extends AbstractModel {

    private int gamerTime;

    public Gamer(String name, double basePrice, int level,
                 double upgradeCost, int time) {
        super(name, basePrice, level, upgradeCost);
        this.gamerTime = time;
    }

    public int getTime() {
        return gamerTime;
    }

    @Override
    public void upgrade(int i) {
        Double total = Stats.currentTotal.getValue();
        if(total >= Double.valueOf(getUpgradeCost())) {

            if(getLevel() < 10) {
                total-=(getUpgradeCost());
                Stats.currentTotal.setValue(total);
                setUpgradeCost(getUpgradeCost() * 10);
                setLevel(getLevel()+1);


                if(getLevel() > 1) {
                    gamerTime -= 1000;
                }
            }
        }
    }
}
