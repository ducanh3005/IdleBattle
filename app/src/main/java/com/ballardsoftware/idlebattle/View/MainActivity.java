package com.ballardsoftware.idlebattle.View;

import android.arch.lifecycle.Observer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements GamersFragment.OnFragmentInteractionListener,
                    TeamsFragment.OnFragmentInteractionListener,
                    AchievementsFragment.OnFragmentInteractionListener,
                    StatsFragment.OnFragmentInteractionListener{

    private TextView output;
    IdleViewModel ivm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);



        ivm = new IdleViewModel(this.getApplication());

        ivm.startGame();
        ivm.firstLaunch(this);
        //ivm.saveGame();

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        output = findViewById(R.id.current_total);

        final Observer<Double> totalObserver = new Observer<Double>() {
            @Override
            public void onChanged(@Nullable Double currentTotal) {

                output.setText(Stats.toString(currentTotal));
                ivm.saveGame2();

                //update upgrade prices for max
                //if set to buyMax
                //calculate buyMax
                //update weapon UpgradePrice
                //update UpgradeButton.numberToUpgrade
                //update UpgradeButton.setUpgradePrice
            }
        };

        Stats.getCurrentTotal().observe(this, totalObserver);

    }
    private void setupViewPager(ViewPager viewPager) {
        viewPager.setOffscreenPageLimit(6);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new WeaponsFragment(), "Weapons");
        adapter.addFragment(new GamersFragment(), "Gamers");
        adapter.addFragment(new TeamsFragment(), "Teams");
        //adapter.addFragment(new AchievementsFragment(), "Achievements");
        adapter.addFragment(new StatsFragment(), "Stats");
        //adapter.addFragment(new ThemesFragment(), "Themes");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
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

        void addFragment(Fragment fragment, String title) {
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
    protected void onPause() {
        ivm.saveOnExit();
        System.exit(0);
        super.onPause();
    }


    @Override
    protected void onStop() {
        ivm.saveOnExit();
        System.exit(0);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        ivm.saveOnExit();
        super.onDestroy();
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }










}
