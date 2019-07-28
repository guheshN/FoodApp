package com.np.foodapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    private static final String TAG = "LoginActivity.java";
    private TextView tv_NewUser;
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Userid = "userid";
    public static final String Courtposition = "courtposition";
    public static final String Stallposition = "stallposition";
    public static final String Username= "username";
    public static final String Password="password";

    MyDBHandler dbHandler = new MyDBHandler(this,null,null,2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
}
