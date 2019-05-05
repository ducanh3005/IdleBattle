package com.ballardsoftware.idlebattle.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.ballardsoftware.idlebattle.Model.Gamer;
import com.ballardsoftware.idlebattle.Model.Team;
import com.ballardsoftware.idlebattle.Model.Weapon;
import com.ballardsoftware.idlebattle.Utilities.Stats;

public class IdleViewModel extends ViewModel {


    public static int newGame; //ng+ etc.
    public static int amount;
    public static Weapon[] weaponsArray;



    //private static MutableLiveData<Double> currentTotal;
/*
    public MutableLiveData<Double> getCurrentTotal() {
        if(currentTotal == null) {
            currentTotal = new MutableLiveData<>();
        }
        return currentTotal;
    }

    public void setCurrentTotal(MutableLiveData<Double> currentTotal) {
        IdleViewModel.currentTotal = currentTotal;
    }
*/

    /*private static MutableLiveData<List<Weapon>> weaponsList;
    private static List<MutableLiveData<Weapon>> w1;


    public MutableLiveData<List<Weapon>> getWeaponMutableLiveData() {
        if(weaponsList == null) {
            weaponsList = new MutableLiveData<List<Weapon>>();
        }
        return  weaponsList;
    }

    public void setWeaponMutableLiveData(
            MutableLiveData<List<Weapon>> weaponsList) {
        IdleViewModel.weaponsList = weaponsList;
    }
*/


    //todo: calculate progress on game closed (new function?)
    void closeGame() {
        //save weapons array
        //save values
        //save current time
    }

    private static MutableLiveData<Double> test;

    public static void startGame() {
        //load from save
        //load in weapons array
        if (weaponsArray == null) {
            weaponsArray = initializeWeapons();
            //test.setValue(0.0);
            //Stats.setCurrentTotal(test);
            Stats.getCurrentTotal().setValue(0.0);
        }

        //todo works on changing income - doesn't change incomeNumber
        //.setIncome() also changes incomeNumber
        //weaponsArray[0].setIncome(5);
        //get current time
        //calculate amounts earned from last time played for each weapon
    }

    //called in ProgressBarButton after the progress countdown is finished
    public static void progressFinished(int weaponNumber) {
        Double income = weaponsArray[weaponNumber].getIncome();
        if(Stats.getCurrentTotal().getValue() != null) {
            income += Stats.getCurrentTotal().getValue();
        }
        Stats.currentTotal.setValue(income);
        //currentTotal.setValue(String.format(Locale.getDefault(), "%.0f",
                //Stats.getCurrentTotal()));
        //currentTotal.setValue(Stats.getCurrentTotal());


    }


    //todo: upgrade
    int upgradeWeapon(Weapon weapon){
        //if total greater than cost
        if(Stats.getCurrentTotal().getValue() != null &&
                Stats.getCurrentTotal().getValue() > weapon.getUpgradeCost()) {

            //upgrade cost is subtracted from total
            Stats.currentTotal.setValue(Stats.getCurrentTotal().getValue() -
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
                        weaponsArray[i].calculateUpgradePrice(max));
                //needs to be displayed
                //listener on upgradeCost to display every time it changes?
                //listener attached to setters?
            }
        }

