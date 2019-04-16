package com.ballardsoftware.idlebattle.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.ballardsoftware.idlebattle.Model.Stats;
import com.ballardsoftware.idlebattle.Model.Weapon;

import java.util.Locale;

public class IdleViewModel extends ViewModel {


    public static int newGame;
    public static int amount;
    private static Weapon[] weaponsArray;



    private static MutableLiveData<String> currentTotal;

    public MutableLiveData<String> getCurrentTotal() {
        if(currentTotal == null) {
            currentTotal = new MutableLiveData<String>();
        }
        return currentTotal;
    }

    public void setCurrentTotal(MutableLiveData<String> currentTotal) {
        IdleViewModel.currentTotal = currentTotal;
    }








    //todo: calculate progress on game closed (new function?)
    void closeGame() {
        //save weapons array
        //save values
        //save current time
    }

    public static void startGame() {
        //load from save
        //load in weapons array
        if (weaponsArray == null) {
            initializeWeapons();
        }

        //todo works on changing income - doesn't change incomeNumber
        //.setIncome() also changes incomeNumber
        //weaponsArray[0].setIncome(5);
        //get current time
        //calculate amounts earned from last time played for each weapon
    }

    //called in ProgressBarButton after the progress countdown is finished
    public static void progressFinished(int weaponNumber) {
        double income = weaponsArray[weaponNumber].getIncome();
        Stats.setCurrentTotal(Stats.getCurrentTotal() + income);
        currentTotal.setValue(String.format(Locale.getDefault(), "%.0f",
                Stats.getCurrentTotal()));
    }


    //todo: upgrade
    int upgradeWeapon(Weapon weapon){
        //if total greater than cost
        if(Stats.getCurrentTotal() > weapon.getUpgradeCost()) {

            //upgrade cost is subtracted from total
            Stats.setCurrentTotal(Stats.getCurrentTotal() -
                    weapon.getUpgradeCost());

            //calculate new income

            //set new income
            //display new income

            //calculate new price
            //set new price
            //display new price

            //set new max amount and price to purchase

            //successful
            return 1;
        }

        else {
            //failure - toast (not enough money)
            return 0;
        }

    }

    //these two don't
    int upgradeGamer() {
        return 0;
    }
    int upgradeManagager(){
        return 0;
    }


    //initializeWeapons();

    //todo: select amount (weapons only)
    void upgradeCost(int amount) {
        Weapon[] weaponsArray = initializeWeapons();
        //calculate max for each weapon
        if (amount == 0) {
            for (int i = 0; i < 9; i++) {
                double max = weaponsArray[i].calculateMaxNumber();
                weaponsArray[i].setUpgradeCost(
                        weaponsArray[i].abstractCalculateUpgradePrice(max));
                //needs to be displayed
                //listener on upgradeCost to display every time it changes?
                //listener attached to setters?
            }
        }

        else {
            for (int i = 0; i < 9; i++) {
                weaponsArray[i].setUpgradeCost(
                        weaponsArray[i].abstractCalculateUpgradePrice(amount));
            }
        }

        //calculate new upgrade cost


        //set new upgrade cost
        //display new upgrade cost
    }



    //todo: new game (prestige)
    void prestige() {

    }

    //reset total and levels to 0
    //increase multiplier

