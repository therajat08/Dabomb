package com.example.rajat.dabomb;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        final TextView timerTextView = (TextView)findViewById(R.id.timerTextView);
        timerTextView.setEnabled(false);
        timerSeekBar.setMax(600);//10 * 60 for 10 minumtes
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int minutes = (int)progress/60;//casting done for roundin off the num
                int seconds = progress - minutes * 60;

                String secondString = Integer.toString(seconds);

                if(secondString == "0")//this is done cos at the end it was like 10:0 and not 10:00
                {
                    secondString = "00";
                }
                timerTextView.setText(Integer.toString(minutes) + ":" + secondString);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
