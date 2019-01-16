package com.example.rajat.dabomb;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    TextView timerTextView;
    public void updateTimer(int secondsLeft){
        int minutes = (int)secondsLeft/60;//casting done for roundin off the num
        int seconds = secondsLeft - minutes * 60;

        String secondString = Integer.toString(seconds);
          if(seconds <= 9)
        {
            secondString = "0" + secondString;
        }
        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);

    }
    public void controlTimer(View view){
        new CountDownTimer(timerSeekBar.getProgress()*1000 + 100,1000){
            //mul by 1000 cos seconds to milli sec
            //addded 100 cos it takes some millisc for onTick to be called and we are roundin off in
            //updatatimer so it timer wan't workin right    
            @Override
            public void onTick(long millisUNtilFinished) {
                updateTimer((int) millisUNtilFinished/1000);
            }

            @Override
            public void onFinish() {
                timerTextView.setText("0:00");//cos it was like: 0:1
                Log.i("finished","coundown");
            }


        }.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        timerTextView.setEnabled(false);
        timerSeekBar.setMax(600);//10 * 60 for 10 minumtes
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                updateTimer(progress);
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
