package com.example.se1705;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.se1705.layout.MainActivity;

//flow
// Barrier
// V>D>I>W>E
public class FlowDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flowdemo);
        Log.d("FlowDemoxxx", "go to Oncreate");
        Button b = findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FlowDemo.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("FlowDemoxxx", "go to onStart");

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FlowDemoxxx", "go to onRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("FlowDemoxxx", "go to onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("FlowDemoxxx", "go to onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("FlowDemoxxx", "go to onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("FlowDemoxxx", "go to onDestroy");

    }
}