        else {
            for (int i = 0; i < 9; i++) {
                weaponsArray[i].setUpgradeCost(
                        weaponsArray[i].calculateUpgradePrice(amount));
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

        Weapon [] weaponsArray = new Weapon[10];
        //weaponsList1 = new Weapon[10];

        int initialLevel = 0;

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



        //gamers

        String gamerName1 = "XxX360Johnny";
        String gamerName2 = "I♥🖤URMom";
        String gamerName3 = "420Killz";
        String gamerName4 = "ImTheBest";
        String gamerName5 = "SonicSpeed";
        String gamerName6 = "Hannah1996";
        String gamerName7 = "TheRealSteve3";
        String gamerName8 = "Pro_Rachel";
        String gamerName9 = "Pro_James";
        String gamerName10 = "Pro_Joe";

        double baseGamerPrice1 = 200;
        double baseGamerPrice2 = 500;
        double baseGamerPrice3 = 2500;
        double baseGamerPrice4 = 5000;
        double baseGamerPrice5 = 10000;
        double baseGamerPrice6 = 20000;
        double baseGamerPrice7 = 37500;
        double baseGamerPrice8 = 50000;
        double baseGamerPrice9 = 125000;
        double baseGamerPrice10 = 500000;

        //levels decrease delay between clicks (see ProgressBarButton)


        //idk how what this will do
        //upgradeCost = baseGamerPrice

        int time = 10000; //10s


        Gamer gamer1 = new Gamer(gamerName1, baseGamerPrice1, initialLevel,
                baseGamerPrice1, time);
        Gamer gamer2 = new Gamer(gamerName2, baseGamerPrice2, initialLevel,
                baseGamerPrice2, time);
        Gamer gamer3 = new Gamer(gamerName3, baseGamerPrice3, initialLevel,
                baseGamerPrice3, time);
        Gamer gamer4 = new Gamer(gamerName4, baseGamerPrice4, initialLevel,
                baseGamerPrice4, time);
        Gamer gamer5 = new Gamer(gamerName5, baseGamerPrice5, initialLevel,
                baseGamerPrice5, time);
        Gamer gamer6 = new Gamer(gamerName6, baseGamerPrice6, initialLevel,
                baseGamerPrice6, time);
        Gamer gamer7 = new Gamer(gamerName7, baseGamerPrice7, initialLevel,
                baseGamerPrice7, time);
        Gamer gamer8 = new Gamer(gamerName8, baseGamerPrice8, initialLevel,
                baseGamerPrice8, time);
        Gamer gamer9 = new Gamer(gamerName9, baseGamerPrice9, initialLevel,
                baseGamerPrice9, time);
        Gamer gamer10 = new Gamer(gamerName10, baseGamerPrice10, initialLevel,
                baseGamerPrice10, time);



        //teams

        String teamName1 = "Noob Gaming";
        String teamName2 = "Rank 1";
        String teamName3 = "The Killerz";
        String teamName4 = "Team Best";
        String teamName5 = "Speedy Fast";
        String teamName6 = "GirlsOnly";
        String teamName7 = "Real Gamers";
        String teamName8 = "GO Team";
        String teamName9 = "Team Solid";
        String teamName10 = "Elite Gamers";

        double baseTeamPrice1 = 400;
        double baseTeamPrice2 = 1000;
        double baseTeamPrice3 = 5000;
        double baseTeamPrice4 = 10000;
        double baseTeamPrice5 = 20000;
        double baseTeamPrice6 = 40000;
        double baseTeamPrice7 = 75000;
        double baseTeamPrice8 = 100000;
        double baseTeamPrice9 = 250000;
        double baseTeamPrice10 = 1000000;

        //some kind of multiplier?
        double teamBonus1 = 100;
        double teamBonus2 = 100;
        double teamBonus3 = 100;
        double teamBonus4 = 100;
        double teamBonus5 = 100;
        double teamBonus6 = 100;
        double teamBonus7 = 100;
        double teamBonus8 = 100;
        double teamBonus9 = 100;
        double teamBonus10 = 100;

        int bonus = 1;

        Team team1 = new Team(teamName1, baseTeamPrice1, initialLevel,
                baseTeamPrice1, bonus);
        Team team2 = new Team(teamName2, baseTeamPrice1, initialLevel,
                baseTeamPrice2, bonus);
        Team team3 = new Team(teamName3, baseTeamPrice1, initialLevel,
                baseTeamPrice3, bonus);
        Team team4 = new Team(teamName4, baseTeamPrice1, initialLevel,
                baseTeamPrice4, bonus);
        Team team5 = new Team(teamName5, baseTeamPrice1, initialLevel,
                baseTeamPrice5, bonus);
        Team team6 = new Team(teamName6, baseTeamPrice1, initialLevel,
                baseTeamPrice6, bonus);
        Team team7 = new Team(teamName7, baseTeamPrice1, initialLevel,
                baseTeamPrice7, bonus);
        Team team8 = new Team(teamName8, baseTeamPrice1, initialLevel,
                baseTeamPrice8, bonus);
        Team team9 = new Team(teamName9, baseTeamPrice1, initialLevel,
                baseTeamPrice9, bonus);
        Team team10 = new Team(teamName10, baseTeamPrice1, initialLevel,
                baseTeamPrice10, bonus);




        //todo: is upgradeCost necessary?
        //String name, double basePrice, int level,
        // double upgradeCost, double income
        weaponsArray[0] = new Weapon(baseWeaponIncome_1, baseUpgradePrice_1,
                weaponTime_1,1, baseUpgradePrice_1, baseWeaponIncome_1,
                gamer1, team1);
        weaponsArray[1] = new Weapon(baseWeaponIncome_2,baseUpgradePrice_2, weaponTime_2,
                0, baseUpgradePrice_2, baseWeaponIncome_2,gamer2, team2);
        weaponsArray[2] = new Weapon(baseWeaponIncome_3,baseUpgradePrice_3, weaponTime_3,
                0, baseUpgradePrice_3, baseWeaponIncome_3,gamer3, team3);
        weaponsArray[3] = new Weapon(baseWeaponIncome_4,baseUpgradePrice_4, weaponTime_4,
                0, baseUpgradePrice_4, baseWeaponIncome_4,gamer4, team4);
        weaponsArray[4] = new Weapon(baseWeaponIncome_5,baseUpgradePrice_5, weaponTime_5,
                0, baseUpgradePrice_5, baseWeaponIncome_5,gamer5, team5);
        weaponsArray[5] = new Weapon(baseWeaponIncome_6,baseUpgradePrice_6, weaponTime_6,
                0, baseUpgradePrice_6, baseWeaponIncome_6,gamer6, team6);
        weaponsArray[6] = new Weapon(baseWeaponIncome_7,baseUpgradePrice_7, weaponTime_7,
                0, baseUpgradePrice_7, baseWeaponIncome_7,gamer7, team7);
        weaponsArray[7] = new Weapon(baseWeaponIncome_8,baseUpgradePrice_8, weaponTime_8,
                0, baseUpgradePrice_8, baseWeaponIncome_8,gamer8, team8);
        weaponsArray[8] = new Weapon(baseWeaponIncome_9,baseUpgradePrice_9, weaponTime_9,
                0, baseUpgradePrice_9, baseWeaponIncome_9,gamer9, team9);
        weaponsArray[9] = new Weapon(baseWeaponIncome_10,baseUpgradePrice_10, weaponTime_10,
                0, baseUpgradePrice_10, baseWeaponIncome_10,gamer10,
                team10);


        /*weaponsArray[9] = new Weapon(weaponName_10, baseUpgradePrice_10,
                0, baseUpgradePrice_10, baseWeaponIncome_10,
                weaponTime_10, gamer10, team10);
*/
        return  weaponsArray;
    }


}

