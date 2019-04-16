package com.ballardsoftware.idlebattle.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ballardsoftware.idlebattle.R;

public class UpgradeButton extends FrameLayout {
    Button upgradeWeaponBtn;
    TextView upgradeWeaponPrice;
    TextView weaponLevel;

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
        upgradeWeaponBtn = (Button) findViewById(R.id.upgrade_weapon_btn);
        upgradeWeaponPrice = (TextView) findViewById(R.id.weapon_upgrade_price);
        weaponLevel = (TextView) findViewById(R.id.weapon_level);
    }
}
