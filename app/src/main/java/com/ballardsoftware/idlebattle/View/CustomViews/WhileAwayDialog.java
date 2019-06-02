package com.ballardsoftware.idlebattle.View.CustomViews;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.Utilities.Stats;

public class WhileAwayDialog {


    public void showDialog(Activity activity, double value, long time) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.while_away_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView moneyEarned = dialog.findViewById(R.id.moneyEarned);
        moneyEarned.setText(Stats.toString(value));
        TextView timeAway = dialog.findViewById(R.id.timeAway);
        timeAway.setText(timeString(time));
        TextView doubleMoney = dialog.findViewById(R.id.messageDouble);
        String doubleM = activity.getString(R.string.doubleMoney,
                Stats.toString(value *2));
        doubleMoney.setText(doubleM);

        AppCompatButton adButton = dialog.findViewById(R.id.adButton);
        adButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Cancel" ,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        AppCompatButton okButton = dialog.findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Okay" ,Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        dialog.show();
    }

    private String timeString(long time) {
        long seconds = time / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        return days + ":" + hours % 24 + ":" + minutes % 60
                + ":" + seconds % 60;
    }

}
