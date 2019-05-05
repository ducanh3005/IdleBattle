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
import com.ballardsoftware.idlebattle.View.CustomViews.ProgressBarButton;
import com.ballardsoftware.idlebattle.View.CustomViews.UpgradeButton;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

import java.util.Locale;

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

        IdleViewModel.startGame();



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



        p1.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[0].getIncome()));
        p2.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[1].getIncome()));
        p3.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[2].getIncome()));
        p4.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[3].getIncome()));
        p5.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[4].getIncome()));
        p6.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[5].getIncome()));
        p7.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[6].getIncome()));
        p8.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[7].getIncome()));
        p9.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[8].getIncome()));
        p10.setWeaponIncome(String.format(Locale.getDefault(), "%.0f",
                IdleViewModel.weaponsArray[9].getIncome()));

        final UpgradeButton u1 = view.findViewById(R.id.upgrade_weapon_btn_1);
        final UpgradeButton u2 = view.findViewById(R.id.upgrade_weapon_btn_2);
        final UpgradeButton u3 = view.findViewById(R.id.upgrade_weapon_btn_3);
        UpgradeButton u4 = view.findViewById(R.id.upgrade_weapon_btn_4);
        UpgradeButton u5 = view.findViewById(R.id.upgrade_weapon_btn_5);
        UpgradeButton u6 = view.findViewById(R.id.upgrade_weapon_btn_6);
        UpgradeButton u7 = view.findViewById(R.id.upgrade_weapon_btn_7);
        UpgradeButton u8 = view.findViewById(R.id.upgrade_weapon_btn_8);
        UpgradeButton u9 = view.findViewById(R.id.upgrade_weapon_btn_9);
        UpgradeButton u10 = view.findViewById(R.id.upgrade_weapon_btn_10);

        u1.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[0].getUpgradeCost()));
        u2.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[1].getUpgradeCost()));
        u3.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[2].getUpgradeCost()));
        u4.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[3].getUpgradeCost()));
        u5.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[4].getUpgradeCost()));
        u6.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[5].getUpgradeCost()));
        u7.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[6].getUpgradeCost()));
        u8.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[7].getUpgradeCost()));
        u9.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[8].getUpgradeCost()));
        u10.setUpgradeWeaponPrice(String.format(Locale.getDefault(),
                "%.0f", IdleViewModel.weaponsArray[9].getUpgradeCost()));



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


        final RadioButton buyOne = view.findViewById(R.id.buy_one);
        final RadioButton buyTen = view.findViewById(R.id.buy_ten);
        final RadioButton buyOneHundred = view.findViewById(R.id.buy_onehundred);
        final RadioButton buyMax = view.findViewById(R.id.buy_max);

        //todo number to resource
        buyOne.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
        buyTen.setBackgroundColor(222222);
        buyOneHundred.setBackgroundColor(222222);
        buyMax.setBackgroundColor(222222);

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
                        buyMax.setBackgroundColor(222222);
                        UpgradeButton.setNumberToUpgrade(1);
                        //Todo: update upgrade button
                        //set upgrade price based on amount
                        for(int i = 0; i<10; i++){
                            double a = weapons[i].calculateUpgradePrice(1);
                            weapons[i].setUpgradeCost(a);
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
                        buyMax.setBackgroundColor(222222);
                        UpgradeButton.setNumberToUpgrade(10);
                        //price = Calculate.calculatePrice(context, 1);
                        //Data.setWeaponUpgradePrice_1(context, price);
                        //if i set the price, it will be used when buy 1x is pressed in calculation
                        //weaponUpgradePrice_1.setText(String.format(Locale.getDefault(), "%.0f", price));

                        for(int i = 0; i<10; i++){
                            double a = weapons[i].calculateUpgradePrice(10);
                            weapons[i].setUpgradeCost(a);
                            upgradePrices[i] = a;
                        }
                        changeUpgradePriceForAll(upgradePrices);

                        break;

                    case R.id.buy_onehundred:
                        buyOne.setBackgroundColor(222222);
                        buyTen.setBackgroundColor(222222);
                        buyOneHundred.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
                        buyMax.setBackgroundColor(222222);
                        UpgradeButton.setNumberToUpgrade(100);

                        for(int i = 0; i<10; i++){
                            double a = weapons[i].calculateUpgradePrice(100);
                            weapons[i].setUpgradeCost(a);
                            upgradePrices[i] = a;
                        }
                        changeUpgradePriceForAll(upgradePrices);

                        break;

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

                }

            }
        });

        return view;
    }


    private void changeUpgradePriceForAll(double [] priceArray) {
        UpgradeButton u1 = getView().findViewById(R.id.upgrade_weapon_btn_1);
        UpgradeButton u2 = getView().findViewById(R.id.upgrade_weapon_btn_2);
        UpgradeButton u3 = getView().findViewById(R.id.upgrade_weapon_btn_3);
        UpgradeButton u4 = getView().findViewById(R.id.upgrade_weapon_btn_4);
        UpgradeButton u5 = getView().findViewById(R.id.upgrade_weapon_btn_5);
        UpgradeButton u6 = getView().findViewById(R.id.upgrade_weapon_btn_6);
        UpgradeButton u7 = getView().findViewById(R.id.upgrade_weapon_btn_7);
        UpgradeButton u8 = getView().findViewById(R.id.upgrade_weapon_btn_8);
        UpgradeButton u9 = getView().findViewById(R.id.upgrade_weapon_btn_9);
        UpgradeButton u10 = getView().findViewById(R.id.upgrade_weapon_btn_10);

        u1.setUpgradeWeaponPrice(toString(priceArray[0]));
        u2.setUpgradeWeaponPrice(toString(priceArray[1]));
        u3.setUpgradeWeaponPrice(toString(priceArray[2]));
        u4.setUpgradeWeaponPrice(toString(priceArray[3]));
        u5.setUpgradeWeaponPrice(toString(priceArray[4]));
        u6.setUpgradeWeaponPrice(toString(priceArray[5]));
        u7.setUpgradeWeaponPrice(toString(priceArray[6]));
        u8.setUpgradeWeaponPrice(toString(priceArray[7]));
        u9.setUpgradeWeaponPrice(toString(priceArray[8]));
        u10.setUpgradeWeaponPrice(toString(priceArray[9]));

    }

    private String toString(Double d) {
        if(d >= 10000000) {
            return String.format(Locale.getDefault(), "%3.3E", d);
        }
        else
            return String.format(Locale.getDefault(), "%.0f", d);
    }

    private String toString(double d) {
        if(d >= 10000000) {
            return String.format(Locale.getDefault(), "%3.3E", d);
        }
        else
            return String.format(Locale.getDefault(), "%.0f", d);
    }




}
