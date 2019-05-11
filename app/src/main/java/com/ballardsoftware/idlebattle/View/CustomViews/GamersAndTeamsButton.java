package com.ballardsoftware.idlebattle.View.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

public class GamersAndTeamsButton extends FrameLayout
        implements View.OnClickListener{

    TextView name;
    TextView currentLevel;
    TextView upgradeCost;
    FrameLayout upgradeButton;

    public GamersAndTeamsButton(Context context) {
        super(context);
    }

    public GamersAndTeamsButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.gamers_and_teams_button, this);

        initComponents();
    }

    private void initComponents() {
        upgradeButton = (FrameLayout) findViewById(R.id.upgrade_button);
        name = (TextView) findViewById(R.id.name);
        currentLevel = (TextView) findViewById(R.id.current_level);
        upgradeCost = (TextView) findViewById(R.id.upgrade_price);

        upgradeButton.setOnClickListener(this);

    }

    public void setName(String text) {
        name.setText(text);
    }

    public void setLevel(String text) {
        currentLevel.setText(text);
    }

    public void setUpgradeCost(String text) {
        upgradeCost.setText(text);
    }

    public FrameLayout getUpgradeButton() {
        return upgradeButton;
    }

    @Override
    public void onClick(View v) {

        //ProgressBarButton p1 = WeaponsFragment.getProgressBarButton();
        ProgressBarButton p1 = getRootView().findViewById(R.id.progress_bar_1);
        ProgressBarButton p2 = getRootView().findViewById(R.id.progress_bar_2);
        ProgressBarButton p3 = getRootView().findViewById(R.id.progress_bar_3);
        ProgressBarButton p4 = getRootView().findViewById(R.id.progress_bar_4);
        ProgressBarButton p5 = getRootView().findViewById(R.id.progress_bar_5);
        ProgressBarButton p6 = getRootView().findViewById(R.id.progress_bar_6);
        ProgressBarButton p7 = getRootView().findViewById(R.id.progress_bar_7);
        ProgressBarButton p8 = getRootView().findViewById(R.id.progress_bar_8);
        ProgressBarButton p9 = getRootView().findViewById(R.id.progress_bar_9);
        ProgressBarButton p10 = getRootView().findViewById(R.id.progress_bar_10);

        switch (getId()){
            case R.id.gamer_upgrade_1:
                gamerUpgrade(0);
                break;
            case R.id.gamer_upgrade_2:
                gamerUpgrade(1);
                break;
            case R.id.gamer_upgrade_3:
                gamerUpgrade(2);
                break;
            case R.id.gamer_upgrade_4:
                gamerUpgrade(3);
                break;
            case R.id.gamer_upgrade_5:
                gamerUpgrade(4);
                break;
            case R.id.gamer_upgrade_6:
                gamerUpgrade(5);
                break;
            case R.id.gamer_upgrade_7:
                gamerUpgrade(6);
                break;
            case R.id.gamer_upgrade_8:
                gamerUpgrade(7);
                break;
            case R.id.gamer_upgrade_9:
                gamerUpgrade(8);
                break;
            case R.id.gamer_upgrade_10:
                gamerUpgrade(9);
                break;


            case R.id.team_upgrade_1:
                teamUpgrade(0, p1);
                break;
            case R.id.team_upgrade_2:
                teamUpgrade(1, p2);
                break;
            case R.id.team_upgrade_3:
                teamUpgrade(2, p3);
                break;
            case R.id.team_upgrade_4:
                teamUpgrade(3, p4);
                break;
            case R.id.team_upgrade_5:
                teamUpgrade(4, p5);
                break;
            case R.id.team_upgrade_6:
                teamUpgrade(5, p6);
                break;
            case R.id.team_upgrade_7:
                teamUpgrade(6, p7);
                break;
            case R.id.team_upgrade_8:
                teamUpgrade(7, p8);
                break;
            case R.id.team_upgrade_9:
                teamUpgrade(8, p9);
                break;
            case R.id.team_upgrade_10:
                teamUpgrade(9, p10);
                break;
        }
    }

    private void gamerUpgrade(int i) {
        IdleViewModel.weaponsArray[i].getGamer().upgrade(0);
        if(IdleViewModel.weaponsArray[i].getGamer().getLevel() == 10) {
            setUpgradeCost("Max");
        }
        else
            setUpgradeCost(Stats.toString(IdleViewModel.weaponsArray[i].
                    getGamer().getUpgradeCost()));
        setLevel(Stats.toStringLevel(IdleViewModel.weaponsArray[i].
                getGamer().getLevel()));
    }

    private void teamUpgrade(int i, ProgressBarButton p) {
        IdleViewModel.weaponsArray[i].getTeam().upgrade(i);
        if(IdleViewModel.weaponsArray[i].getTeam().getLevel() == 10) {
            setUpgradeCost("Max");
        }
        else
            setUpgradeCost(Stats.toString(IdleViewModel.weaponsArray[i].
                    getTeam().getUpgradeCost()));
        setLevel(Stats.toStringLevel(IdleViewModel.weaponsArray[i].getTeam().
                getLevel()));
        p.setWeaponIncome(Stats.toString(IdleViewModel.weaponsArray[i].
                getCurrentIncome()));
        //display income changes


        //IdleViewModel.weaponsArray[i].setIncome();
    }

    /*@Override
    public void onClick(View v) {
        //IdleView.upgradeGamer();
        /*
         * if currentTotal > upgrade cost
         * { level++
         *   upgradeCost();
         *   bonuses
         * }
         *

        //display new level
        //display new upgrade cost

        switch (getId()){
            case R.id.gamersFragment:
                System.out.println("gamers");
                //IdleView.upgradeGamer(0);
                break;
            case R.id.teamsFragment:
                System.out.println("teams");
                //IdleView.upgradeTeam(0);
                break;
        }
    }*/
}
