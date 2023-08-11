package com.example.stopwatch;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int second = 0; //starting point of the stopwatch
    boolean running; // state of the stop

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }

    public void onStart(View view) {
        running = true;
    }

    public void onPause(View view) {
        running =false;
    }

    public void onReset(View view) {
        running =false;
        second=0;
    }
    public void  runTimer(){
        final TextView timer = findViewById(R.id.timer);


        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

        int hours = second/3600;
        int minutes = (second%3600)/60;
        int Seconds = second%60;

        if (running){
            second++;
        }

        String time = String.format(Locale.getDefault(), "%d%02d:%02d",hours,minutes,Seconds);
        timer.setText(time);
        handler.postDelayed(this::runTimer,1000);
    }
}