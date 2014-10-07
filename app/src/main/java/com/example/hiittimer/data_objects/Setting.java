package com.example.hiittimer.data_objects;

/**
 * Created by thoughtworker on 10/6/14.
 */
public class Setting {
    private int seconds_of_rest = 10;
    private int seconds_of_sprint = 20;

    public Setting(){}

    public int getSeconds_of_rest() {
        return seconds_of_rest;
    }

    public void setSeconds_of_rest(int seconds_of_rest) {
        this.seconds_of_rest = seconds_of_rest;
    }

    public int getSeconds_of_sprint() {
        return seconds_of_sprint;
    }

    public void setSeconds_of_sprint(int seconds_of_sprint) {
        this.seconds_of_sprint = seconds_of_sprint;
    }
}
