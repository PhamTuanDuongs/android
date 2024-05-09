package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox ck1, ck2, ck3;
    private RadioButton g1, g2;
    private RatingBar rt;
    private Spinner sp1, sp2;
    private TextView kq;
    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.somewidgets);
        initView();
        initSpinner();
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleData();
            }
        });
    }

    private void handleData() {
        String ss = "Check box:";
        if (ck1.isChecked()) {
            ss += ck1.getText() + ",";
        }
        if (ck2.isChecked()) {
            ss += ck2.getText() + ",";
        }
        if (ck3.isChecked()) {
            ss += ck3.getText() + ",";
        }
        if (ss.endsWith(",")) {
            ss = ss.substring(0, ss.length() - 1);
        }
        ss += "\nGioi tinh:";
        if (g1.isChecked()) {
            ss += g1.getText();
        } else {
            ss += g2.getText();
        }


        ss += "\nRating:" + rt.getRating();
        ss += "\n" + sp1.getSelectedItem().toString();
        kq.setText(ss);
    }

    private void initSpinner() {
        String[] list = {"PTIT", "HUST", "VNU", "FPT"};
        ArrayAdapter<String> newAdapter1 = new ArrayAdapter<>(this, R.layout.item, list);
        sp1.setAdapter(newAdapter1);
        String[] list2 = getResources().getStringArray(R.array.planets_array);
        ArrayAdapter<String> newAdapter2 = new ArrayAdapter<>(this, R.layout.item, list2);
        sp2.setAdapter(newAdapter2);
    }

    private void initView() {
        ck1 = findViewById(R.id.ck1);
        ck2 = findViewById(R.id.ck2);
        ck3 = findViewById(R.id.ck3);
        g1 = findViewById(R.id.male);
        g2 = findViewById(R.id.female);
        rt = findViewById(R.id.rating);
        sp1 = findViewById(R.id.sp2);
        sp2 = findViewById(R.id.sp1);
        btnResult = findViewById(R.id.btnResult);
        kq = findViewById(R.id.displedText);
    }
}