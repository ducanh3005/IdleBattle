package com.ballardsoftware.idlebattle.Model;

public class Stats {

    private static double currentTotal = 0;
    private static double totalSinceReset;
    private static double totalLifetime;
    private static double prestigeXP;
    private static String test = "0";
    //number of days played
    //date started
    //total upgrades for each weapon?
    public static String getTest() {
        return test;
    }

    public static double getCurrentTotal() {
        return currentTotal;
    }

    public static void setCurrentTotal(double currentTotal) {
        Stats.currentTotal = currentTotal;
    }

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
