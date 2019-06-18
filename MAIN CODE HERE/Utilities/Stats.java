package com.ballardsoftware.idlebattle.Utilities;

import android.arch.lifecycle.MutableLiveData;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Locale;

//utility class
final public class Stats {

    public static MutableLiveData<Double> currentTotal;
    public static MutableLiveData<Double> resetTotal;
    public static MutableLiveData<Double> lifetimeTotal;
    public static double prestigeXP;
    public static double multiplier = 1.12;
    public static Date dateStarted;
    public static Date exitTime;
    public static int timesReset;

    private Stats() {
        throw new AssertionError();
    }



    public static MutableLiveData<Double> getCurrentTotal() {
        if(currentTotal == null) {
            currentTotal = new MutableLiveData<>();
        }
        return currentTotal;
    }

    public static void setCurrentTotal(Double d) {
        if(currentTotal == null) {
            currentTotal = new MutableLiveData<>();
        }
        currentTotal.setValue(d);
    }

    public static MutableLiveData<Double> getResetTotal() {
        if(resetTotal == null) {
            resetTotal = new MutableLiveData<>();
        }
        return resetTotal;
    }

    public static void setResetTotal(Double d) {
        if(resetTotal == null) {
            resetTotal = new MutableLiveData<>();
        }
        resetTotal.setValue(d);
    }

    public static MutableLiveData<Double> getLifetimeTotal() {
        if(lifetimeTotal == null) {
            lifetimeTotal = new MutableLiveData<>();
        }
        return lifetimeTotal;
    }

    public static void setLifetimeTotal(Double d) {
        if(lifetimeTotal == null) {
            lifetimeTotal = new MutableLiveData<>();
        }
        lifetimeTotal.setValue(d);
    }

    public static String toString(Double d) {
        if(d >= 10000000) {
            return String.format(Locale.getDefault(), "$%3.2E", d);
        }
        else {
            DecimalFormat formatter = new DecimalFormat("$#,###,###");
            return  formatter.format(d);
        }
    }

    public static String toString(double d) {
        if(d >= 10000000) {
            return String.format(Locale.getDefault(), "$%3.2E", d);
        }
        else {
            DecimalFormat formatter = new DecimalFormat("$#,###,###");
            return  formatter.format(d);
        }
    }

    public static String toStringLevel(int num) {
        return String.format(Locale.getDefault(),
                "%s", "Lvl " + num);
    }
    public static String toString (int i) {
        return String.format(Locale.getDefault(),
                "%s", i);
    }




}
