package com.example.hiittimer;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimerFragment extends Fragment {
	TextView mTimeRemainingText;
	CountDownTimer mRestCountDownTimer;
	CountDownTimer mSprintCountDownTimer;
	TextView mTotalTimeElapsedText;
	private int mTotalTimeElapsed = 0;
	private static int SECONDS_OF_REST = 10;
	private static int SECONDS_OF_SPRINT = 20;
	private static int VIBRATION_DURATION_MILLISECONDS = 400;
	private static int[] SECONDS_LEFT_OF_REST_VIBRATIONS = { 1, 2, 3 };
	private static int[] SECONDS_LEFT_OF_SPRINT_VIBRATIONS = { 1 };
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.fragment_timer, parent, false);
		
		mTotalTimeElapsedText = (TextView) view.findViewById(R.id.total_time_elapsed);
        mTimeRemainingText = (TextView) view.findViewById(R.id.time_left);
        
        Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        setRestCountDownTimer(vibrator);
        setSprintCountDownTimer(vibrator);
        
        mRestCountDownTimer.start();
		
		return view;
	}
	
	private void setRestCountDownTimer(final Vibrator vibrator){
    	mRestCountDownTimer = new CountDownTimer(SECONDS_OF_REST * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
            	mTotalTimeElapsed += 1;
            	
            	long seconds_until_finished = millisUntilFinished / 1000;
            	if(listContainsElement(SECONDS_LEFT_OF_REST_VIBRATIONS, (int) seconds_until_finished)){
            		vibrator.vibrate(VIBRATION_DURATION_MILLISECONDS);
            	}
                mTimeRemainingText.setText("rest seconds remaining: " + seconds_until_finished);
                mTotalTimeElapsedText.setText("Total Time: " + mTotalTimeElapsed);
                Log.d("TIMER_FRAGMETN",mTotalTimeElapsedText.getText().toString());
            }

            public void onFinish() {
            	mSprintCountDownTimer.start();
            }
         };
    }
    
    private void setSprintCountDownTimer(final Vibrator vibrator){
    	mSprintCountDownTimer = new CountDownTimer(SECONDS_OF_SPRINT * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
            	mTotalTimeElapsed += 1;
            	
            	long seconds_until_finished = millisUntilFinished / 1000;
            	if(listContainsElement(SECONDS_LEFT_OF_SPRINT_VIBRATIONS, (int) seconds_until_finished)){
            		vibrator.vibrate(VIBRATION_DURATION_MILLISECONDS);
            	}
            	
                mTimeRemainingText.setText("sprint seconds remaining: " + seconds_until_finished);
                mTotalTimeElapsedText.setText("Total Time: " + mTotalTimeElapsed);
            }

            public void onFinish() {
                mRestCountDownTimer.start();
            }
         };
    }
    
    private boolean listContainsElement(int[] list, int element){
    	for(int item : list){
    		if (item == element){
    			return true;
    		}
    	}
    	
    	return false;
    }
}
