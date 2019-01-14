package com.ballardsoftware.idlebattle.Model;

//import static com.ballardsoftware.idlebattle.ViewModel.IdleViewModel.total;

public abstract class AbstractModel {


    private String name;
    private double basePrice;
    private int level;
    private double upgradeCost;
    //private int amount;
    private double income;
    //private final double MULTIPLIER = 1.12;

    AbstractModel(String name, double basePrice, int level,
                  double upgradeCost, double income) {
        this.name = name;
        this.basePrice = basePrice;
        this.level = level;
        this.upgradeCost = upgradeCost;
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(double upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }




    //function to call when the upgrade button is clicked
    public void upgrade() {

        //don't use amount -> just call this function x number of times
        //check if total > cost
        //todo: synchronization for total //max level is about 3000 -> 3138
        synchronized (this) {
            if(Stat.getCurrentTotal() > upgradeCost) {
                //subtract cost from total
                Stat.setCurrentTotal(Stat.getCurrentTotal() - upgradeCost);
                //increase level
                level++;
                //increase upgrade cost
                //abstractCalculateUpgradePrice(level, basePrice, 100);

            }

        }

        //don't display anything just calculate data. this is a model
    }

    //function to call when the amount button is clicked
    //public int getAmount() {
    //    return amount;
    //}

    //public void setAmount(int amount) {
     //   this.amount = amount;
    //}

    //max number that can be upgraded
    //todo: amounts are only used for weapons
    //abstract double calculateMaxNumber();

    //numberToUpgrade was maxNumber, but this can be used for
    // 1, 10, 100, or max (calculateMaxNumber()) instead
   // public double calculatePriceOfNumber(double numberToUpgrade) {
    //    return (basePrice * (((Math.pow(MULTIPLIER, level)) *
    // ((Math.pow(MULTIPLIER, numberToUpgrade)) - 1)) /
    // (MULTIPLIER - 1)));
   // }


    //calculate upgradePrices for weapons, gamers, and managers
    abstract double abstractCalculateUpgradePrice(
            double numberToUpgrade);
    
    //calculate income for weapons, time for gamers,
    // and multiplier for managers
    abstract double abstractCalculateIncrease(double numberToUpgrade);

}
