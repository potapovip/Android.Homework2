package ru.geekbrains.androidhomework2;

import androidx.annotation.NonNull;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Options {

    private Calculator calculator;
    private TextView textView;
    public final String KEY = "key_calculator";
    String sharedText;
    private Button options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cons_weights);
        init();
        openSharedText();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setTheme(getAppTheme());
        recreate();
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

    private void openSharedText() {
        Intent intent = getIntent();
        String action = intent.getAction();
        if (Intent.ACTION_SEND.equals(action)) {
            sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
            calculator.setFirstArg(Double.parseDouble(sharedText));
            textView.setText(sharedText);
        }
    }

    private void restoreCalc() {
        textView.setText(calculator.getText());
    }

    private void init() {
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
                R.id.K9,
                R.id.K_comma,
                R.id.K_del,
                R.id.K_AC
        };

        int[] actionsIds = new int[]{
                R.id.K_add,
                R.id.K_sub,
                R.id.K_kalc,
                R.id.K_div,
                R.id.K_mult,
                R.id.K_perc
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
}
