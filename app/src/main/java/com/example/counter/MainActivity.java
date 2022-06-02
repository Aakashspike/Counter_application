package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    Button bt1,bt2;
    int count = 0;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        ed = (EditText) findViewById(R.id.ed);
        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(timerThread, 1000);
            }
        });

        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(timerThread);
            }
        });

    }

    Runnable timerThread = new Runnable() {
        @Override
        public void run() {
            ed.setText(""+count);
            handler.postDelayed(this,1000);
            count++;
        }
    };
}