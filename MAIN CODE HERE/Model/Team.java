package com.ballardsoftware.idlebattle.Model;

import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

public class Team extends AbstractModel {

    private int bonus;

    public Team(String name, double basePrice, int level,
                   double upgradeCost, int bonus) {
        super(name, basePrice, level, upgradeCost);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public void upgrade(int i) {
        Double total = Stats.currentTotal.getValue();
        if(total >= Double.valueOf(getUpgradeCost())) {

            if(getLevel() < 10) {
                total-=(getUpgradeCost());
                Stats.currentTotal.setValue(total);
                setUpgradeCost(getUpgradeCost() * 5);
                setLevel(getLevel()+1);


                bonus+=10;
                IdleViewModel.weaponsArray[i].calculateIncrease();
            }
        }
    }
}
