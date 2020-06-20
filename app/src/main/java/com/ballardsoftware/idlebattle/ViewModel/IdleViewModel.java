package com.ballardsoftware.idlebattle.ViewModel;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.ballardsoftware.idlebattle.Model.Gamer;
import com.ballardsoftware.idlebattle.Model.Team;
import com.ballardsoftware.idlebattle.Model.Weapon;
import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.Utilities.DatabaseHelper;
import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.View.CustomViews.HelpDialog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class IdleViewModel extends AndroidViewModel {


    public static Weapon[] weaponsArray;

    private final DatabaseHelper dbh = DatabaseHelper.getInstance(getApplication().getApplicationContext());
    private final SQLiteDatabase db = getApplication().getApplicationContext().openOrCreateDatabase(
            "IdleBattleDB.db", 0, null);

    public IdleViewModel(@NonNull Application application) {
        super(application);
    }


    public void startGame() {

        Weapon[] weaponsArray = new Weapon[10];
        Gamer[] gamersArray = new Gamer[10];
        Team[] teamsArray= new Team[10];


        final String weaponsTable="Weapons";
        final String weaponID="WeaponID";
        final String weaponName="WeaponName";
        final String weaponBaseIncome="WeaponBaseIncome";
        final String weaponIncome="WeaponIncome";
        final String weaponBaseUpgradeCost="WeaponBaseUpgradeCost";
        final String weaponUpgradeCost="WeaponUpgradeCost";
        final String weaponBaseTime="WeaponBaseTime";
        final String weaponCurrentTime="WeaponCurrentTime";
        final String weaponLevel="WeaponLevel";

        final String gamerTable="Gamers";
        final String gamerName="GamerName";
        final String gamerBasePrice="GamerBasePrice";
        final String gamerLevel="GamerLevel";
        final String gamerUpgradeCost="GamerUpgradeCost";
        final String gamerTime="GamerTime";

        final String teamTable="Teams";
        final String teamName="TeamName";
        final String teamBasePrice="TeamBasePrice";
        final String teamLevel="TeamLevel";
        final String teamUpgradeCost="TeamUpgradeCost";
        final String teamBonus="TeamBonus";


        String [] gamerNames = dbh.getColumn(gamerTable, gamerName, db);
        String [] gamerBasePrices = dbh.getColumn(gamerTable, gamerBasePrice, db);
        String [] gamerLevels = dbh.getColumn(gamerTable, gamerLevel, db);
        String [] gamerUpgradeCosts = dbh.getColumn(gamerTable, gamerUpgradeCost, db);
        String [] gamerTimes = dbh.getColumn(gamerTable, gamerTime, db);

        String [] teamNames = dbh.getColumn(teamTable, teamName, db);
        String [] teamBasePrices = dbh.getColumn(teamTable, teamBasePrice, db);
        String [] teamLevels = dbh.getColumn(teamTable, teamLevel, db);
        String [] teamUpgradeCosts = dbh.getColumn(teamTable, teamUpgradeCost, db);
        String [] teamBonuses = dbh.getColumn(teamTable, teamBonus, db);

        String [] weaponNumbers = dbh.getColumn(weaponsTable, weaponID, db);
        String [] weaponNames = dbh.getColumn(weaponsTable, weaponName, db);
        String [] weaponBaseIncomes = dbh.getColumn(weaponsTable, weaponBaseIncome, db);
        String [] weaponCurrentIncomes = dbh.getColumn(weaponsTable, weaponIncome, db);
        String [] weaponBaseUpgradeCosts = dbh.getColumn(weaponsTable, weaponBaseUpgradeCost, db);
        String [] weaponCurrentUpgradeCosts = dbh.getColumn(weaponsTable, weaponUpgradeCost, db);
        String [] weaponBaseTimes = dbh.getColumn(weaponsTable, weaponBaseTime, db);
        String [] weaponCurrentTimes = dbh.getColumn(weaponsTable, weaponCurrentTime, db);
        String [] weaponLevels = dbh.getColumn(weaponsTable, weaponLevel, db);

        String [] stats = dbh.getStats(db);

        Stats.setCurrentTotal(Double.valueOf(stats[0]));
        Stats.setResetTotal(Double.valueOf(stats[1]));
        Stats.setLifetimeTotal(Double.valueOf(stats[2]));
        Stats.prestigeXP = Double.parseDouble(stats[3]);
        Stats.multiplier = Double.parseDouble(stats[4]);
        String dateStarted = stats[5];
        String exitTime = stats[6];
        Stats.timesReset = Integer.parseInt(stats[7]);

        DateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date startDate = new Date();
        try {
            startDate = dateFormat.parse(dateStarted);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Stats.dateStarted = startDate;

        Date exitDate = null;
        try {
            exitDate = dateFormat.parse(exitTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Stats.exitTime = exitDate;
        for(int i=0; i<10;i++) {

            gamersArray[i] = new Gamer(gamerNames[i],
                    Double.parseDouble(gamerBasePrices[i]),
                    Integer.parseInt(gamerLevels[i]),
                    Double.parseDouble(gamerUpgradeCosts[i]),
                    Integer.parseInt(gamerTimes[i]));

            teamsArray[i] = new Team(teamNames[i],
                    Double.parseDouble(teamBasePrices[i]),
                    Integer.parseInt(teamLevels[i]),
                    Double.parseDouble(teamUpgradeCosts[i]),
                    Integer.parseInt(teamBonuses[i]));

            weaponsArray[i]= new Weapon(Integer.parseInt(weaponNumbers[i]),
                    weaponNames[i],
                    Double.parseDouble(weaponBaseIncomes[i]),
                    Double.parseDouble(weaponCurrentIncomes[i]),
                    Double.parseDouble(weaponBaseUpgradeCosts[i]),
                    Double.parseDouble(weaponCurrentUpgradeCosts[i]),
                    Integer.parseInt(weaponBaseTimes[i]),
                    Integer.parseInt(weaponCurrentTimes[i]),
                    Integer.parseInt(weaponLevels[i]),
                    gamersArray[i], teamsArray[i]);
        }

        IdleViewModel.weaponsArray = weaponsArray;


    }

    //called in ProgressBarButton after the progress countdown is finished
    public static void progressFinished(int weaponNumber) {
        Double income = weaponsArray[weaponNumber].getCurrentIncome();

        if(Stats.getResetTotal().getValue() != null) {
            Stats.resetTotal.setValue(Stats.getResetTotal().getValue()
                    + income);
        }


        if(Stats.getLifetimeTotal().getValue() != null) {
            Stats.lifetimeTotal.setValue(Stats.getLifetimeTotal().getValue()
                    + income);
        }
        if(Stats.getCurrentTotal().getValue() != null) {
            income += Stats.getCurrentTotal().getValue();
        }
        Stats.currentTotal.setValue(income);


    }

    public void saveGame() {
        final Handler handler = new Handler();
        final int delay = 3000;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dbh.saveToDatabase(weaponsArray, db);
                handler.postDelayed(this, delay);
            }
        }, delay);
    }

    public void saveGame2() {
        dbh.saveToDatabase(weaponsArray, db);
    }

    public void saveOnExit() {
        dbh.saveToDatabase(weaponsArray, db);
        db.close();
    }

    public void firstLaunch(Activity activity) {
        /*
        final String PREFS_NAME = "PrefsFile";

        SharedPreferences settings = activity.getSharedPreferences(PREFS_NAME, 0);

        if(settings.getBoolean("first_time_launched", true)) {
            HelpDialog dialog = new HelpDialog();
            dialog.showDialog(activity);
            settings.edit().putBoolean(
                    "first_time_launched", false).apply();
        }

         */
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        //boolean defaultValue = true;
        boolean firstTime = sharedPref.getBoolean("first_time_launched", true);
        if (firstTime) {
            HelpDialog dialog = new HelpDialog();
            dialog.showDialog(activity);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("first_time_launched", false);
            editor.apply();
        }
    }





}

