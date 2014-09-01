package com.example.hiittimer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.widget.TextView;

public class TimerActivity extends Activity {
	TextView mTimeRemainingText;
	CountDownTimer mRestCountDownTimer;
	CountDownTimer mSprintCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        
        mTimeRemainingText = (TextView) findViewById(R.id.time_left);
        mRestCountDownTimer = new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTimeRemainingText.setText("sprint seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
            	mSprintCountDownTimer = new CountDownTimer(10000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        mTimeRemainingText.setText("rest seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        mRestCountDownTimer.start();
                    }
                 }.start();
            }
         }.start();
        
    }
    
}
