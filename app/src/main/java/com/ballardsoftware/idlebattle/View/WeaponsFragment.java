package com.ballardsoftware.idlebattle.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ballardsoftware.idlebattle.Model.Weapon;
import com.ballardsoftware.idlebattle.R;
import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.View.CustomViews.ProgressBarButton;
import com.ballardsoftware.idlebattle.View.CustomViews.UpgradeButton;
import com.ballardsoftware.idlebattle.View.CustomViews.WhileAwayDialog;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.ballardsoftware.idlebattle.ViewModel.IdleViewModel.weaponsArray;

public class WeaponsFragment extends Fragment {

    private IdleViewModel model;

    RadioButton buyOne;
    RadioButton buyTen;
    RadioButton buyOneHundred;
    //RadioButton buyMax;

    UpgradeButton u1;
    UpgradeButton u2;
    UpgradeButton u3;
    UpgradeButton u4;
    UpgradeButton u5;
    UpgradeButton u6;
    UpgradeButton u7;
    UpgradeButton u8;
    UpgradeButton u9;
    UpgradeButton u10;



    public WeaponsFragment() {
        // Required empty public constructor
    }

    //public TextView output;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        TextView textView = (TextView) findViewById(R.id.output);

        //model = ViewModelProviders.of(this).get(IdleViewModel.class);

        final Observer<String> totalObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String total) {
                output.setText(total);
            }
        };

        model.getCurrentTotal().observe(this, totalObserver);