    private static Weapon[] initializeWeapons() {

        /*
        *  basePrice is the base upgrade price
        *       -used to calculate upgrades
        *  upgradeCost is the current cost to upgrade the selected amount
        *       -used to display upgrade coast and buy upgrades
        *
        */

        //Weapon [] weaponsArray = new Weapon[10];
        weaponsArray = new Weapon[10];

        //for use with weapon constructors
        String weaponName_1 = "Fist";
        String weaponName_2 = "Boxing Gloves";
        String weaponName_3 = "Knife";
        String weaponName_4 = "Pistol";
        String weaponName_5 = "Shotgun";
        String weaponName_6 = "Machine Gun";
        String weaponName_7 = "Sniper Rifle";
        String weaponName_8 = "Grenade Launcher";
        String weaponName_9 = "Rocket Launcher";
        String weaponName_10 = "Laser Gun";

        double baseWeaponIncome_1 = 4;
        double baseWeaponIncome_2 = 10;
        double baseWeaponIncome_3 = 50;
        double baseWeaponIncome_4 = 100;
        double baseWeaponIncome_5 = 200;
        double baseWeaponIncome_6 = 400;
        double baseWeaponIncome_7 = 750;
        double baseWeaponIncome_8 = 1000;
        double baseWeaponIncome_9 = 2500;
        double baseWeaponIncome_10 = 10000;

        double baseUpgradePrice_1 = 30;
        double baseUpgradePrice_2 = 50;
        double baseUpgradePrice_3 = 250;
        double baseUpgradePrice_4 = 500;
        double baseUpgradePrice_5 = 1000;
        double baseUpgradePrice_6 = 2000;
        double baseUpgradePrice_7 = 3750;
        double baseUpgradePrice_8 = 5000;
        double baseUpgradePrice_9 = 12500;
        double baseUpgradePrice_10 = 50000;

        long weaponTime_1 = 2000;     // 2 s
        long weaponTime_2 = 4000;     // 4 s
        long weaponTime_3 = 10000;    // 10 s
        long weaponTime_4 = 20000;    // 20 s
        long weaponTime_5 = 50000;    // 50 s
        long weaponTime_6 = 120000;   // 2 m
        long weaponTime_7 = 240000;   // 4 m
        long weaponTime_8 = 480000;   // 8 m
        long weaponTime_9 = 780000;   // 13 m
        long weaponTime_10 = 1200000; // 20 m

        MutableLiveData<String> incomeNumber_1 = new MutableLiveData<>();
        incomeNumber_1.setValue(String.format(Locale.getDefault(),
                "%.0f", baseWeaponIncome_1));



        //todo: is upgradeCost necessary?
        //String name, double basePrice, int level,
        // double upgradeCost, double income
        weaponsArray[0] = new Weapon(weaponName_1, baseUpgradePrice_1,
                0, baseUpgradePrice_1, baseWeaponIncome_1, incomeNumber_1,
                weaponTime_1);

        weaponsArray[1] = new Weapon(weaponName_2, baseUpgradePrice_2,
                0, baseUpgradePrice_2, baseWeaponIncome_2, incomeNumber_1,weaponTime_2);

        weaponsArray[2] = new Weapon(weaponName_3, baseUpgradePrice_3,
                0, baseUpgradePrice_3, baseWeaponIncome_3, incomeNumber_1,weaponTime_3);

        weaponsArray[3] = new Weapon(weaponName_4, baseUpgradePrice_4,
                0, baseUpgradePrice_4, baseWeaponIncome_4, incomeNumber_1,weaponTime_4);

        weaponsArray[4] = new Weapon(weaponName_5, baseUpgradePrice_5,
                0, baseUpgradePrice_5, baseWeaponIncome_5, incomeNumber_1,weaponTime_5);

        weaponsArray[5] = new Weapon(weaponName_6, baseUpgradePrice_6,
                0, baseUpgradePrice_6, baseWeaponIncome_6, incomeNumber_1,weaponTime_6);

        weaponsArray[6] = new Weapon(weaponName_7, baseUpgradePrice_7,
                0, baseUpgradePrice_7, baseWeaponIncome_7, incomeNumber_1,weaponTime_7);

        weaponsArray[7] = new Weapon(weaponName_8, baseUpgradePrice_8,
                0, baseUpgradePrice_8, baseWeaponIncome_8, incomeNumber_1,weaponTime_8);

        weaponsArray[8] = new Weapon(weaponName_9, baseUpgradePrice_9,
                0, baseUpgradePrice_9, baseWeaponIncome_9, incomeNumber_1,weaponTime_9);

        weaponsArray[9] = new Weapon(weaponName_10, baseUpgradePrice_10,
                0, baseUpgradePrice_10, baseWeaponIncome_10, incomeNumber_1,weaponTime_10);

        return  weaponsArray;
    }


}

