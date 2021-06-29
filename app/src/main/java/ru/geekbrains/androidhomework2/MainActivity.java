package ru.geekbrains.androidhomework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity  {

    private Calculator calculator;
    private TextView textView;
    public final String KEY = "key_calculator";
    String sharedText;
    private Button options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cons_weights);
        setTheme(convertCodeToStyle(getAppTheme()));
        init();
        initChanger();
        Intent intent = getIntent();
    String action = intent.getAction();
//        String type = intent.getType();
//        Uri data = intent.getData();
        if (Intent.ACTION_SEND.equals(action)){
           sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
            calculator.setFirstArg(Integer.parseInt(sharedText));
            calculator.setState(Calculator.State.firstArgInput);
            calculator.onNumShared(Integer.parseInt(sharedText));
            textView.setText(sharedText);
//            textView.setText(calculator.getText());
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY, calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = (Calculator) savedInstanceState.getSerializable(KEY);
        restoreCalc();
    }
    private void restoreCalc() {
        textView.setText(calculator.getText());
    }

    private void init(){
        calculator = new Calculator();
        textView = findViewById(R.id.tv_main);
        options = findViewById(R.id.K_Options);
        options.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentToOption = new Intent("android.intent.action.Options");
                        startActivity(intentToOption);
                    }
                }
        );
        int[] numbersIds = new int[]{
                R.id.K0,
                R.id.K1,
                R.id.K2,
                R.id.K3,
                R.id.K4,
                R.id.K5,
                R.id.K6,
                R.id.K7,
                R.id.K8,
                R.id.K9
        };

        int[] actionsIds = new int[]{
                R.id.K_add,
                R.id.K_sub,
                R.id.K_kalc,
                R.id.K_div,
                R.id.K_mult
        };

        View.OnClickListener numberButtonClicListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onNumPressed(v.getId());
                textView.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButtonClicListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onActionPressed(v.getId());
                textView.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numbersIds.length; i++) {
            findViewById(numbersIds[i]).setOnClickListener(numberButtonClicListener);
        }

        for (int i = 0; i < actionsIds.length; i++) {
            findViewById(actionsIds[i]).setOnClickListener(actionButtonClicListener);
        }
    }
    private final int MyCoolStyle = 0;
    private final int NotMyNoralStyle = 1;
    private final int WhateverStyle = 2;

    private final String KEY_PREF = "key";
    private final String APP_THEME = "theme";

    private int convertCodeToStyle(int codeStyle) {
        switch (codeStyle) {
            case MyCoolStyle:
                return R.style.MyCoolStyle;
            case NotMyNoralStyle:
                return R.style.NotMyNoralStyle;
            default:
                return R.style.WhateverStyle;
        }
    }

    private void initChanger() {
        initButton(findViewById(R.id.radioButton), MyCoolStyle);
        initButton(findViewById(R.id.radioButton1), NotMyNoralStyle);
        initButton(findViewById(R.id.radioButton2), WhateverStyle);
    }

    private void initButton(RadioButton button, int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);
                recreate();
            }
        });
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_THEME, codeStyle);
        editor.apply();
//        codeStyle = 9999;
//        Log.d("mylogs", sharedPreferences.getInt(APP_THEME, codeStyle)+"");
    }

    private int getAppTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREF, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME, MyCoolStyle);
    }
}
