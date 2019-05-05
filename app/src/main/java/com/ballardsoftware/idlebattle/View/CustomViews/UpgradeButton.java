package com.ballardsoftware.idlebattle.View.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

import java.util.Locale;

public class UpgradeButton extends FrameLayout
        implements View.OnClickListener {
    FrameLayout upgradeWeaponBtn;
    TextView upgradeWeaponPrice;
    TextView weaponLevel;

    public UpgradeButton(Context context) {
        super(context);
    }

    public UpgradeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.upgrade_button, this);

        int[] sets = {R.attr.upgradeWeaponBtn, R.attr.upgradeWeaponPrice,
                R.attr.weaponLevel};
        TypedArray typedArray = context.obtainStyledAttributes(attrs, sets);
        typedArray.recycle();

        initComponents();
    }

    private void initComponents() {
        upgradeWeaponBtn = (FrameLayout) findViewById(R.id.upgrade_weapon_btn);
        upgradeWeaponPrice = (TextView) findViewById(R.id.weapon_upgrade_price);
        weaponLevel = (TextView) findViewById(R.id.weapon_level);

        upgradeWeaponBtn.setOnClickListener(this);
    }

    public CharSequence getUpgradeWeaponPrice() {
        return upgradeWeaponPrice.getText();
    }

    public void setUpgradeWeaponPrice(CharSequence text) {
        upgradeWeaponPrice.setText(text);
    }

    public CharSequence getWeaponLevel() {
        return weaponLevel.getText();
    }

    public void setWeaponLevel(CharSequence text) {
        weaponLevel.setText(text);
    }

    static int numberToUpgrade = 1;

    public static void setNumberToUpgrade(int numberToUpgrade) {
        UpgradeButton.numberToUpgrade = numberToUpgrade;
    }

    @Override
    public void onClick(View v) {
        upgradeClicked();
    }

    /*todo: set up onclick listeners for upgrade buttons
     * todo this should be in Upgrade button
     * todo only display initial income in this WeaponsFragment
     * functions in idleviewmodel
     * weaponArray[0].upgrade();  ----> use switch cases
     *   display currentTotal
     *   display upgradePrice
     *   display weaponIncome
     *   display weaponLevel
     *
     */
    private void upgradeClicked() {
        //Weapon weapons [] = IdleViewModel.weaponsArray;

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

        switch (getId()) {
            case R.id.upgrade_weapon_btn_1:
                upgrade(0, p1);
                break;
            case R.id.upgrade_weapon_btn_2:
                upgrade(1, p2);
                break;
            case R.id.upgrade_weapon_btn_3:
                upgrade(2, p3);
                break;
            case R.id.upgrade_weapon_btn_4:
                upgrade(3, p4);
                break;
            case R.id.upgrade_weapon_btn_5:
                upgrade(4, p5);
                break;
            case R.id.upgrade_weapon_btn_6:
                upgrade(5, p6);
                break;
            case R.id.upgrade_weapon_btn_7:
                upgrade(6, p7);
                break;
            case R.id.upgrade_weapon_btn_8:
                upgrade(7, p8);
                break;
            case R.id.upgrade_weapon_btn_9:
                upgrade(8, p9);
                break;
            case R.id.upgrade_weapon_btn_10:
                upgrade(9, p10);
                break;
        }
    }

    private void upgrade(int i, ProgressBarButton p) {
        IdleViewModel.weaponsArray[i].upgrade(numberToUpgrade);
        upgradeWeaponPrice.setText(toString(IdleViewModel.weaponsArray[i].getUpgradeCost()));
        weaponLevel.setText(toString(IdleViewModel.weaponsArray[i].getLevel()));

        p.setWeaponIncome(toString(IdleViewModel.weaponsArray[i].getIncome()));

        TextView output = getRootView().findViewById(R.id.current_total);
        output.setText(toString(Stats.getCurrentTotal().getValue()));

    }





    private String toString(Double d) {
        if(d >= 10000000) {
            return String.format(Locale.getDefault(), "%3.3E", d);
        }
        else
        return String.format(Locale.getDefault(), "%.0f", d);
    }
    private String toString(int i) {
        return String.format(Locale.getDefault(), "%s",
                "Lvl " + i);
    }
}
