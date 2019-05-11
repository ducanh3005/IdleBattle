package com.ballardsoftware.idlebattle.View;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.Utilities.Stats;

public class ThemesFragment extends Fragment {


    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

    public ThemesFragment() {
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
        final View view = inflater.inflate(R.layout.themes_fragment, container,
                false);



        Button b1 = view.findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stats.currentTotal.setValue(Stats.currentTotal.getValue() + 1000000000);
                //ViewUtils Utils.changeToTheme(this, Utils.DarkRed);
            }
        });
        return view;
    }



}

