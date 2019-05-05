package com.ballardsoftware.idlebattle.View;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ballardsoftware.idlebattle.Model.Weapon;
import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.View.CustomViews.GamersAndTeamsButton;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

import java.util.Locale;

public class GamersFragment extends Fragment
        implements View.OnClickListener{



    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

    public GamersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         //Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.gamers_fragment, container,
                false);

        GamersAndTeamsButton b1 = view.findViewById(R.id.gamer_upgrade_1);
        GamersAndTeamsButton b2 = view.findViewById(R.id.gamer_upgrade_2);
        GamersAndTeamsButton b3 = view.findViewById(R.id.gamer_upgrade_3);
        GamersAndTeamsButton b4 = view.findViewById(R.id.gamer_upgrade_4);
        GamersAndTeamsButton b5 = view.findViewById(R.id.gamer_upgrade_5);
        GamersAndTeamsButton b6 = view.findViewById(R.id.gamer_upgrade_6);
        GamersAndTeamsButton b7 = view.findViewById(R.id.gamer_upgrade_7);
        GamersAndTeamsButton b8 = view.findViewById(R.id.gamer_upgrade_8);
        GamersAndTeamsButton b9 = view.findViewById(R.id.gamer_upgrade_9);
        GamersAndTeamsButton b10 = view.findViewById(R.id.gamer_upgrade_10);

        Weapon [] weaponsArray1 = IdleViewModel.weaponsArray;

        b1.setName(weaponsArray1[0].getGamer().getName());
        b2.setName(weaponsArray1[1].getGamer().getName());
        b3.setName(weaponsArray1[2].getGamer().getName());
        b4.setName(weaponsArray1[3].getGamer().getName());
        b5.setName(weaponsArray1[4].getGamer().getName());
        b6.setName(weaponsArray1[5].getGamer().getName());
        b7.setName(weaponsArray1[6].getGamer().getName());
        b8.setName(weaponsArray1[7].getGamer().getName());
        b9.setName(weaponsArray1[8].getGamer().getName());
        b10.setName(weaponsArray1[9].getGamer().getName());


        /*
        b1.setName(getContext().getString(R.string.gamer1));
        b2.setName(getContext().getString(R.string.gamer2));
        b3.setName(getContext().getString(R.string.gamer3));
        b4.setName(getContext().getString(R.string.gamer4));
        b5.setName(getContext().getString(R.string.gamer5));
        b6.setName(getContext().getString(R.string.gamer6));
        b7.setName(getContext().getString(R.string.gamer7));
        b8.setName(getContext().getString(R.string.gamer8));
        b9.setName(getContext().getString(R.string.gamer9));
        b10.setName(getContext().getString(R.string.gamer10));
        */

        b1.setLevel(toString(weaponsArray1[0].getGamer().getLevel()));
        b2.setLevel(toString(weaponsArray1[1].getGamer().getLevel()));
        b3.setLevel(toString(weaponsArray1[2].getGamer().getLevel()));
        b4.setLevel(toString(weaponsArray1[3].getGamer().getLevel()));
        b5.setLevel(toString(weaponsArray1[4].getGamer().getLevel()));
        b6.setLevel(toString(weaponsArray1[5].getGamer().getLevel()));
        b7.setLevel(toString(weaponsArray1[6].getGamer().getLevel()));
        b8.setLevel(toString(weaponsArray1[7].getGamer().getLevel()));
        b9.setLevel(toString(weaponsArray1[8].getGamer().getLevel()));
        b10.setLevel(toString(weaponsArray1[9].getGamer().getLevel()));

        b1.setUpgradeCost(toString(
                weaponsArray1[0].getGamer().getUpgradeCost()));
        b2.setUpgradeCost(toString(
                weaponsArray1[1].getGamer().getUpgradeCost()));
        b3.setUpgradeCost(toString(
                weaponsArray1[2].getGamer().getUpgradeCost()));
        b4.setUpgradeCost(toString(
                weaponsArray1[3].getGamer().getUpgradeCost()));
        b5.setUpgradeCost(toString(
                weaponsArray1[4].getGamer().getUpgradeCost()));
        b6.setUpgradeCost(toString(
                weaponsArray1[5].getGamer().getUpgradeCost()));
        b7.setUpgradeCost(toString(
                weaponsArray1[6].getGamer().getUpgradeCost()));
        b8.setUpgradeCost(toString(
                weaponsArray1[7].getGamer().getUpgradeCost()));
        b9.setUpgradeCost(toString(
                weaponsArray1[8].getGamer().getUpgradeCost()));
        b10.setUpgradeCost(toString(
                weaponsArray1[9].getGamer().getUpgradeCost()));


        //b1.setOnClickListener(this);
        //b1.upgradeButton.setOnClickListener(this);
        //b1.getUpgradeButton().setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        //upgradeGamer();
    }


    public static void upgradeGamer(View v) {

        switch (v.getId()) {
            case R.id.gamer_upgrade_1:
                IdleViewModel.weaponsArray[0].getGamer().gamerUpgrade();
                GamersAndTeamsButton b1 =
                        v.findViewById(R.id.gamer_upgrade_1);
                if(IdleViewModel.weaponsArray[0].getGamer().getLevel() == 10) {
                    b1.setUpgradeCost("Max");
                }
                else
                b1.setUpgradeCost(toString(IdleViewModel.weaponsArray[0].
                        getGamer().getUpgradeCost()));
                b1.setLevel(toString(IdleViewModel.weaponsArray[0].
                        getGamer().getLevel()));
                break;
            case R.id.gamer_upgrade_2:
                break;
            case R.id.gamer_upgrade_3:
                break;
            case R.id.gamer_upgrade_4:
                break;
            case R.id.gamer_upgrade_5:
                break;
            case R.id.gamer_upgrade_6:
                break;
            case R.id.gamer_upgrade_7:
                break;
            case R.id.gamer_upgrade_8:
                break;
            case R.id.gamer_upgrade_9:
                break;
            case R.id.gamer_upgrade_10:
                break;

        }
    }

    private static String toString(int num) {
        return String.format(Locale.getDefault(),
                "%s", "Lvl " + num);
    }

    private static String toString(double num) {
        return String.format(Locale.getDefault(),
                "%.0f", num);
    }

}
