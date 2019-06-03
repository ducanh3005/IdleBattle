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

public class TeamsFragment extends Fragment{

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

    public TeamsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.teams_fragment, container,
                false);

        GamersAndTeamsButton b1 = view.findViewById(R.id.team_upgrade_1);
        GamersAndTeamsButton b2 = view.findViewById(R.id.team_upgrade_2);
        GamersAndTeamsButton b3 = view.findViewById(R.id.team_upgrade_3);
        GamersAndTeamsButton b4 = view.findViewById(R.id.team_upgrade_4);
        GamersAndTeamsButton b5 = view.findViewById(R.id.team_upgrade_5);
        GamersAndTeamsButton b6 = view.findViewById(R.id.team_upgrade_6);
        GamersAndTeamsButton b7 = view.findViewById(R.id.team_upgrade_7);
        GamersAndTeamsButton b8 = view.findViewById(R.id.team_upgrade_8);
        GamersAndTeamsButton b9 = view.findViewById(R.id.team_upgrade_9);
        GamersAndTeamsButton b10 = view.findViewById(R.id.team_upgrade_10);

        Weapon[] weaponsArray1 = IdleViewModel.weaponsArray;

        b1.setName(weaponsArray1[0].getTeam().getName());
        b2.setName(weaponsArray1[1].getTeam().getName());
        b3.setName(weaponsArray1[2].getTeam().getName());
        b4.setName(weaponsArray1[3].getTeam().getName());
        b5.setName(weaponsArray1[4].getTeam().getName());
        b6.setName(weaponsArray1[5].getTeam().getName());
        b7.setName(weaponsArray1[6].getTeam().getName());
        b8.setName(weaponsArray1[7].getTeam().getName());
        b9.setName(weaponsArray1[8].getTeam().getName());
        b10.setName(weaponsArray1[9].getTeam().getName());

        b1.setLevel(Stats.toStringLevel(weaponsArray1[0].getTeam().getLevel()));
        b2.setLevel(Stats.toStringLevel(weaponsArray1[1].getTeam().getLevel()));
        b3.setLevel(Stats.toStringLevel(weaponsArray1[2].getTeam().getLevel()));
        b4.setLevel(Stats.toStringLevel(weaponsArray1[3].getTeam().getLevel()));
        b5.setLevel(Stats.toStringLevel(weaponsArray1[4].getTeam().getLevel()));
        b6.setLevel(Stats.toStringLevel(weaponsArray1[5].getTeam().getLevel()));
        b7.setLevel(Stats.toStringLevel(weaponsArray1[6].getTeam().getLevel()));
        b8.setLevel(Stats.toStringLevel(weaponsArray1[7].getTeam().getLevel()));
        b9.setLevel(Stats.toStringLevel(weaponsArray1[8].getTeam().getLevel()));
        b10.setLevel(Stats.toStringLevel(weaponsArray1[9].getTeam().getLevel()));

        b1.setUpgradeCost(Stats.toString(
                weaponsArray1[0].getTeam().getUpgradeCost()));
        b2.setUpgradeCost(Stats.toString(
                weaponsArray1[1].getTeam().getUpgradeCost()));
        b3.setUpgradeCost(Stats.toString(
                weaponsArray1[2].getTeam().getUpgradeCost()));
        b4.setUpgradeCost(Stats.toString(
                weaponsArray1[3].getTeam().getUpgradeCost()));
        b5.setUpgradeCost(Stats.toString(
                weaponsArray1[4].getTeam().getUpgradeCost()));
        b6.setUpgradeCost(Stats.toString(
                weaponsArray1[5].getTeam().getUpgradeCost()));
        b7.setUpgradeCost(Stats.toString(
                weaponsArray1[6].getTeam().getUpgradeCost()));
        b8.setUpgradeCost(Stats.toString(
                weaponsArray1[7].getTeam().getUpgradeCost()));
        b9.setUpgradeCost(Stats.toString(
                weaponsArray1[8].getTeam().getUpgradeCost()));
        b10.setUpgradeCost(Stats.toString(
                weaponsArray1[9].getTeam().getUpgradeCost()));


        return view;
    }

}
