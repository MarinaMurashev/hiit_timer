package com.example.hiittimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimerFragment extends Fragment {
	TextView mTimeRemainingText;
	CountDownTimer mRestCountDownTimer;
	CountDownTimer mSprintCountDownTimer;
	private static int SECONDS_OF_REST = 10;
	private static int SECONDS_OF_SPRINT = 20;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.fragment_timer, parent, false);
		
        
        mTimeRemainingText = (TextView) view.findViewById(R.id.time_left);
        setRestCountDownTimer();
        setSprintCountDownTimer();
        
        mRestCountDownTimer.start();
		
		return view;
	}
	
	private void setRestCountDownTimer(){
    	mRestCountDownTimer = new CountDownTimer(SECONDS_OF_REST * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTimeRemainingText.setText("rest seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
            	mSprintCountDownTimer.start();
            }
         };
    }
    
    private void setSprintCountDownTimer(){
    	mSprintCountDownTimer = new CountDownTimer(SECONDS_OF_SPRINT * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTimeRemainingText.setText("sprint seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mRestCountDownTimer.start();
            }
         };
    }
}
