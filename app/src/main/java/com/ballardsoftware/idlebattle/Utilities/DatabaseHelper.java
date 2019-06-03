package com.ballardsoftware.idlebattle.Utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ballardsoftware.idlebattle.Model.Weapon;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static java.lang.System.currentTimeMillis;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper instance = null;

    private static final String dbName="IdleBattleDB";
    private static final String weaponsTable="Weapons";
    private static final String weaponID="WeaponID";
    private static final String weaponName="WeaponName";
    private static final String weaponBaseIncome="WeaponBaseIncome";
    private static final String weaponIncome="WeaponIncome";
    private static final String weaponBaseUpgradeCost="WeaponBaseUpgradeCost";
    private static final String weaponUpgradeCost="WeaponUpgradeCost";
    private static final String weaponBaseTime="WeaponBaseTime";
    private static final String weaponCurrentTime="WeaponCurrentTime";
    private static final String weaponLevel="WeaponLevel";



    private static final String gamerTable="Gamers";
    private static final String gamerID="GamerID";
    private static final String gamerName="GamerName";
    private static final String gamerBasePrice="GamerBasePrice";
    private static final String gamerLevel="GamerLevel";
    private static final String gamerUpgradeCost="GamerUpgradeCost";
    private static final String gamerTime="GamerTime";

    private static final String teamTable="Teams";
    private static final String teamID = "TeamID";
    private static final String teamName="TeamName";
    private static final String teamBasePrice="TeamBasePrice";
    private static final String teamLevel="TeamLevel";
    private static final String teamUpgradeCost="TeamUpgradeCost";
    private static final String teamBonus="TeamBonus";

    private static final String statsTable="Stats";
    private static final String statsID="TeamID";
    private static final String currentTotal="CurrentTotal";
    private static final String resetTotal="ResetTotal";
    private static final String lifetimeTotal="LifetimeTotal";
    private static final String prestigeXP="PrestigeXP";
    private static final String multiplier="Multiplier";
    private static final String dateStarted="DateStarted";
    private static final String exitTime="ExitTime";
    private static final String timesReset="TimesReset";


    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, dbName, null,38);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+statsTable+" ("+
                        statsID+" INTEGER PRIMARY KEY , "+
                        currentTotal+" REAL, "+
                        resetTotal+" REAL, "+
                        lifetimeTotal+" REAL, "+
                        prestigeXP+" REAL, "+
                        multiplier+" REAL, "+
                        dateStarted+" TEXT, "+
                        exitTime+" TEXT, "+
                        timesReset+" INTEGER)");

        db.execSQL("CREATE TABLE "+gamerTable+" ("+
                        gamerID+" INTEGER PRIMARY KEY , "+
                        gamerName+" TEXT, "+
                        gamerBasePrice+" REAL, "+
                        gamerLevel+" INTEGER, "+
                        gamerUpgradeCost+" REAL, "+
                        gamerTime+" INTEGER)");


        db.execSQL("CREATE TABLE " +teamTable+" ("+
                        teamID+" INTEGER PRIMARY KEY , "+
                        teamName+" TEXT, "+
                        teamBasePrice+" REAL, "+
                        teamLevel+" INTEGER, "+
                        teamUpgradeCost+" REAL, "+
                        teamBonus+" INTEGER)");



        db.execSQL("CREATE TABLE "+weaponsTable+" ("+
                        weaponID+" INTEGER PRIMARY KEY, "+
                        weaponName+" TEXT, "+
                        weaponBaseIncome+" REAL, "+
                        weaponIncome+" REAL, "+
                        weaponBaseUpgradeCost+" REAL, "+
                        weaponUpgradeCost+" REAL, "+
                        weaponBaseTime+" INTEGER, "+
                        weaponCurrentTime+" INTEGER, "+
                        weaponLevel+" INTEGER);");

                initializeData(db, 1, 0.0,0, 1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        System.out.println("onUpgrade..........");
        System.out.println("old: "+oldVersion);
        System.out.println("new: "+ newVersion);
        if(oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+weaponsTable);
            db.execSQL("DROP TABLE IF EXISTS "+gamerTable);
            db.execSQL("DROP TABLE IF EXISTS "+teamTable);
            db.execSQL("DROP TABLE IF EXISTS "+statsTable);

            onCreate(db);
        }

    }

    public void delete(SQLiteDatabase db) {
        System.out.println("delete.........");
        db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+weaponsTable);
        db.execSQL("DROP TABLE IF EXISTS "+gamerTable);
        db.execSQL("DROP TABLE IF EXISTS "+teamTable);
        db.execSQL("DROP TABLE IF EXISTS "+statsTable);

        onCreate(db);
    }


    public String [] getStats(SQLiteDatabase db) {
        db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + statsTable, null);
        ArrayList<String> statsList = new ArrayList<>();
        cursor.moveToFirst();
        do {
            statsList.add(cursor.getString(cursor.getColumnIndex(currentTotal)));
            statsList.add(cursor.getString(cursor.getColumnIndex(resetTotal)));
            statsList.add(cursor.getString(cursor.getColumnIndex(lifetimeTotal)));
            statsList.add(cursor.getString(cursor.getColumnIndex(prestigeXP)));
            statsList.add(cursor.getString(cursor.getColumnIndex(multiplier)));
            statsList.add(cursor.getString(cursor.getColumnIndex(dateStarted)));
            statsList.add(cursor.getString(cursor.getColumnIndex(exitTime)));
            statsList.add(cursor.getString(cursor.getColumnIndex(timesReset)));
        } while (cursor.moveToNext());

        cursor.close();

        return statsList.toArray(new String[7]);
    }

    public String [] getColumn(String tableName, String columnName, SQLiteDatabase db) {
        db=this.getReadableDatabase();
        ArrayList<String> columnArray = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ tableName, null);
        cursor.moveToFirst();
        do {
            String s = cursor.getString(cursor.getColumnIndex(columnName));
            columnArray.add(s);

        } while (cursor.moveToNext());

        cursor.close();
        return columnArray.toArray(new String[10]);
    }










    public void saveToDatabase(Weapon[] weapons, SQLiteDatabase db) {

        long startTime = currentTimeMillis();


        db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(statsID, 1);
        cv.put(currentTotal, Stats.getCurrentTotal().getValue());
        cv.put(resetTotal, Stats.getResetTotal().getValue());
        cv.put(lifetimeTotal, Stats.getLifetimeTotal().getValue());
        cv.put(prestigeXP, Stats.prestigeXP);
        cv.put(multiplier, Stats.multiplier);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.getDefault());
        String startDate = dateFormat.format(Stats.dateStarted);

        cv.put(dateStarted, startDate);



        Date date = new Date();
        String timeExit = dateFormat.format(date);

        cv.put(exitTime, timeExit);
        cv.put(timesReset, Stats.timesReset);
        db.replace(statsTable, statsID, cv);


        for (int i = 0;i<10;i++){
            cv=new ContentValues();
            cv.put(weaponID, i);
            cv.put(weaponName, weapons[i].getName());
            cv.put(weaponBaseIncome, weapons[i].getBaseIncome());
            cv.put(weaponIncome, weapons[i].getCurrentIncome());
            cv.put(weaponBaseUpgradeCost, weapons[i].getBaseUpgradeCost());
            cv.put(weaponUpgradeCost, weapons[i].getCurrentUpgradeCost());
            cv.put(weaponBaseTime, weapons[i].getBaseTime());
            cv.put(weaponCurrentTime, weapons[i].getCurrentTime());
            cv.put(weaponLevel, weapons[i].getLevel());
            db.replace(weaponsTable, weaponID, cv);

            cv=new ContentValues();
            cv.put(gamerID, i);
            cv.put(gamerName, weapons[i].getGamer().getName());
            cv.put(gamerBasePrice, weapons[i].getGamer().getBasePrice());
            cv.put(gamerLevel, weapons[i].getGamer().getLevel());
            cv.put(gamerUpgradeCost, weapons[i].getGamer().getUpgradeCost());
            cv.put(gamerTime, weapons[i].getGamer().getTime());
            db.replace(gamerTable, gamerID, cv);

            cv=new ContentValues();
            cv.put(teamID, i);
            cv.put(teamName, weapons[i].getTeam().getName());
            cv.put(teamBasePrice, weapons[i].getTeam().getBasePrice());
            cv.put(teamLevel, weapons[i].getTeam().getLevel());
            cv.put(teamUpgradeCost, weapons[i].getTeam().getUpgradeCost());
            cv.put(teamBonus, weapons[i].getTeam().getBonus());
            db.replace(teamTable, teamID, cv);

        }

        long endTime = currentTimeMillis();

        //System.out.println("Save time: "+ (endTime - startTime));
    }

    public void initializeData(SQLiteDatabase db, double prestigeBonus,
                                double lifeTotal, int resetNumber, int value) {

        final int arrayLength = 10;
        final int level = 0;
        final int gamerTimer = 10000;
        final int bonus = 1;
        final int currentTime = 0;

        String [] wName = new String[arrayLength];
        wName[0] = "Fist";
        wName[1] = "Super Punch Gloves";
        wName[2] = "Combat Knife";
        wName[3] = "Target Pistol";
        wName[4] = "Quail Shotgun";
        wName[5] = "Q18 Automatic";
        wName[6] = "Military Rifle";
        wName[7] = "Grenade Thrower";
        wName[8] = "Missile Stick";
        wName[9] = "Big Laser Alien Gun";

        double [] baseWeaponIncome = new double[arrayLength];
        baseWeaponIncome[0] = 4;
        baseWeaponIncome[1] = 10;
        baseWeaponIncome[2] = 50;
        baseWeaponIncome[3] = 100;
        baseWeaponIncome[4] = 200;
        baseWeaponIncome[5] = 400;
        baseWeaponIncome[6] = 750;
        baseWeaponIncome[7] = 1000;
        baseWeaponIncome[8] = 2500;
        baseWeaponIncome[9] = 10000;

        double [] baseUpgradePrice = new double[arrayLength];
        baseUpgradePrice[0] = 30;
        baseUpgradePrice[1] = 50;
        baseUpgradePrice[2] = 250;
        baseUpgradePrice[3] = 500;
        baseUpgradePrice[4] = 1000;
        baseUpgradePrice[5] = 2000;
        baseUpgradePrice[6] = 3750;
        baseUpgradePrice[7] = 5000;
        baseUpgradePrice[8] = 12500;
        baseUpgradePrice[9] = 50000;

        int [] weaponBaseTimeArray = new int[arrayLength];
        weaponBaseTimeArray[0] = 2000;
        weaponBaseTimeArray[1] = 4000;
        weaponBaseTimeArray[2] = 10000;
        weaponBaseTimeArray[3] = 20000;
        weaponBaseTimeArray[4] = 50000;
        weaponBaseTimeArray[5] = 120000;
        weaponBaseTimeArray[6] = 240000;
        weaponBaseTimeArray[7] = 480000;
        weaponBaseTimeArray[8] = 780000;
        weaponBaseTimeArray[9] = 1200000;



        int [] wLevel = new int[arrayLength];
        wLevel[0] = 1;
        wLevel[1] = 0;
        wLevel[2] = 0;
        wLevel[3] = 0;
        wLevel[4] = 0;
        wLevel[5] = 0;
        wLevel[6] = 0;
        wLevel[7] = 0;
        wLevel[8] = 0;
        wLevel[9] = 0;



        String [] gName = new String[arrayLength];
        gName[0] = "XxX360Johnny";
        gName[1] = "I🖤URMom";
        gName[2] = "420Killz";
        gName[3] = "ImTheBest";
        gName[4] = "SonicSpeed";
        gName[5] = "Hannah1996";
        gName[6] = "TheRealSteve3";
        gName[7] = "Pro_Rachel";
        gName[8] = "Pro_James";
        gName[9] = "Pro_Joe";

        double [] baseGamerPrice = new double[arrayLength];
        baseGamerPrice[0] = 200;
        baseGamerPrice[1] = 500;
        baseGamerPrice[2] = 2500;
        baseGamerPrice[3] = 5000;
        baseGamerPrice[4] = 10000;
        baseGamerPrice[5] = 20000;
        baseGamerPrice[6] = 37500;
        baseGamerPrice[7] = 50000;
        baseGamerPrice[8] = 125000;
        baseGamerPrice[9] = 500000;


        String [] tName = new String[arrayLength];
        tName[0] = "Noob Gaming";
        tName[1] = "Rank 1";
        tName[2] = "The Killerz";
        tName[3] = "Team Best";
        tName[4] = "Speedy Fast";
        tName[5] = "GirlsOnly";
        tName[6] = "Real Gamers";
        tName[7] = "GO Team";
        tName[8] = "Team Solid";
        tName[9] = "Elite Gamers";

        double [] baseTeamPrice = new double[arrayLength];
        baseTeamPrice[0] = 400;
        baseTeamPrice[1] = 1000;
        baseTeamPrice[2] = 5000;
        baseTeamPrice[3] = 10000;
        baseTeamPrice[4] = 20000;
        baseTeamPrice[5] = 40000;
        baseTeamPrice[6] = 75000;
        baseTeamPrice[7] = 100000;
        baseTeamPrice[8] = 250000;
        baseTeamPrice[9] = 1000000;

        switch (value) {
            case 1:
                break;
            case 2:
                db=this.getWritableDatabase();
                break;
        }

        ContentValues cv=new ContentValues();

        cv.put(statsID, 1);
        cv.put(currentTotal, 0.0);
        cv.put(resetTotal, 0.0);
        cv.put(lifetimeTotal, lifeTotal);
        cv.put(prestigeXP, prestigeBonus);
        cv.put(multiplier, 1.12);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.getDefault());
        Date date = new Date();
        String startDate = dateFormat.format(date);
        System.out.println("initial startDate in database: " +startDate);
        cv.put(dateStarted, startDate);
        String timeExit = dateFormat.format(date);
        cv.put(exitTime, timeExit);
        cv.put(timesReset, resetNumber);
        db.replace(statsTable, statsID, cv);//was insert

        for (int i = 0;i<10;i++){
            cv=new ContentValues();
            cv.put(weaponID, i);
            cv.put(weaponName, wName[i]);
            cv.put(weaponBaseIncome, baseWeaponIncome[i]);
            cv.put(weaponIncome, baseWeaponIncome[i]);
            cv.put(weaponBaseUpgradeCost, baseUpgradePrice[i]);
            cv.put(weaponUpgradeCost, baseUpgradePrice[i]);
            cv.put(weaponBaseTime, weaponBaseTimeArray[i]);
            cv.put(weaponCurrentTime, currentTime);
            cv.put(weaponLevel, wLevel[i]);
            db.replace(weaponsTable, weaponID, cv);

            cv=new ContentValues();
            cv.put(gamerID, i);
            cv.put(gamerName, gName[i]);
            cv.put(gamerBasePrice, baseGamerPrice[i]);
            cv.put(gamerLevel, level);
            cv.put(gamerUpgradeCost, baseGamerPrice[i]);
            cv.put(gamerTime, gamerTimer);
            db.replace(gamerTable, gamerID, cv);

            cv=new ContentValues();
            cv.put(teamID, i);
            cv.put(teamName, tName[i]);
            cv.put(teamBasePrice, baseTeamPrice[i]);
            cv.put(teamLevel, level);
            cv.put(teamUpgradeCost, baseTeamPrice[i]);
            cv.put(teamBonus, bonus);
            db.replace(teamTable, teamID, cv);
        }
    }
}
