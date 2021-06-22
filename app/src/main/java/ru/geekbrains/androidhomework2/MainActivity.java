package ru.geekbrains.androidhomework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity  {

    private Calculator calculator;
    private TextView textView;
    public final String KEY = "key_calculator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cons_weights);

        init();



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

}
