package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {

    private TextView kq;
    private EditText edit1, edit2;
    private Button btAdd;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculator);
        initView();
    }

    private void initView() {
        kq = findViewById(R.id.result);
        edit1 = findViewById(R.id.num1);
        edit2 = findViewById(R.id.num2);
        btAdd = findViewById(R.id.button);
        sp = findViewById(R.id.spinner);
    }

    public void add(View v) {
        String nn1 = edit1.getText().toString();
        String nn2 = edit2.getText().toString();
        double n1, n2;
        try {
            n1 = Double.parseDouble(nn1);
            n2 = Double.parseDouble(nn2);
            String p = sp.getSelectedItem().toString();
            String kk = tinhtoan(n1, n2, p);
            Toast.makeText(getApplicationContext(), kk, Toast.LENGTH_LONG).show();
            kq.setText(kk);
        } catch (NumberFormatException e) {
            Log.println(Log.ERROR, "Error parse", e.getMessage());
        }
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nn1 = edit1.getText().toString();
                String nn2 = edit2.getText().toString();
                double n1, n2;
                try {
                    n1 = Double.parseDouble(nn1);
                    n2 = Double.parseDouble(nn2);
                    String p = sp.getSelectedItem().toString();
                    String kkk = tinhtoan(n1, n2, p);
                    Toast.makeText(getApplicationContext(), kkk, Toast.LENGTH_SHORT).show();
                    kq.setText(kkk);
                } catch (NumberFormatException e) {
                    Log.println(Log.ERROR, "Error parse", e.getMessage());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private String tinhtoan(double x, double y, String p) {
        String s = "";
        switch (p) {
            case "+":
                s = "Tong:" + (x + y);
                break;
            case "-":
                s = "Tru:" + (x - y);
                break;
            case "*":
                s = "Nhan:" + (x * y);
                break;
            case "/":
                if (y == 0) {
                    s = "Khong chia cho 0";
                } else {
                    s = "Thuong:" + (x / y);
                }
                break;
        }
        return s;
    }
}