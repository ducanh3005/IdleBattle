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

import java.util.ArrayList;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                output.setText(toString1(currentTotal));
                //todo update upgrade prices for each buyButton
                //if set to buyMax
                //calculate buyMax
                //update weapon UpgradePrice
                //update UpgradeButton.numberToUpgrade
                //update UpgradeButton.setUpgradePrice
            }
        };

        Stats.getCurrentTotal().observe(this, totalObserver);

        //IdleViewModel.startGame();


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

    private String toString1(Double d) {
        if(d >= 10000000) {
            return String.format(Locale.getDefault(), "%3.3E", d);
        }
        else
            return String.format(Locale.getDefault(), "%.0f", d);
    }

}
