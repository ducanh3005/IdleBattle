package com.ballardsoftware.idlebattle.View;

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
        System.out.println("progress");
        if (progressBar.getProgress() == 0)
        {
            //progressBar.setProgress(2000);
            //progressBar.animate();
            startCountdownTimer();
            //IdleViewModel.startProgressBar();
        }
        else displayToast();
        progressBar.setProgress(0);
    }

    Toast toast;
    public void displayToast() {
        if(toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getContext(), "Already Running", Toast.LENGTH_SHORT);
        toast.show();
    }
    int count = 100;

    private void startCountdownTimer() {
        //ProgressBarButton m_button = (ProgressBarButton)findViewById(R.id.progress_bar_1);
        //final ProgressBar m_bar = m_button.progressBar;

        final ProgressBar m_bar = progressBar;
        final TextView t = progressText;
        final TextView r = weaponIncome;

        //m_bar.setMax(10000);
        m_bar.setMax(maxTime()[0]);
        int m_total = 0;

        m_bar.setProgress(m_total);

        //final int totalMsecs = 10 * 1000 + 200;
        int callInterval = 100;


        new CountDownTimer(maxTime()[0], callInterval) {
            public void onTick(long millisUntilFinished) {
                //int secondsRemainging = (int) millisUntilFinished / 1000;
                //float fraction = millisUntilFinished / (float) totalMsecs;
                float fraction = maxTime()[0] - millisUntilFinished;
                //m_bar.setProgress((int) (fraction * 100));
                //m_bar.setProgress((int) (100000 - millisUntilFinished));
                m_bar.setProgress(count+=100);
                //t.setText(Integer.toString(count));
                //setProgressText("one");

            }

            public void onFinish() {
                m_bar.setProgress(0);
                count = 100;
                //t.setText("Fist");
                //count = 0;
                //Log.d(TAG, ">>>>>>>>countdowntimer on finish");
                //t.setText(IdleViewModel.progressFinished(100));
                IdleViewModel.progressFinished(maxTime()[1]);
                //t.setText(String.format(Locale.getDefault(), "%.0f",
                        //Stats.getCurrentTotal()));

            }
        }.start();
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

}
