package com.np.foodapp;

import android.support.v7.app.AppCompatActivity;

public class App {
    public static void finishApp(AppCompatActivity app){
        app.finish();
    }

    public static void refreshApp(AppCompatActivity app){
        app.recreate();
    }
}
