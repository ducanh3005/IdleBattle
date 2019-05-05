package com.ballardsoftware.idlebattle.Model;

import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

public class Team extends AbstractModel {
    //time was income

    int bonus;
    int level;
    double upgradeCost;

    public Team(String name, double basePrice, int level,
                   double upgradeCost, int bonus) {
        super(name, basePrice, level, upgradeCost, bonus);
        this.bonus = bonus;
        this.level = level;
        this.upgradeCost = upgradeCost;
    }

    @Override
    double abstractCalculateUpgradePrice(double numberToUpgrade) {
        return 0;
    }

    @Override
    double abstractCalculateIncrease(double numberToUpgrade) {
        return 0;
    }

    public int getBonus() {
        return bonus;
    }

    public int getLevel() {
        return level;
    }

    public double getUpgradeCost() {
        return upgradeCost;
    }

    public void teamUpgrade(int i) {
        Double total = Stats.currentTotal.getValue();
        //int level = getLevel();
        //double upgradeCost = getUpgradeCost();
        if(total >= Double.valueOf(upgradeCost)) {
            //Double d = new Double(upgradeCost);

            if(level < 10) {
                total-=(upgradeCost);
                Stats.currentTotal.setValue(total);
                upgradeCost *= 5;

                setLevel(level++);


                //if(level > 1) {
                bonus+=10;
                //IdleViewModel.weaponsArray[i].setIncome(
                  //      IdleViewModel.weaponsArray[i].getIncome() * bonus);
                IdleViewModel.weaponsArray[i].calculateIncrease(1);
                //setIncome(getIncome() * bonus);
                //}
                //IdleViewModel.weaponsArray.level++;
            }
        }
    }
}
