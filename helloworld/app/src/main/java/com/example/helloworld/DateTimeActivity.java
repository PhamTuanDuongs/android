package com.example.helloworld;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et, edt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.datetime);
        init();

    }

    private void init() {
        et = findViewById(R.id.eTime);
        edt = findViewById(R.id.eDate);
        et.setOnClickListener(this);
        edt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == et) {
            handleGetTime();
        }

        if (v == edt) {
            handleGetDate();
        }
    }

    private void handleGetDate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edt.setText(year + "/" + month + "/" + dayOfMonth);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void handleGetTime() {
        Calendar c = Calendar.getInstance();
        int hourOfDauy = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        TimePickerDialog timedialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                et.setText(hourOfDay + ":" + minute);
            }
        }, hourOfDauy, minute, false);
        timedialog.show();
    }


}