package com.ballardsoftware.idlebattle.View;

import android.arch.lifecycle.Observer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ballardsoftware.idlebattle.Model.Gamer;
import com.ballardsoftware.idlebattle.Model.Team;
import com.ballardsoftware.idlebattle.Model.Weapon;
import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.Utilities.DatabaseHelper;
import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.View.CustomViews.ViewDialog;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements GamersFragment.OnFragmentInteractionListener,
                    TeamsFragment.OnFragmentInteractionListener,
                    AchievementsFragment.OnFragmentInteractionListener,
                    StatsFragment.OnFragmentInteractionListener{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView output;

    private String startTime;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //SharedPreferences pref = getSharedPreferences("SaveData", 0);
        //final SharedPreferences.Editor editor = pref.edit();

        startGame();

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        output = findViewById(R.id.current_total);

        final Observer<Double> totalObserver = new Observer<Double>() {
            @Override
            public void onChanged(@Nullable Double currentTotal) {
                //output.setText(String.format(Locale.getDefault(),
                      //  "%.0f", currentTotal));
                output.setText(Stats.toString(currentTotal));







                //todo update upgrade prices for max
                //if set to buyMax
                //calculate buyMax
                //update weapon UpgradePrice
                //update UpgradeButton.numberToUpgrade
                //update UpgradeButton.setUpgradePrice

            }
        };

        Stats.getCurrentTotal().observe(this, totalObserver);

        //IdleViewModel.startGame();

        progressWhileAway();

        //if not a fresh game -- if valueWhileAway > 0 ?
        ViewDialog dialog = new ViewDialog();
        //dialog.showDialog(this);


        final Handler handler = new Handler();
        final int delay = 5000;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                DatabaseHelper dbh = new DatabaseHelper(getBaseContext());
                dbh.saveToDatabase(IdleViewModel.weaponsArray);
                handler.postDelayed(this, delay);
            }
        }, delay);


    }
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main, container,
                false);
    }
