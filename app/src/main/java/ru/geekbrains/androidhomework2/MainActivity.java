package ru.geekbrains.androidhomework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_comma;
    private Button button_ac;
    private Button button_add;
    private Button button_del;
    private Button button_kalc;
    private Button button_div;
    private Button button_mult;
    private Button button_perc;
    private Button button_sub;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cons_weights);

        textView = findViewById(R.id.tv_main);
        button_0 = findViewById(R.id.K0);
        button_1 = findViewById(R.id.K1);
        button_2 = findViewById(R.id.K2);
        button_3 = findViewById(R.id.K3);
        button_4 = findViewById(R.id.K4);
        button_5 = findViewById(R.id.K5);
        button_6 = findViewById(R.id.K6);
        button_7 = findViewById(R.id.K7);
        button_8 = findViewById(R.id.K8);
        button_9 = findViewById(R.id.K9);
        button_comma = findViewById(R.id.K_comma);
        button_ac = findViewById(R.id.K_AC);
        button_add = findViewById(R.id.K_add);
        button_del = findViewById(R.id.K_del);
        button_kalc = findViewById(R.id.K_kalc);
        button_div = findViewById(R.id.K_div);
        button_mult = findViewById(R.id.K_mult);
        button_perc = findViewById(R.id.K_perc);
        button_sub = findViewById(R.id.K_sub);
        counter = 0;


    }
    public void button_0_onClic(View view){
        counter++;
        textView.setText(counter+"");
    }
}
