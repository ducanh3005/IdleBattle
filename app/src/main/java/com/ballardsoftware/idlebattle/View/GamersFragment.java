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
import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.View.CustomViews.GamersAndTeamsButton;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

public class GamersFragment extends Fragment{



    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
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


        b1.setLevel(Stats.toStringLevel(
                weaponsArray1[0].getGamer().getLevel()));
        b2.setLevel(Stats.toStringLevel(
                weaponsArray1[1].getGamer().getLevel()));
        b3.setLevel(Stats.toStringLevel(
                weaponsArray1[2].getGamer().getLevel()));
        b4.setLevel(Stats.toStringLevel(
                weaponsArray1[3].getGamer().getLevel()));
        b5.setLevel(Stats.toStringLevel(
                weaponsArray1[4].getGamer().getLevel()));
        b6.setLevel(Stats.toStringLevel(
                weaponsArray1[5].getGamer().getLevel()));
        b7.setLevel(Stats.toStringLevel(
                weaponsArray1[6].getGamer().getLevel()));
        b8.setLevel(Stats.toStringLevel(
                weaponsArray1[7].getGamer().getLevel()));
        b9.setLevel(Stats.toStringLevel(
                weaponsArray1[8].getGamer().getLevel()));
        b10.setLevel(Stats.toStringLevel(
                weaponsArray1[9].getGamer().getLevel()));

        b1.setUpgradeCost(Stats.toString(
                weaponsArray1[0].getGamer().getUpgradeCost()));
        b2.setUpgradeCost(Stats.toString(
                weaponsArray1[1].getGamer().getUpgradeCost()));
        b3.setUpgradeCost(Stats.toString(
                weaponsArray1[2].getGamer().getUpgradeCost()));
        b4.setUpgradeCost(Stats.toString(
                weaponsArray1[3].getGamer().getUpgradeCost()));
        b5.setUpgradeCost(Stats.toString(
                weaponsArray1[4].getGamer().getUpgradeCost()));
        b6.setUpgradeCost(Stats.toString(
                weaponsArray1[5].getGamer().getUpgradeCost()));
        b7.setUpgradeCost(Stats.toString(
                weaponsArray1[6].getGamer().getUpgradeCost()));
        b8.setUpgradeCost(Stats.toString(
                weaponsArray1[7].getGamer().getUpgradeCost()));
        b9.setUpgradeCost(Stats.toString(
                weaponsArray1[8].getGamer().getUpgradeCost()));
        b10.setUpgradeCost(Stats.toString(
                weaponsArray1[9].getGamer().getUpgradeCost()));

        return view;
    }

}
