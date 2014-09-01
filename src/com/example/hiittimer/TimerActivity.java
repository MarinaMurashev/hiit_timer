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
	int mRestSeconds = 10;
	int mSprintSeconds = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        
        mTimeRemainingText = (TextView) findViewById(R.id.time_left);
        setRestCountDownTimer();
        setSprintCountDownTimer();
        
        mRestCountDownTimer.start();
    }
    
    private void setRestCountDownTimer(){
    	mRestCountDownTimer = new CountDownTimer(mRestSeconds * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTimeRemainingText.setText("rest seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
            	mSprintCountDownTimer.start();
            }
         };
    }
    
    private void setSprintCountDownTimer(){
    	mSprintCountDownTimer = new CountDownTimer(mSprintSeconds * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTimeRemainingText.setText("sprint seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mRestCountDownTimer.start();
            }
         };
    }
        
}
