package com.ballardsoftware.idlebattle.Model;

public class Stat {

    private static double currentTotal;
    private static double totalSinceReset;
    private static double totalLifetime;
    private static double prestigeXP;
    //number of days played
    //date started
    //total upgrades for each weapon?

    public static double getCurrentTotal() {
        return currentTotal;
    }

    public static void setCurrentTotal(double currentTotal) {
        Stat.currentTotal = currentTotal;
    }

    public static double getTotalSinceReset() {
        return totalSinceReset;
    }

    public static void setTotalSinceReset(double totalSinceReset) {
        Stat.totalSinceReset = totalSinceReset;
    }

    public static double getTotalLifetime() {
        return totalLifetime;
    }

    public static void setTotalLifetime(double totalLifetime) {
        Stat.totalLifetime = totalLifetime;
    }

    public static double getPrestigeXP() {
        return prestigeXP;
    }

    public static void setPrestigeXP(double prestigeXP) {
        Stat.prestigeXP = prestigeXP;
    }


}
