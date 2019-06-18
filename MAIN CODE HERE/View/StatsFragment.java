package com.ballardsoftware.idlebattle.View;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.Utilities.DatabaseHelper;
import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.View.CustomViews.HelpDialog;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class StatsFragment extends Fragment{


    TextView totalSinceReset;
    TextView lifetimeTotal;
    TextView dateStarted;
    TextView timesReset;

    public StatsFragment() {
        // Required empty public constructor
    }


    private View.OnClickListener fullRestartListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fullRestartFunction();
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

    private View.OnClickListener cheatListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Stats.currentTotal.setValue(Stats.currentTotal.getValue()
                    + 10000000);
            Stats.resetTotal.setValue(Stats.getResetTotal().getValue()
                    + 10000000);
            Stats.lifetimeTotal.setValue(Stats.getLifetimeTotal().getValue()
                    + 10000000);
        }
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
        cheatButton.setOnClickListener(cheatListener);

        totalSinceReset = view.findViewById(R.id.total_since_reset);
        lifetimeTotal = view.findViewById(R.id.lifetime_total);
        dateStarted = view.findViewById(R.id.date_started);
        timesReset = view.findViewById(R.id.times_reset);

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

        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void prestige() {
        DatabaseHelper dbh = DatabaseHelper.getInstance(getContext());
        final SQLiteDatabase db = getContext().openOrCreateDatabase(
                "IdleBattleDB.db", 0, null);

        double prestigeBonus = Stats.prestigeXP + 0.25;
        int resetNumber = Stats.timesReset+1;

        dbh.initializeData(db, prestigeBonus,
                Stats.getLifetimeTotal().getValue(), resetNumber, 2);


        Intent mStartActivity = new Intent(getContext(), MainActivity.class);
        int mPendingIntentId = 1234567;
        PendingIntent mPendingIntent = PendingIntent.getActivity(getContext(),
                mPendingIntentId, mStartActivity,
                PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager)getContext().getSystemService(
                Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis()
                + 100, mPendingIntent);
        System.exit(0);
    }

    private void fullRestartFunction() {

        DatabaseHelper dbh = DatabaseHelper.getInstance(getContext());
        final SQLiteDatabase db = getContext().openOrCreateDatabase(
                "IdleBattleDB.db", 0, null);

        dbh.delete(db);

        final String PREFS_NAME = "PrefsFile";

        SharedPreferences settings = getContext().getSharedPreferences(
                PREFS_NAME, 0);

        settings.edit().putBoolean("first_time_launched", true).apply();

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
