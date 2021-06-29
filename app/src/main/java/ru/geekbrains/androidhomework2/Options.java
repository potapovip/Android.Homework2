package ru.geekbrains.androidhomework2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(convertCodeToStyle(getAppTheme()));
        setContentView(R.layout.activity_options);
        initChanger();
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
        initButton(findViewById(R.id.radioButton3), MyCoolStyle);
        initButton(findViewById(R.id.radioButton4), NotMyNoralStyle);
        initButton(findViewById(R.id.radioButton5), WhateverStyle);
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
