//package ru.geekbrains.androidhomework2;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.Locale;
//
//
//public class MainDuplicate extends AppCompatActivity implements View.OnClickListener {
//
//    int[] numbersids = new int[]{
//
//
//    private Button button_0;
//    private Button button_1;
//    private Button button_2;
//    private Button button_3;
//    private Button button_4;
//    private Button button_5;
//    private Button button_6;
//    private Button button_7;
//    private Button button_8;
//    private Button button_9;
//}
//    private Button button_comma;
//    private Button button_ac;
//    private Button button_add;
//    private Button button_del;
//    private Button button_kalc;
//    private Button button_div;
//    private Button button_mult;
//    private Button button_perc;
//    private Button button_sub;
//    private TextView textView;
//    private Counters counters;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cons_weights);
//
//        init();
//        initListeners();
//        button_2.setOnClickListener(this);
//        button_3.setOnClickListener(this);
//
//
//
//
//    }
//    public void button_0_onClic(View view){
//        counters.increaseCounter1();
//        textView.setText(String.format(Locale.getDefault(), "%d",counters.getCounter_1()));
//    }
//
//    private void initListeners(){
//        button_1.setOnClickListener(v -> {
//            counters.increaseCounter2();
//            Toast toast = Toast.makeText(this,String.format(Locale.getDefault(),"%d",counters.getCounter_2()),Toast.LENGTH_SHORT);
//            toast.show();
//        });
//    }
//
//
//    @Override
//    public void  onClick(View v) {
//        switch (v.getId()){
//            case R.id.K2:
//                counters.increaseCounter3();
//                showToast(String.valueOf(counters.getCounter_3()));
//                break;
//            case R.id.K3:
//                counters.increaseCounter4();
//                showToast(String.format(Locale.getDefault(),"%d",counters.getCounter_4()));
//                break;
//        }
//
//    }
//    public void showToast(String text){
//        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//    }
//
//    private void init(){
//        textView = findViewById(R.id.tv_main);
//        button_0 = findViewById(R.id.K0);
//        button_1 = findViewById(R.id.K1);
//        button_2 = findViewById(R.id.K2);
//        button_3 = findViewById(R.id.K3);
//        button_4 = findViewById(R.id.K4);
//        button_5 = findViewById(R.id.K5);
//        button_6 = findViewById(R.id.K6);
//        button_7 = findViewById(R.id.K7);
//        button_8 = findViewById(R.id.K8);
//        button_9 = findViewById(R.id.K9);
//        button_comma = findViewById(R.id.K_comma);
//        button_ac = findViewById(R.id.K_AC);
//        button_add = findViewById(R.id.K_add);
//        button_del = findViewById(R.id.K_del);
//        button_kalc = findViewById(R.id.K_kalc);
//        button_div = findViewById(R.id.K_div);
//        button_mult = findViewById(R.id.K_mult);
//        button_perc = findViewById(R.id.K_perc);
//        button_sub = findViewById(R.id.K_sub);
//
//        counters = new Counters();
//    }
//}