*/

        //IdleViewModel.startGame();



    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {


        //final View view...
        final View view = inflater.inflate(R.layout.weapons_fragment, container,
                false);
        // Inflate the layout for this fragment


        //initialize Weapon incomes


        //IdleViewModel.startGame();

        //final TextView output1 = view.findViewById(R.id.output);

        //model = ViewModelProviders.of(this).get(IdleViewModel.class);




        //TextView income1 = view.findViewById(R.id.progress_bar_1);
        ProgressBarButton p1 = view.findViewById(R.id.progress_bar_1);
        ProgressBarButton p2 = view.findViewById(R.id.progress_bar_2);
        ProgressBarButton p3 = view.findViewById(R.id.progress_bar_3);
        ProgressBarButton p4 = view.findViewById(R.id.progress_bar_4);
        ProgressBarButton p5 = view.findViewById(R.id.progress_bar_5);
        ProgressBarButton p6 = view.findViewById(R.id.progress_bar_6);
        ProgressBarButton p7 = view.findViewById(R.id.progress_bar_7);
        ProgressBarButton p8 = view.findViewById(R.id.progress_bar_8);
        ProgressBarButton p9 = view.findViewById(R.id.progress_bar_9);
        ProgressBarButton p10 = view.findViewById(R.id.progress_bar_10);



        p1.setWeaponIncome(Stats.toString(weaponsArray[0].getCurrentIncome()));
        p2.setWeaponIncome(Stats.toString(weaponsArray[1].getCurrentIncome()));
        p3.setWeaponIncome(Stats.toString(weaponsArray[2].getCurrentIncome()));
        p4.setWeaponIncome(Stats.toString(weaponsArray[3].getCurrentIncome()));
        p5.setWeaponIncome(Stats.toString(weaponsArray[4].getCurrentIncome()));
        p6.setWeaponIncome(Stats.toString(weaponsArray[5].getCurrentIncome()));
        p7.setWeaponIncome(Stats.toString(weaponsArray[6].getCurrentIncome()));
        p8.setWeaponIncome(Stats.toString(weaponsArray[7].getCurrentIncome()));
        p9.setWeaponIncome(Stats.toString(weaponsArray[8].getCurrentIncome()));
        p10.setWeaponIncome(Stats.toString(weaponsArray[9].getCurrentIncome()));

        /*
        p1.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[0].getCurrentIncome()));
        p2.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[1].getCurrentIncome()));
        p3.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[2].getCurrentIncome()));
        p4.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[3].getCurrentIncome()));
        p5.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[4].getCurrentIncome()));
        p6.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[5].getCurrentIncome()));
        p7.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[6].getCurrentIncome()));
        p8.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[7].getCurrentIncome()));
        p9.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[8].getCurrentIncome()));
        p10.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[9].getCurrentIncome()));
*/
        /*
        final UpgradeButton u1 = view.findViewById(R.id.upgrade_weapon_btn_1);
        UpgradeButton u2 = view.findViewById(R.id.upgrade_weapon_btn_2);
        UpgradeButton u3 = view.findViewById(R.id.upgrade_weapon_btn_3);
        UpgradeButton u4 = view.findViewById(R.id.upgrade_weapon_btn_4);
        UpgradeButton u5 = view.findViewById(R.id.upgrade_weapon_btn_5);
        UpgradeButton u6 = view.findViewById(R.id.upgrade_weapon_btn_6);
        UpgradeButton u7 = view.findViewById(R.id.upgrade_weapon_btn_7);
        UpgradeButton u8 = view.findViewById(R.id.upgrade_weapon_btn_8);
        UpgradeButton u9 = view.findViewById(R.id.upgrade_weapon_btn_9);
        UpgradeButton u10 = view.findViewById(R.id.upgrade_weapon_btn_10);
*/
        u1 = view.findViewById(R.id.upgrade_weapon_btn_1);
        u2 = view.findViewById(R.id.upgrade_weapon_btn_2);
        u3 = view.findViewById(R.id.upgrade_weapon_btn_3);
        u4 = view.findViewById(R.id.upgrade_weapon_btn_4);
        u5 = view.findViewById(R.id.upgrade_weapon_btn_5);
        u6 = view.findViewById(R.id.upgrade_weapon_btn_6);
        u7 = view.findViewById(R.id.upgrade_weapon_btn_7);
        u8 = view.findViewById(R.id.upgrade_weapon_btn_8);
        u9 = view.findViewById(R.id.upgrade_weapon_btn_9);
        u10 = view.findViewById(R.id.upgrade_weapon_btn_10);


        u1.setUpgradeWeaponPrice(Stats.toString(weaponsArray[0].getCurrentUpgradeCost()));
        u2.setUpgradeWeaponPrice(Stats.toString(weaponsArray[1].getCurrentUpgradeCost()));
        u3.setUpgradeWeaponPrice(Stats.toString(weaponsArray[2].getCurrentUpgradeCost()));
        u4.setUpgradeWeaponPrice(Stats.toString(weaponsArray[3].getCurrentUpgradeCost()));
        u5.setUpgradeWeaponPrice(Stats.toString(weaponsArray[4].getCurrentUpgradeCost()));
        u6.setUpgradeWeaponPrice(Stats.toString(weaponsArray[5].getCurrentUpgradeCost()));
        u7.setUpgradeWeaponPrice(Stats.toString(weaponsArray[6].getCurrentUpgradeCost()));
        u8.setUpgradeWeaponPrice(Stats.toString(weaponsArray[7].getCurrentUpgradeCost()));
        u9.setUpgradeWeaponPrice(Stats.toString(weaponsArray[8].getCurrentUpgradeCost()));
        u10.setUpgradeWeaponPrice(Stats.toString(weaponsArray[9].getCurrentUpgradeCost()));

        /*
        u1.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[0].getCurrentUpgradeCost()));
        u2.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[1].getCurrentUpgradeCost()));
        u3.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[2].getCurrentUpgradeCost()));
        u4.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[3].getCurrentUpgradeCost()));
        u5.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[4].getCurrentUpgradeCost()));
        u6.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[5].getCurrentUpgradeCost()));
        u7.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[6].getCurrentUpgradeCost()));
        u8.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[7].getCurrentUpgradeCost()));
        u9.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[8].getCurrentUpgradeCost()));
        u10.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[9].getCurrentUpgradeCost()));
        */


        u1.setWeaponLevel(Stats.toStringLevel(weaponsArray[0].getLevel()));
        u2.setWeaponLevel(Stats.toStringLevel(weaponsArray[1].getLevel()));
        u3.setWeaponLevel(Stats.toStringLevel(weaponsArray[2].getLevel()));
        u4.setWeaponLevel(Stats.toStringLevel(weaponsArray[3].getLevel()));
        u5.setWeaponLevel(Stats.toStringLevel(weaponsArray[4].getLevel()));
        u6.setWeaponLevel(Stats.toStringLevel(weaponsArray[5].getLevel()));
        u7.setWeaponLevel(Stats.toStringLevel(weaponsArray[6].getLevel()));
        u8.setWeaponLevel(Stats.toStringLevel(weaponsArray[7].getLevel()));
        u9.setWeaponLevel(Stats.toStringLevel(weaponsArray[8].getLevel()));
        u10.setWeaponLevel(Stats.toStringLevel(weaponsArray[9].getLevel()));



        /*
        u1.setWeaponLevel(String.format(Locale.getDefault(), "%s",
                "Lvl " + IdleViewModel.weaponsArray[0].getLevel()));
        u2.setWeaponLevel(String.format(Locale.getDefault(), "%s",
                "Lvl " + IdleViewModel.weaponsArray[1].getLevel()));
        u3.setWeaponLevel(String.format(Locale.getDefault(), "%s",
                "Lvl " + IdleViewModel.weaponsArray[2].getLevel()));
        u4.setWeaponLevel(String.format(Locale.getDefault(), "%s",
                "Lvl " + IdleViewModel.weaponsArray[3].getLevel()));
        u5.setWeaponLevel(String.format(Locale.getDefault(), "%s",
                "Lvl " + IdleViewModel.weaponsArray[4].getLevel()));
        u6.setWeaponLevel(String.format(Locale.getDefault(), "%s",
                "Lvl " + IdleViewModel.weaponsArray[5].getLevel()));
        u7.setWeaponLevel(String.format(Locale.getDefault(), "%s",
                "Lvl " + IdleViewModel.weaponsArray[6].getLevel()));
        u8.setWeaponLevel(String.format(Locale.getDefault(), "%s",
                "Lvl " + IdleViewModel.weaponsArray[7].getLevel()));
        u9.setWeaponLevel(String.format(Locale.getDefault(), "%s",
                "Lvl " + IdleViewModel.weaponsArray[8].getLevel()));
        u10.setWeaponLevel(String.format(Locale.getDefault(), "%s",
                "Lvl " + IdleViewModel.weaponsArray[9].getLevel()));

*/
        p1.setProgressText(getContext().getString(R.string.weapon1));
        p2.setProgressText(getContext().getString(R.string.weapon2));
        p3.setProgressText(getContext().getString(R.string.weapon3));
        p4.setProgressText(getContext().getString(R.string.weapon4));
        p5.setProgressText(getContext().getString(R.string.weapon5));
        p6.setProgressText(getContext().getString(R.string.weapon6));
        p7.setProgressText(getContext().getString(R.string.weapon7));
        p8.setProgressText(getContext().getString(R.string.weapon8));
        p9.setProgressText(getContext().getString(R.string.weapon9));
        p10.setProgressText(getContext().getString(R.string.weapon10));






/*
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
*/
        //p1.setWeaponIncome("one");

        //p1.weaponIncome.setText("one");
        //p1.setWeaponIncome("one");




        //todo handle income change for each weapon
        /*final Observer<String> incomeObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                p1.setWeaponIncome(s);
            }
        };
/*
        final Observer<Weapon> weaponObserver = new Observer<Weapon>() {
            @Override
            public void onChanged(@Nullable Weapon weapon) {
                p1.setWeaponIncome(String.format(Locale.getDefault(),
                        "%.0f", weapon.getIncome()));
            }
        };

        Weapon.getIncomeNumber().observe(this, incomeObserver);
*/


        //UpgradeButton b1 = view.findViewById(R.id.upgrade_weapon_btn_1);

/*
        b1.upgradeWeaponBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String one = "2";
                //model.getCurrentTotal().setValue(one);
                //System.out.println(one);
                IdleViewModel.weaponsArray[0].setIncome(50);
                p1.setWeaponIncome(
                        String.format(Locale.getDefault(), "%.0f",
                                IdleViewModel.weaponsArray[0].getIncome()));
            }
        });
*/
        //progress1 = view.findViewById(R.id.upgrade_weapon_btn_1);
        //progress1.setText("10");
        //progress1.setOnClickListener(this);

        //final RadioButton buyOne = view.findViewById(R.id.buy_one);
        //final RadioButton buyTen = view.findViewById(R.id.buy_ten);
        //final RadioButton buyOneHundred = view.findViewById(R.id.buy_onehundred);
        //final RadioButton buyMax = view.findViewById(R.id.buy_max);

        buyOne = view.findViewById(R.id.buy_one);
        buyTen = view.findViewById(R.id.buy_ten);
        buyOneHundred = view.findViewById(R.id.buy_onehundred);
        //buyMax = view.findViewById(R.id.buy_max);

        setToBuyOne(view, weaponsArray);

        //todo number to resource
        //buyOne.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
        //buyTen.setBackgroundColor(222222);
        //buyOneHundred.setBackgroundColor(222222);
        //buyMax.setBackgroundColor(222222);

        RadioGroup radioGroup = view.findViewById(R.id.footer);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                //int number = 1;
                Weapon weapons[] = IdleViewModel.weaponsArray;
                double[] upgradePrices = new double[10];

                switch (checkedId) {
                    case R.id.buy_one:
                        buyOne.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
                        buyTen.setBackgroundColor(222222);
                        buyOneHundred.setBackgroundColor(222222);
                        //buyMax.setBackgroundColor(222222);
                        UpgradeButton.setNumberToUpgrade(1);
                        //Todo: update upgrade button
                        //set upgrade price based on amount
                        for(int i = 0; i<10; i++){
                            double a = weapons[i].calculateUpgradePrice(1);
                            weapons[i].setCurrentUpgradeCost(a);
                            upgradePrices[i] = a;
                        }
                        changeUpgradePriceForAll(upgradePrices);

                        //double price = Calculate.calculatePrice(context, 1);
                        //Data.setWeaponUpgradePrice_1(context, price);
                        //weaponUpgradePrice_1.setText(String.format(Locale.getDefault(), "%.0f", price));
                        //display upgrade price
                        break;

                    case R.id.buy_ten:
                        buyOne.setBackgroundColor(222222);
                        buyTen.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
                        buyOneHundred.setBackgroundColor(222222);
                        //buyMax.setBackgroundColor(222222);
                        UpgradeButton.setNumberToUpgrade(10);
                        //price = Calculate.calculatePrice(context, 1);
                        //Data.setWeaponUpgradePrice_1(context, price);
                        //if i set the price, it will be used when buy 1x is pressed in calculation
                        //weaponUpgradePrice_1.setText(String.format(Locale.getDefault(), "%.0f", price));

                        for(int i = 0; i<10; i++){
                            double a = weapons[i].calculateUpgradePrice(10);
                            weapons[i].setCurrentUpgradeCost(a);
                            upgradePrices[i] = a;
                        }
                        changeUpgradePriceForAll(upgradePrices);

                        break;

                    case R.id.buy_onehundred:
                        buyOne.setBackgroundColor(222222);
                        buyTen.setBackgroundColor(222222);
                        buyOneHundred.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
                        //buyMax.setBackgroundColor(222222);
                        UpgradeButton.setNumberToUpgrade(100);

                        for(int i = 0; i<10; i++){
                            double a = weapons[i].calculateUpgradePrice(100);
                            weapons[i].setCurrentUpgradeCost(a);
                            upgradePrices[i] = a;
                        }
                        changeUpgradePriceForAll(upgradePrices);

                        break;
                    /*
                    case R.id.buy_max:
                        buyOne.setBackgroundColor(222222);
                        buyTen.setBackgroundColor(222222);
                        buyOneHundred.setBackgroundColor(222222);
                        buyMax.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
                        //todo max should update after each currentTotal change
                        //UpgradeButton.setNumberToUpgrade(IdleViewModel.
                          //      weaponsArray[i].calculateMaxNumber());


                        //number = max
                        break;
*/
                }

            }
        });

        //System.out.println("progressWhileAway()");
        progressWhileAway(view);

        return view;
    }



    public void setToBuyOne(View view, Weapon [] weapons) {
        double[] upgradePrices = new double[10];

        buyOne.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
        buyTen.setBackgroundColor(222222);
        buyOneHundred.setBackgroundColor(222222);
        //buyMax.setBackgroundColor(222222);

        UpgradeButton.setNumberToUpgrade(1);

        for(int i = 0; i<10; i++){
            double a = weapons[i].calculateUpgradePrice(1);
            weapons[i].setCurrentUpgradeCost(a);
            upgradePrices[i] = a;
        }
        changeUpgradePriceForAll(upgradePrices);
    }

    private void changeUpgradePriceForAll(double [] priceArray) {
        //UpgradeButton u1 = getView().findViewById(R.id.upgrade_weapon_btn_1);
        //UpgradeButton u2 = getView().findViewById(R.id.upgrade_weapon_btn_2);
        //UpgradeButton u3 = getView().findViewById(R.id.upgrade_weapon_btn_3);
        //UpgradeButton u4 = getView().findViewById(R.id.upgrade_weapon_btn_4);
        //UpgradeButton u5 = getView().findViewById(R.id.upgrade_weapon_btn_5);
        //UpgradeButton u6 = getView().findViewById(R.id.upgrade_weapon_btn_6);
        //UpgradeButton u7 = getView().findViewById(R.id.upgrade_weapon_btn_7);
        //UpgradeButton u8 = getView().findViewById(R.id.upgrade_weapon_btn_8);
        //UpgradeButton u9 = getView().findViewById(R.id.upgrade_weapon_btn_9);
        //UpgradeButton u10 = getView().findViewById(R.id.upgrade_weapon_btn_10);

        u1.setUpgradeWeaponPrice(Stats.toString(priceArray[0]));
        u2.setUpgradeWeaponPrice(Stats.toString(priceArray[1]));
        u3.setUpgradeWeaponPrice(Stats.toString(priceArray[2]));
        u4.setUpgradeWeaponPrice(Stats.toString(priceArray[3]));
        u5.setUpgradeWeaponPrice(Stats.toString(priceArray[4]));
        u6.setUpgradeWeaponPrice(Stats.toString(priceArray[5]));
        u7.setUpgradeWeaponPrice(Stats.toString(priceArray[6]));
        u8.setUpgradeWeaponPrice(Stats.toString(priceArray[7]));
        u9.setUpgradeWeaponPrice(Stats.toString(priceArray[8]));
        u10.setUpgradeWeaponPrice(Stats.toString(priceArray[9]));

    }

    public void progressWhileAway(View view){

        Date startTime = new Date();

        DateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss",
                Locale.getDefault());

        long timeDifference = startTime.getTime() - Stats.exitTime.getTime();
        int newProgress = 0;
        double incomeWhileAway = 0;

        for(int i = 0; i < 10; i++) {
            if(weaponsArray[i].getGamer().getLevel() > 0)
            {

                double progressTime = IdleViewModel.weaponsArray[i].getBaseTime();
                double currentProgressTime = weaponsArray[i].getCurrentTime();
                double pauseTime = weaponsArray[i].getGamer().getTime();
                double totalTime = progressTime + pauseTime - currentProgressTime;
                //double totalTime = progressTime + pauseTime;

                double timesFraction = timeDifference / totalTime;
                double numberOfTimesProgressed = Math.floor(timesFraction);
                double numberAfterDecimal = (timesFraction
                        - Math.floor(timesFraction));

                incomeWhileAway += weaponsArray[i].getCurrentIncome()
                        * numberOfTimesProgressed;


               // newProgress = (int) (weaponsArray[i].getBaseTime()
                //        * numberAfterDecimal)
                //        - weaponsArray[i].getGamer().getTime();
                        //- weaponsArray[i].getGamer().getTime();
                //weaponsArray[i].setCurrentTime(newProgress);
                //newProgress = (int) ((weaponsArray[i].getGamer().getTime()
                //        - weaponsArray[i].getBaseTime()) * numberAfterDecimal);

                //(P + G)R - G
                newProgress = (int) (((weaponsArray[i].getBaseTime()
                        + weaponsArray[i].getGamer().getTime())
                        * numberAfterDecimal)
                        - weaponsArray[i].getGamer().getTime());


                weaponsArray[i].setCurrentTime(newProgress);
                //ProgressBarButton.setReturnProgress(weaponsArray[i]);

                weaponsArray[i].setCurrentTime(newProgress);
                ProgressBarButton p = getProgressBarButton(i, view);
                p.setReturnProgress(weaponsArray[i]);

            }

            else if (weaponsArray[i].getCurrentTime() > 0){
                if(timeDifference > weaponsArray[i].getCurrentTime()) {
                    newProgress = 0;
                    incomeWhileAway += weaponsArray[i].getCurrentIncome();

                    weaponsArray[i].setCurrentTime(newProgress);
                    ProgressBarButton p = getProgressBarButton(i, view);
                    p.setReturnProgress(weaponsArray[i]);
                }
                else
                    newProgress = (int) (weaponsArray[i].getCurrentTime()
                            - timeDifference);

                weaponsArray[i].setCurrentTime(newProgress);
                ProgressBarButton p = getProgressBarButton(i, view);
                p.setReturnProgress(weaponsArray[i]);

            }
            else newProgress = 0;

            //weaponsArray[i].setCurrentTime(newProgress);
            //weaponsArray[i].setCurrentTime(newProgress);
            //ProgressBarButton p = getProgressBarButton(i, view);
            //p.setReturnProgress(weaponsArray[i]);
            //gamer level = 0
                //if difference > weaponTime
                //else if difference < weaponTime

            //dialog.setValue(incomeWhileAway, view);





        }
        Stats.currentTotal.setValue(Stats.getCurrentTotal().getValue()
                + incomeWhileAway);
        WhileAwayDialog dialog = new WhileAwayDialog();
        if(incomeWhileAway > 0) {
            dialog.showDialog(getActivity(), incomeWhileAway, timeDifference);
        }


    }

    private ProgressBarButton getProgressBarButton(int i, View view) {
        switch (i) {
            case 0:
                return view.findViewById(R.id.progress_bar_1);
            case 1:
                return view.findViewById(R.id.progress_bar_2);
            case 2:
                return view.findViewById(R.id.progress_bar_3);
            case 3:
                return view.findViewById(R.id.progress_bar_4);
            case 4:
                return view.findViewById(R.id.progress_bar_5);
            case 5:
                return view.findViewById(R.id.progress_bar_6);
            case 6:
                return view.findViewById(R.id.progress_bar_7);
            case 7:
                return view.findViewById(R.id.progress_bar_8);
            case 8:
                return view.findViewById(R.id.progress_bar_9);
            case 9:
                return view.findViewById(R.id.progress_bar_10);
        }
        return null;
    }




}
