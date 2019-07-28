package com.np.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Setting extends AppCompatActivity {

    public static final String MyPREFERENCES ="MyPrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
}
