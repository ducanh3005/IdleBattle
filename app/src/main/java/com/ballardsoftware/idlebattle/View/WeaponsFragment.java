package com.ballardsoftware.idlebattle.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ballardsoftware.idlebattle.Model.Weapon;
import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

public class WeaponsFragment extends Fragment {

    private IdleViewModel model;

    public WeaponsFragment() {
        // Required empty public constructor
    }

    //public TextView output;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        //TextView textView = (TextView) findViewById(R.id.output);

        //model = ViewModelProviders.of(this).get(IdleViewModel.class);

        final Observer<String> totalObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String total) {
                output.setText(total);
            }
        };

        model.getCurrentTotal().observe(this, totalObserver);
*/

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.weapons_fragment, container,
                false);
        // Inflate the layout for this fragment

        final TextView output1 = view.findViewById(R.id.output);

        model = ViewModelProviders.of(this).get(IdleViewModel.class);


        final Observer<String> totalObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                output1.setText(s);
            }
        };







        model.getCurrentTotal().observe(this, totalObserver);


        final ProgressBarButton p1 = view.findViewById(R.id.progress_bar_1);
        ProgressBarButton p2 = view.findViewById(R.id.progress_bar_2);
        ProgressBarButton p3 = view.findViewById(R.id.progress_bar_3);
        ProgressBarButton p4 = view.findViewById(R.id.progress_bar_4);
        ProgressBarButton p5 = view.findViewById(R.id.progress_bar_5);
        ProgressBarButton p6 = view.findViewById(R.id.progress_bar_6);
        ProgressBarButton p7 = view.findViewById(R.id.progress_bar_7);
        ProgressBarButton p8 = view.findViewById(R.id.progress_bar_8);
        ProgressBarButton p9 = view.findViewById(R.id.progress_bar_9);
        ProgressBarButton p10 = view.findViewById(R.id.progress_bar_10);


        p1.progressText.setText(R.string.weapon1);
        p2.progressText.setText(R.string.weapon2);
        p3.progressText.setText(R.string.weapon3);
        p4.progressText.setText(R.string.weapon4);
        p5.progressText.setText(R.string.weapon5);
        p6.progressText.setText(R.string.weapon6);
        p7.progressText.setText(R.string.weapon7);
        p8.progressText.setText(R.string.weapon8);
        p9.progressText.setText(R.string.weapon9);
        p10.progressText.setText(R.string.weapon10);

        //p1.weaponIncome.setText("one");
        //p1.setWeaponIncome("one");


        //todo handle income change for each weapon
        final Observer<String> incomeObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                p1.setWeaponIncome(s);
            }
        };

        Weapon.getIncomeNumber().observe(this, incomeObserver);


        UpgradeButton b1 = view.findViewById(R.id.upgrade_weapon_btn_1);

        b1.upgradeWeaponBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = "2";
                model.getCurrentTotal().setValue(one);
                System.out.println(one);
            }
        });

        //progress1 = view.findViewById(R.id.upgrade_weapon_btn_1);
        //progress1.setText("10");
        //progress1.setOnClickListener(this);
        return view;
    }



}
