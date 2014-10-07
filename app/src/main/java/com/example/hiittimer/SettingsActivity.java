package com.example.hiittimer;

import android.app.Activity;
import android.os.Bundle;

import com.example.hiittimer.utils.CustomNumberPicker;

/**
 * Created by thoughtworker on 10/6/14.
 */
public class SettingsActivity extends Activity {
    private CustomNumberPicker secondsOfRest;
    private CustomNumberPicker secondsOfSprint;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        secondsOfRest = (CustomNumberPicker) findViewById(R.id.secondsRestPicker);
        secondsOfRest.setValue(30);
        secondsOfSprint = (CustomNumberPicker) findViewById(R.id.secondsIntensityPicker);
        secondsOfSprint.setValue(40);
    }
}
