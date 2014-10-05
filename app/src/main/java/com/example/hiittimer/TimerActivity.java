package com.example.hiittimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;

public class TimerActivity extends FragmentActivity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        
        FragmentManager fragment_manager = getSupportFragmentManager();
        Fragment fragment = fragment_manager.findFragmentById(R.id.fragmantContainer);
        
        if(fragment == null){
        	fragment = new TimerFragment();
        	fragment_manager.beginTransaction().add(R.id.fragmantContainer, fragment).commit();
        }
    }
    
    
        
}
