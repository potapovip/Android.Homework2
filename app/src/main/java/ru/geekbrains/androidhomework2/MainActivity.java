package ru.geekbrains.androidhomework2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity  {


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
    private TextView textView;
    private Counters counters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cons_weights);
        init();

    }


    private void init() {
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
                R.id.K_del,
                R.id.K_kalc,
                R.id.K_div,
                R.id.K_mult
        };


    }
}
