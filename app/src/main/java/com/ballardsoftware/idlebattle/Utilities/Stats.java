package com.ballardsoftware.idlebattle.Utilities;

import android.arch.lifecycle.MutableLiveData;

//utility class
final public class Stats {

    //each should be livedata
    public static MutableLiveData<Double> currentTotal;
    private static double totalSinceReset;
    private static double totalLifetime;
    private static double prestigeXP;
    private static String test = "0";
    //number of days played
    //date started
    //total upgrades for each weapon?

    private Stats() {
        throw new AssertionError();
    }

    public static String getTest() {
        return test;
    }


    public static MutableLiveData<Double> getCurrentTotal() {
        if(currentTotal == null) {
            currentTotal = new MutableLiveData<>();
        }
        return currentTotal;
    }

    public static void setCurrentTotal(MutableLiveData<Double> currentTotal) {
        //if(currentTotal == null) {
        //    currentTotal = new MutableLiveData<>();
        //}
        Stats.currentTotal = currentTotal;
        //Stats.currentTotal.setValue(newValue);
    }

  /*
    public static double getCurrentTotal() {
        return currentTotal;
    }

    public static void setCurrentTotal(double currentTotal) {
        Stats.currentTotal = currentTotal;
    }
*/
    public static double getTotalSinceReset() {
        return totalSinceReset;
    }

    public static void setTotalSinceReset(double totalSinceReset) {
        Stats.totalSinceReset = totalSinceReset;
    }

    public static double getTotalLifetime() {
        return totalLifetime;
    }

    public static void setTotalLifetime(double totalLifetime) {
        Stats.totalLifetime = totalLifetime;
    }

    public static double getPrestigeXP() {
        return prestigeXP;
    }

    public static void setPrestigeXP(double prestigeXP) {
        Stats.prestigeXP = prestigeXP;
    }


}
