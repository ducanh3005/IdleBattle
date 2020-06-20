package com.ballardsoftware.idlebattle.View;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.RestrictionEntry;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.Utilities.DatabaseHelper;
import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.View.CustomViews.HelpDialog;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class StatsFragment extends Fragment{


    TextView totalSinceReset;
    TextView lifetimeTotal;
    TextView dateStarted;
    TextView timesReset;
    TextView prestigeXP;

    public StatsFragment() {
        // Required empty public constructor
    }
/*
    public void createAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Are you sure?").setPositiveButton("Yes", (DialogInterface.OnClickListener) fullRestartListener).
                setNegativeButton("No", (DialogInterface.OnClickListener) fullRestartListener).show();
    }
*/
    private View.OnClickListener fullRestartListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //createAlertDialog();
            new AlertDialog.Builder(getContext())
                    .setTitle("Confirm Reset")
                    .setMessage("All Save Data Will Be Erased. Are You Sure?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            fullRestartFunction();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .show();


            /*DialogInterface.OnClickListener fullRestartListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    createAlertDialog();
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            fullRestartFunction();
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                    }
                    //fullRestartFunction();
                }
            };*/
        }
    };




    private View.OnClickListener prestigeRestartListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(Stats.getResetTotal().getValue() >= 10000000) {
                prestige();
            }
            else {
                notEnoughMoney();
            }
        }
    };

    private View.OnClickListener helpListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HelpDialog dialog = new HelpDialog();
            dialog.showDialog(getActivity());
        }
    };

    private View.OnTouchListener cheatListener = new View.OnTouchListener() {
        private Handler mHandler;
        int delay = 300;
        //boolean firstClick = true;
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (mHandler != null) return true;
                    mHandler = new Handler();
                    mHandler.postDelayed(mAction, 0);
                break;
                case MotionEvent.ACTION_UP:
                    if (mHandler == null) return true;
                    mHandler.removeCallbacks(mAction);
                    mHandler = null;
                    delay = 300;
                    //firstClick = true;
                    break;
            }
            return false;
        }

        Runnable mAction = new Runnable() {
            @Override
            public void run() {
                Stats.currentTotal.setValue(Stats.currentTotal.getValue()
                        + 10000000);
                Stats.resetTotal.setValue(Stats.getResetTotal().getValue()
                        + 10000000);
                Stats.lifetimeTotal.setValue(Stats.getLifetimeTotal().getValue()
                        + 10000000);
                //if (firstClick) {
                //    mHandler.postDelayed(this, 0);
                //}
                mHandler.postDelayed(this, delay);
                if (delay >= 0)
                {
                    delay -= 50;
                }
                //firstClick = false;
            }
        };
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stats_fragment, container,
                false);

        Button fullRestartButton = view.findViewById(R.id.full_restart_button);
        fullRestartButton.setOnClickListener(fullRestartListener);

        Button helpButton = view.findViewById(R.id.help_button);
        helpButton.setOnClickListener(helpListener);

        Button prestigeButton = view.findViewById(R.id.restart_button);
        prestigeButton.setOnClickListener(prestigeRestartListener);

        Button cheatButton = view.findViewById(R.id.cheat_button);
        cheatButton.setOnTouchListener(cheatListener);

        totalSinceReset = view.findViewById(R.id.total_since_reset);
        lifetimeTotal = view.findViewById(R.id.lifetime_total);
        dateStarted = view.findViewById(R.id.date_started);
        timesReset = view.findViewById(R.id.times_reset);
        prestigeXP = view.findViewById(R.id.prestigeXP);

        final Observer<Double> resetTotalObserver = new Observer<Double>() {
            @Override
            public void onChanged(@Nullable Double resetTotal) {
                String output = getString(R.string.totalSinceReset,
                        Stats.toString(resetTotal));
                totalSinceReset.setText(output);
            }
        };
        Stats.getResetTotal().observe(this, resetTotalObserver);

        final Observer<Double> lifetimeTotalObserver = new Observer<Double>() {
            @Override
            public void onChanged(@Nullable Double lifeTotal) {
                String output = getString(R.string.lifetimeTotal,
                        Stats.toString(lifeTotal));
                lifetimeTotal.setText(output);
            }
        };
        Stats.getLifetimeTotal().observe(this, lifetimeTotalObserver);

        String datePattern = "MMM-dd-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern,
                Locale.getDefault());
        String date = dateFormat.format(Stats.dateStarted);
        String startDate = getString(R.string.dateStarted,
                date);
        dateStarted.setText(startDate);

        String reset = getString(R.string.timesReset,
                Stats.toString(Stats.timesReset));
        timesReset.setText(reset);

        String xp = getString(R.string.prestigeXP,
                String.format(Locale.ENGLISH, "%.2f", Stats.prestigeXP));
                //Stats.toString(Stats.prestigeXP));
        prestigeXP.setText(xp);

        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void prestige() {
        DatabaseHelper dbh = DatabaseHelper.getInstance(getContext());
        final SQLiteDatabase db = getContext().openOrCreateDatabase(
                "IdleBattleDB.db", 0, null);

        //double prestigeBonus = Stats.prestigeXP + 0.25;
        double prestigeBonus;
        if (Stats.timesReset < 10)
        {
            prestigeBonus = Stats.prestigeXP * 1.5;
        }
        else if (Stats.timesReset < 20)
        {
            prestigeBonus = Stats.prestigeXP * 1.25;
        }
        else
        {
            prestigeBonus = Stats.prestigeXP * 1.1;
        }

        int resetNumber = Stats.timesReset+1;
        //Stats.timesReset++;

        dbh.initializeData(db, prestigeBonus,
                Stats.getLifetimeTotal().getValue(), resetNumber, 2);

        final PackageManager pm = getActivity().getPackageManager();
        final Intent intent = pm.getLaunchIntentForPackage(getActivity().getPackageName());
        getActivity().finishAffinity();
        getActivity().startActivity(intent);
        System.exit(0);
/*
        Stats.setCurrentTotal(0.0);
        Stats.setResetTotal(0.0);

        //timesReset = view.findViewById(R.id.times_reset);
        //prestigeXP = view.findViewById(R.id.prestigeXP);

        String reset = getString(R.string.timesReset,
                Stats.toString(Stats.timesReset));
        timesReset.setText(reset);

        String xp = getString(R.string.prestigeXP,
                String.format(Locale.ENGLISH, "%.2f", Stats.prestigeXP));
        //Stats.toString(Stats.prestigeXP));
        prestigeXP.setText(xp);

        //reset all purchases


        Intent intent = getContext().getPackageManager().getLaunchIntentForPackage(getContext().getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);


        Intent mStartActivity = new Intent(getContext(), MainActivity.class);
        int mPendingIntentId = 1234567;
        PendingIntent mPendingIntent = PendingIntent.getActivity(getContext(),
                mPendingIntentId, mStartActivity,
                PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager)getContext().getSystemService(
                Context.ALARM_SERVICE);
        mgr.setWindow(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                500, 2000, mPendingIntent);
        //AlarmManager mgr = set(2, 200, mPendingIntent);
        System.exit(0); //TODO exit??
*/
    }

    private void fullRestartFunction() {

        DatabaseHelper dbh = DatabaseHelper.getInstance(getContext());
        final SQLiteDatabase db = getContext().openOrCreateDatabase(
                "IdleBattleDB.db", 0, null);

        dbh.delete(db);
/*
        final String PREFS_NAME = "PrefsFile";

        SharedPreferences settings = getContext().getSharedPreferences(
                PREFS_NAME, 0);

        settings.edit().putBoolean("first_time_launched", true).apply();
*/
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("first_time_launched", true);
        editor.commit();

        final PackageManager pm = getActivity().getPackageManager();
        final Intent intent = pm.getLaunchIntentForPackage(getActivity().getPackageName());
        getActivity().finishAffinity();
        getActivity().startActivity(intent);
        System.exit(0);

/*

        Intent mStartActivity = new Intent(getContext(), MainActivity.class);
        int mPendingIntentId = 123456;
        PendingIntent mPendingIntent = PendingIntent.getActivity(getContext(),
                mPendingIntentId, mStartActivity,
                PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager)getContext().getSystemService(
                Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis()
                + 100, mPendingIntent);
        System.exit(0);
 */
    }

    Toast toast;
    private void notEnoughMoney() {

        if(toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getContext(),
                "Not Enough Total Since Reset", Toast.LENGTH_SHORT);
        toast.show();
    }
}