*/
    private void setupViewPager(ViewPager viewPager) {
        viewPager.setOffscreenPageLimit(6);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new WeaponsFragment(), "Weapons");
        adapter.addFragment(new GamersFragment(), "Gamers");
        adapter.addFragment(new TeamsFragment(), "Teams");
        adapter.addFragment(new AchievementsFragment(), "Achievements");
        adapter.addFragment(new StatsFragment(), "Stats");
        adapter.addFragment(new ThemesFragment(), "Themes");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    //app can be killed after pause or stop - going back to onCreate()

    //pause called when popup over app - then onResume()

    //stop called when app leaves screen - pause always called before stop
    //then onRestart() then onStart()

    @Override
    protected void onResume() {
        DatabaseHelper dbh = new DatabaseHelper(getBaseContext());
        dbh.saveToDatabase(IdleViewModel.weaponsArray);

        super.onResume();
    }


    @Override
    protected void onStop() {DatabaseHelper dbh = new DatabaseHelper(getBaseContext());
        dbh.saveToDatabase(IdleViewModel.weaponsArray);

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        DatabaseHelper dbh = new DatabaseHelper(getBaseContext());
        dbh.saveToDatabase(IdleViewModel.weaponsArray);

        super.onDestroy();
    }



    public void startGame() {





        //progressWhileAway();


        //load from save
        //load in weapons array
        /*
        if(pref != null && loadGame(pref)) {
            //Stats.setCurrentTotal(Double.valueOf(loadGame(pref)));
            loadGame(pref;
        }
        */
        //else {

        /*
            Stats.getCurrentTotal().setValue(0.0);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",
                Locale.getDefault());
        //Date date = new Date();
        Stats.dateStarted = dateFormat;
        Stats.exitTime = dateFormat;
        Stats.getLifetimeTotal().setValue(0.0);
        Stats.getResetTotal().setValue(0.0);
        //}*/

        //if (weaponsArray == null) {
          //  weaponsArray = initializeWeapons();
            //test.setValue(0.0);
            //Stats.setCurrentTotal(test);
            //Stats.getCurrentTotal().setValue(0.0);
        //}
        DatabaseHelper dbh = new DatabaseHelper(this);
        //dbh.execSQL("DROP TABLE IF EXISTS "+weaponsTable);
        //dbh.execSQL("DROP TABLE IF EXISTS "+gamerTable);
        //dbh.execSQL("DROP TABLE IF EXISTS "+teamTable);
        //dbh.execSQL("DROP TABLE IF EXISTS "+statsTable);

        //dbh.delete();

        //dbh.saveToDatabase(weaponsArray);
        Weapon[] weaponsArray = new Weapon[10];
        Gamer[] gamersArray = new Gamer[10];
        Team[] teamsArray= new Team[10];

        //String gamerTable = "Gamers";
        //String teamTable = "Teams";
        //String weaponsTable = "Weapons";

        final String weaponsTable="Weapons";
        final String weaponID="WeaponID";
        final String weaponName="WeaponName";
        final String weaponBaseIncome="WeaponBaseIncome";
        final String weaponIncome="WeaponIncome";
        final String weaponBaseUpgradeCost="WeaponBaseUpgradeCost";
        final String weaponUpgradeCost="WeaponUpgradeCost";
        final String weaponUpgradeTime="WeaponUpgradeTime";
        final String weaponLevel="WeaponLevel";

        final String gamerTable="Gamers";
        final String gamerID="GamerID";
        final String gamerName="GamerName";
        final String gamerBasePrice="GamerBasePrice";
        final String gamerLevel="GamerLevel";
        final String gamerUpgradeCost="GamerUpgradeCost";
        final String gamerTime="GamerTime";

        final String teamTable="Teams";
        final String teamID = "TeamID";
        final String teamName="TeamName";
        final String teamBasePrice="TeamBasePrice";
        final String teamLevel="TeamLevel";
        final String teamUpgradeCost="TeamUpgradeCost";
        final String teamBonus="TeamBonus";



        //String [] gamerNames = dbh.getGamerNames();
        String [] gamerNames = dbh.getColumn(gamerTable, gamerName);
        String [] gamerBasePrices = dbh.getColumn(gamerTable, gamerBasePrice);
        String [] gamerLevels = dbh.getColumn(gamerTable, gamerLevel);
        String [] gamerUpgradeCosts = dbh.getColumn(gamerTable, gamerUpgradeCost);
        String [] gamerTimes = dbh.getColumn(gamerTable, gamerTime);

        String [] teamNames = dbh.getColumn(teamTable, teamName);
        String [] teamBasePrices = dbh.getColumn(teamTable, teamBasePrice);
        String [] teamLevels = dbh.getColumn(teamTable, teamLevel);
        String [] teamUpgradeCosts = dbh.getColumn(teamTable, teamUpgradeCost);
        String [] teamBonuses = dbh.getColumn(teamTable, teamBonus);

        String [] weaponNames = dbh.getColumn(weaponsTable, weaponName);
        String [] weaponBaseIncomes = dbh.getColumn(weaponsTable, weaponBaseIncome);
        String [] weaponCurrentIncomes = dbh.getColumn(weaponsTable, weaponIncome);
        String [] weaponBaseUpgradeCosts = dbh.getColumn(weaponsTable, weaponBaseUpgradeCost);
        String [] weaponCurrentUpgradeCosts = dbh.getColumn(weaponsTable, weaponUpgradeCost);
        String [] weaponTimes = dbh.getColumn(weaponsTable, weaponUpgradeTime);
        String [] weaponLevels = dbh.getColumn(weaponsTable, weaponLevel);

        String [] stats = dbh.getStats();

        Stats.setCurrentTotal(Double.valueOf(stats[0]));
        Stats.setResetTotal(Double.valueOf(stats[1]));
        Stats.setLifetimeTotal(Double.valueOf(stats[2]));
        Stats.prestigeXP = Double.parseDouble(stats[3]);
        Stats.multiplier = Double.parseDouble(stats[4]);
        String dateStarted = stats[5];


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.getDefault());
        Date startDate = new Date();
        try {
            startDate = dateFormat.parse(dateStarted);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Stats.dateStarted = startDate;
        String exitTime = stats[6];
        Date exitDate = null;
        try {
            exitDate = dateFormat.parse(exitTime);
        } catch (ParseException e) {
            e.printStackTrace();;
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

            weaponsArray[i]= new Weapon(weaponNames[i],
                    Double.parseDouble(weaponBaseIncomes[i]),
                    Double.parseDouble(weaponCurrentIncomes[i]),
                    Double.parseDouble(weaponBaseUpgradeCosts[i]),
                    Double.parseDouble(weaponCurrentUpgradeCosts[i]),
                    Long.parseLong(weaponTimes[i]),
                    Integer.parseInt(weaponLevels[i]),
                    gamersArray[i], teamsArray[i]);
        }

        //System.out.println(dbh.getWeapons());

        IdleViewModel.weaponsArray = weaponsArray;

        DateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss",
                Locale.getDefault());
        Date date = new Date();

        startTime = startDateFormat.format(date);




        //.setIncome() also changes incomeNumber
        //weaponsArray[0].setIncome(5);
        //get current time
        //calculate amounts earned from last time played for each weapon
    }

    private void progressWhileAway(){

        Date startTime = new Date();

        DateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss",
                Locale.getDefault());


        //double start = Double.valueOf(startTime);
        System.out.println("\n\nStart Time: "+startTime);
        //String endTime = Stats.toString(Stats.exitTime);
        System.out.println("Exit Time: "+Stats.exitTime+"\n\n");
        //double exit = Double.valueOf(endTime);

        long timeDifference = startTime.getTime() - Stats.exitTime.getTime();
        System.out.println("time difference: " + timeDifference);


    }



    //todo use gson only for themes

    /*
    private void saveGame(SharedPreferences.Editor editor) {
        editor.putString("currentTotal", Stats.
                toString(Stats.getCurrentTotal().getValue()));
        //save other stats

        //save weaponsArray
        Gson gson = new Gson();
        //works with full array, but might be easier dealing with one at a time
        //must do one at a time for loading
        String json1 = gson.toJson(weaponsArray[0]);
        String json2 = gson.toJson(weaponsArray[1]);
        String json3 = gson.toJson(weaponsArray[2]);
        String json4 = gson.toJson(weaponsArray[3]);
        String json5 = gson.toJson(weaponsArray[4]);
        String json6 = gson.toJson(weaponsArray[5]);
        String json7 = gson.toJson(weaponsArray[6]);
        String json8 = gson.toJson(weaponsArray[7]);
        String json9 = gson.toJson(weaponsArray[8]);
        String json10 = gson.toJson(weaponsArray[9]);

        String bigJson = "{'baseIncome':'4.0','basePrice':'30','upgradeTime':'100','level':'2','upgradeCost':'30.0','income':'4.0','gamer':{'name':'John','basePrice':'3.4','level':'3','upgradeCost':'100.0','time':'10000'},'team':{'name':'Joe','basePrice':'35.0','level':'10','upgradeCost':'200.0','bonus':'4'}";

        editor.putString("bigWeapon", bigJson);
        System.out.println(json1);

        editor.putString("weapon1", json1);
        editor.putString("weapon2", json2);
        editor.putString("weapon3", json3);
        editor.putString("weapon4", json4);
        editor.putString("weapon5", json5);
        editor.putString("weapon6", json6);
        editor.putString("weapon7", json7);
        editor.putString("weapon8", json8);
        editor.putString("weapon9", json9);
        editor.putString("weapon10", json10);


        //save current date and time
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",
                Locale.getDefault());
        Date date = new Date();

        editor.putString("currentTime", dateFormat.format(date));

        editor.commit();
    }

    public boolean loadGame(SharedPreferences pref) {
        Gson gson = new Gson();


        String json1 = pref.getString("weapons1", "");
        String json2 = pref.getString("weapons2", null);
        String json3 = pref.getString("weapons3", null);
        String json4 = pref.getString("weapons4", null);
        String json5 = pref.getString("weapons5", null);
        String json6 = pref.getString("weapons6", null);
        String json7 = pref.getString("weapons7", null);
        String json8 = pref.getString("weapons8", null);
        String json9 = pref.getString("weapons9", null);
        String json10 = pref.getString("weapons10", null);
        System.out.println(json1 + "here");


        //&quot;baseIncome&quot;:4.0,&quot;basePrice&quot;:30.0,&quot;gamer&quot;:{&quot;gamerTime&quot;:10000,&quot;basePrice&quot;:200.0,&quot;level&quot;:0,&quot;name&quot;:&quot;XxX360Johnny&quot;,&quot;upgradeCost&quot;:200.0},&quot;income&quot;:4.0,&quot;level&quot;:1,&quot;team&quot;:{&quot;bonus&quot;:1,&quot;basePrice&quot;:400.0,&quot;level&quot;:0,&quot;name&quot;:&quot;Noob Gaming&quot;,&quot;upgradeCost&quot;:400.0},&quot;upgradeCost&quot;:30.0,&quot;upgradeTime&quot;:2000}
        //JSONObject object = json1.get("weapons1");

        //String bigJson = "{\"baseIncome\":4.0,\"basePrice\":30,\"upgradeTime\":100,\"level\":2,\"upgradeCost\":30.0,\"income\":4.0,\"gamer\":{\"name\":\"John\",\"basePrice\":3.5,\"level\":3,\"upgradeCost\":100.0,\"time\":10000},\"team\":{\"name\":\"Joe\",\"basePrice\":35.0,\"level\":10,\"upgradeCost\":200.0,\"bonus\":4}";

        //System.out.println(bigJson + "here");
        Type type = new TypeToken<Weapon>(){}.getType();

        //Weapon weapon1 = gson.fromJson(bigJson, type);
        Weapon weapon1 = gson.fromJson(json1, type);
        //if(json1 != null)
            //System.out.println(weapon1.getLevel());

        Weapon weapon2 = gson.fromJson(json2, Weapon.class);
        Weapon weapon3 = gson.fromJson(json3, Weapon.class);
        Weapon weapon4 = gson.fromJson(json4, Weapon.class);
        Weapon weapon5 = gson.fromJson(json5, Weapon.class);
        Weapon weapon6 = gson.fromJson(json6, Weapon.class);
        Weapon weapon7 = gson.fromJson(json7, Weapon.class);
        Weapon weapon8 = gson.fromJson(json8, Weapon.class);
        Weapon weapon9 = gson.fromJson(json9, Weapon.class);
        Weapon weapon10 = gson.fromJson(json10, Weapon.class);


        if(weapon1 != null) {
            weaponsArray = new Weapon[] {weapon1, weapon2, weapon3,
                    weapon4, weapon5, weapon6, weapon7, weapon8, weapon9,
                    weapon10};
            System.out.println("one");
        }


        if(pref.getString("currentTotal", null) != null) {
            Stats.setCurrentTotal(Double.valueOf(pref.getString(
                    "currentTotal", null)));
            return true;
        }

        return false;


        //return pref.getString("currentTotal", null);
    }
 */
}
