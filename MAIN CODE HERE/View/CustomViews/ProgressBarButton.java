package com.ballardsoftware.idlebattle.View.CustomViews;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ballardsoftware.idlebattle.Model.Weapon;
import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

public class ProgressBarButton extends FrameLayout
        implements View.OnClickListener {

    ProgressBar progressBar;
    TextView weaponName;
    TextView weaponIncome;


    public ProgressBarButton(Context context) {
        super(context);
    }
    public ProgressBarButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public ProgressBarButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.progress_bar_button, this);

        initComponents();
    }

    private void initComponents() {
        progressBar = findViewById(R.id.progress_bar);
        weaponName = findViewById(R.id.weapon_name);
        weaponIncome = findViewById(R.id.weapon_income);

        progressBar.setOnClickListener(this);
    }
    public void setProgressText(CharSequence text) {
        weaponName.setText(text);
    }
    public void setWeaponIncome(CharSequence text) {
        weaponIncome.setText(text);
    }





    @Override
    public void onClick(View v) {
        if (progressBar.getProgress() == 0)
        {
            Weapon weapon = getWeapon(getId());
            if(weapon.getLevel() > 0) {
                startCountdownTimer(weapon);
            }
            else displayPurchaseToast();

        }
        else displayToast();
    }

    private Weapon getWeapon(int id) {

        switch (id) {
            case R.id.progress_bar_1:
                return IdleViewModel.weaponsArray[0];
            case R.id.progress_bar_2:
                return IdleViewModel.weaponsArray[1];
            case R.id.progress_bar_3:
                return IdleViewModel.weaponsArray[2];
            case R.id.progress_bar_4:
                return IdleViewModel.weaponsArray[3];
            case R.id.progress_bar_5:
                return IdleViewModel.weaponsArray[4];
            case R.id.progress_bar_6:
                return IdleViewModel.weaponsArray[5];
            case R.id.progress_bar_7:
                return IdleViewModel.weaponsArray[6];
            case R.id.progress_bar_8:
                return IdleViewModel.weaponsArray[7];
            case R.id.progress_bar_9:
                return IdleViewModel.weaponsArray[8];
            case R.id.progress_bar_10:
                return IdleViewModel.weaponsArray[9];
        }
        return null;
    }

    Toast toast;
    public void displayToast() {
        if(toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getContext(), "Already Running",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void displayPurchaseToast() {
        if(toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getContext(), "Purchase At Least One "
                + "Upgrade", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void startCountdownTimer(final Weapon weapon) {
        progressBar.setMax(weapon.getBaseTime());
        progressBar.setProgress(0);

        int callInterval = 100;
        weapon.setCurrentTime(100);

        new CountDownTimer(weapon.getBaseTime(), callInterval) {
            public void onTick(long millisUntilFinished) {
                weapon.setCurrentTime(weapon.getCurrentTime() + 100);
                progressBar.setProgress(weapon.getCurrentTime());

            }

            public void onFinish() {
                progressBar.setProgress(0);
                weapon.setCurrentTime(0);
                IdleViewModel.progressFinished(weapon.getWeaponNumber());


                if(progressBar.getProgress() == 0 &&
                weapon.getGamer().getLevel() > 0) {
                    autoClicker(weapon);
                }



            }
        }.start();
    }

    //set progressBar for when returning to the game
    public void setReturnProgress(final Weapon weapon) {

        if(weapon.getCurrentTime() > 0 || weapon.getGamer().getLevel() > 0) {
            progressBar.setMax(weapon.getBaseTime());
            progressBar.setProgress(weapon.getCurrentTime());

            int callInterval = 100;

            new CountDownTimer(weapon.getBaseTime()
                    - weapon.getCurrentTime(), callInterval) {

                public void onTick(long millisUntilFinished) {
                    weapon.setCurrentTime(weapon.getCurrentTime() + 100);
                    if(weapon.getCurrentTime() >= 0) {
                        progressBar.setProgress(weapon.getCurrentTime());
                    }

                }

                public void onFinish() {
                    progressBar.setProgress(0);
                    weapon.setCurrentTime(0);
                    IdleViewModel.progressFinished(weapon.getWeaponNumber());

                    if(progressBar.getProgress() == 0 &&
                            weapon.getGamer().getLevel() > 0) {
                        autoClicker(weapon);
                    }
                }
            }.start();
        }

    }


    public void autoClicker(final Weapon weapon) {
        int time = weapon.getGamer().getTime();
        final int level = weapon.getGamer().getLevel();

        CountDownTimer timer = new CountDownTimer(time, 1) {
            public void onTick(long millisUntilFinished) {

                if(progressBar.getProgress() != 0) {
                    cancel();
                }
            }

            public void onFinish() {
                if(progressBar.getProgress() == 0 && level > 0) {
                    startCountdownTimer(weapon);
                }
            }
        };
            if (progressBar.getProgress() == 0) {
                timer.start();
            }
    }
}
