package com.ballardsoftware.idlebattle.View.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.support.annotation.StyleableRes;
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

    @StyleableRes
            int index0 = 0;
    @StyleableRes
            int index1 = 1;

    ProgressBar progressBar;
    TextView progressText;
    TextView weaponIncome;

    //final ProgressBar m_bar
    Context context;

    public ProgressBarButton(Context context) {
        super(context);
    }
    public ProgressBarButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }
    public ProgressBarButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.progress_bar_button, this);

        int[] sets = {R.attr.progressBar, R.attr.progressText,
                        R.attr.weaponIncome};

        TypedArray typedArray = context.obtainStyledAttributes(attrs, sets);

        CharSequence progress = typedArray.getText(index0);
        CharSequence income = typedArray.getText(index1);

        typedArray.recycle();

        initComponents();
    }

    private void initComponents() {
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressText = (TextView) findViewById(R.id.progress_text);
        weaponIncome = (TextView) findViewById(R.id.weapon_income);

        progressBar.setOnClickListener(this);
    }
    /*
    public int getProgressBar() {
        return progressBar.getProgress();
    }
    */
    public CharSequence getProgressText() {
        return progressText.getText();
    }

    public void setProgressText(CharSequence text) {
        progressText.setText(text);
    }

    public CharSequence getWeaponIncome() {
        return weaponIncome.getText();
    }

    public void setWeaponIncome(CharSequence text) {
        weaponIncome.setText(text);
    }





    @Override
    public void onClick(View v) {
        if (progressBar.getProgress() == 0)
        {
            //progressBar.setProgress(2000);
            //progressBar.animate();
            Weapon weapon = getWeapon(getId());
            if(weapon.getLevel() > 0) {
                startCountdownTimer(weapon);
            }
            else displayPurchaseToast();

            //IdleViewModel.startProgressBar();
        }
        else displayToast();
        //progressBar.setProgress(0);
    }

    private Weapon getWeapon(int id) {
        //Weapon weapon;

        switch (id) {
            case R.id.progress_bar_1:
                return IdleViewModel.weaponsArray[0];
                //break;
            case R.id.progress_bar_2:
                return IdleViewModel.weaponsArray[1];
                //break;
            case R.id.progress_bar_3:
                return IdleViewModel.weaponsArray[2];
                //break;
            case R.id.progress_bar_4:
                return IdleViewModel.weaponsArray[3];
            //break;
            case R.id.progress_bar_5:
                return IdleViewModel.weaponsArray[4];
            //break;
            case R.id.progress_bar_6:
                return IdleViewModel.weaponsArray[5];
            //break;
            case R.id.progress_bar_7:
                return IdleViewModel.weaponsArray[6];
            //break;
            case R.id.progress_bar_8:
                return IdleViewModel.weaponsArray[7];
            //break;
            case R.id.progress_bar_9:
                return IdleViewModel.weaponsArray[8];
            //break;
            case R.id.progress_bar_10:
                return IdleViewModel.weaponsArray[9];
            //break;
        }
        return null;
    }

    Toast toast;
    public void displayToast() {
        if(toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getContext(), "Already Running", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void displayPurchaseToast() {
        if(toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getContext(), "Purchase At Least One Upgrade", Toast.LENGTH_SHORT);
        toast.show();
    }




    int count = 100;

    private void startCountdownTimer(final Weapon weapon) {
        //ProgressBarButton m_button = (ProgressBarButton)findViewById(R.id.progress_bar_1);
        //final ProgressBar m_bar = m_button.progressBar;

        //final ProgressBar m_bar = progressBar;
        //final TextView t = progressText;
        //final TextView r = weaponIncome;

        //m_bar.setMax(10000);
        progressBar.setMax(weapon.getBaseTime());
        //int m_total = 0;

        //m_bar
        progressBar.setProgress(0);

        //final int totalMsecs = 10 * 1000 + 200;
        int callInterval = 100;
        weapon.setCurrentTime(100);

        new CountDownTimer(weapon.getBaseTime(), callInterval) {
            public void onTick(long millisUntilFinished) {
                //int secondsRemainging = (int) millisUntilFinished / 1000;
                //float fraction = millisUntilFinished / (float) totalMsecs;
                //float fraction = maxTime()[0] - millisUntilFinished;
                //m_bar.setProgress((int) (fraction * 100));
                //m_bar.setProgress((int) (100000 - millisUntilFinished));
                //progressBar.setProgress(count+=100);
                weapon.setCurrentTime(weapon.getCurrentTime() + 100);
                progressBar.setProgress(weapon.getCurrentTime());
                //System.out.println(progressBar.getProgress());
                //System.out.println(view.id);
                //t.setText(Integer.toString(count));
                //setProgressText("one");

            }

            public void onFinish() {
                progressBar.setProgress(0);
                weapon.setCurrentTime(0);
                //count = 100;//
                //t.setText("Fist");
                //count = 0;
                //Log.d(TAG, ">>>>>>>>countdowntimer on finish");
                //t.setText(IdleViewModel.progressFinished(100));
                IdleViewModel.progressFinished(getWeaponNumber(weapon));
                //t.setText(String.format(Locale.getDefault(), "%.0f",
                        //Stats.getCurrentTotal()));


                //todo:
                // 1. click after autoClicker starts.
                // 2. progressbar finishes
                // 3. autoclicker finishes
                // appears to click early

                if(progressBar.getProgress() == 0 &&
                weapon.getGamer().getLevel() > 0) {
                    autoClicker(weapon);
                }
                //autoClicker(1, 100);



            }
        }.start();
    }

    //set progressBar for when returning to the game
    public void setReturnProgress(final Weapon weapon) {

        if(weapon.getCurrentTime() > 0 || weapon.getGamer().getLevel() > 0) {
            //System.out.println(weapon.getName() + " Progress Time: " + weapon.getCurrentTime());
            //System.out.println(weapon.getName() + " name");
            progressBar.setMax(weapon.getBaseTime());
            //System.out.println(weapon.getName() + " max time: " + weapon.getBaseTime());
            progressBar.setProgress(weapon.getCurrentTime());
            //System.out.println("Progress: " + weapon.getCurrentTime());

            int callInterval = 100;
            //weapon.setCurrentTime(weapon.getCurrentTime() + 100);

            new CountDownTimer(weapon.getBaseTime() - weapon.getCurrentTime(), callInterval) {
                public void onTick(long millisUntilFinished) {
                    weapon.setCurrentTime(weapon.getCurrentTime() + 100);
                    if(weapon.getCurrentTime() >= 0) {
                        progressBar.setProgress(weapon.getCurrentTime());
                    }

                    //System.out.println(weapon.getName() + " current progress: " + weapon.getCurrentTime());
                }

                public void onFinish() {
                    progressBar.setProgress(0);
                    //count = 100;
                    weapon.setCurrentTime(0);
                    IdleViewModel.progressFinished(getWeaponNumber(weapon));

                    if(progressBar.getProgress() == 0 &&
                            weapon.getGamer().getLevel() > 0) {
                        autoClicker(weapon);
                    }
                }
            }.start();
        }

    }

    //todo: make better way to do this
    private static int getWeaponNumber(Weapon weapon) {
        switch (weapon.getName()) {
            case "Fist":
                return 0;
            case "Super Punch Gloves":
                return 1;
            case "Combat Knife":
                return 2;
            case "Target Pistol":
                return 3;
            case "Quail Shotgun":
                return 4;
            case "Q18 Automatic":
                return 5;
            case "Military Rifle":
                return 6;
            case "Grenade Thrower":
                return 7;
            case "Missile Stick":
                return 8;
            case "Big Laser Alien Gun":
                return 9;
        }
        return 10;
    }


    //todo change name and fix?
    private int[] maxTime(){
        int maxTime = 0;
        int weaponNumber = 0;
        switch (getId()) {
            case R.id.progress_bar_1:
                maxTime = 2000; //2s
                weaponNumber = 0;
                break;
            case R.id.progress_bar_2:
                maxTime = 4000; //4s
                weaponNumber = 1;
                break;
            case R.id.progress_bar_3:
                maxTime = 10000; //10s
                weaponNumber = 2;
                break;
            case R.id.progress_bar_4:
                maxTime = 20000; //20s
                weaponNumber = 3;
                break;
            case R.id.progress_bar_5:
                maxTime = 50000; //50s
                weaponNumber = 4;
                break;
            case R.id.progress_bar_6:
                maxTime = 120000; //2m
                weaponNumber = 5;
                break;
            case R.id.progress_bar_7:
                maxTime = 240000; //4m
                weaponNumber = 6;
                break;
            case R.id.progress_bar_8:
                maxTime = 480000; //8m
                weaponNumber = 7;
                break;
            case R.id.progress_bar_9:
                maxTime = 780000; //13m
                weaponNumber = 8;
                break;
            case R.id.progress_bar_10:
                maxTime = 1200000; //20m
                weaponNumber = 9;
                break;
        }
        int[] values = {maxTime, weaponNumber};
        return values;
    }

    //todo: put autoClicker in Weapon class?
    //public void autoClicker(int level, int time) {
    //int time = 1000;
    //int level = 0;
    //Weapon weapon;

    public void autoClicker(final Weapon weapon) {
        int time = weapon.getGamer().getTime();
        final int level = weapon.getGamer().getLevel();
        //this.weapon = weapon;

        CountDownTimer timer = new CountDownTimer(time, 1) {
            public void onTick(long millisUntilFinished) {

                //System.out.println("one");
                if(progressBar.getProgress() != 0) {
                    //return;
                    //onFinish();
                    cancel();
                }
            }

            public void onFinish() {
                //System.out.println("done");
                if(progressBar.getProgress() == 0 && level > 0) {
                    startCountdownTimer(weapon);
                }

            }
        };

        //timer.start();


        //if (level > 0) {
            if (progressBar.getProgress() == 0) {

                /*        new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startCountdownTimer();
                    }
                }, time);
            }
        }*/
                timer.start();
            }

        //}
    }


}
