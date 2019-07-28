package com.np.foodapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Setting extends AppCompatActivity {

    private static final String TAG = "LoginActivity.java";
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
        final EditText username_tv = findViewById(R.id.etName);
        final EditText password_tv = findViewById(R.id.etPassword);
        Button btn_submit = findViewById(R.id.btnSettingSubmit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String sUser = username_tv.getText().toString();
               String sPassword =password_tv.getText().toString();
                // Get required information from sharedpreference
                SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                final String username = prefs.getString(Username, "");
                final String password = prefs.getString(Password,"");
                UserData dbDataUser = dbHandler.findUser(username);

               if(isValidUsername(sUser) && isValidPassword(sPassword)){
                   dbHandler.editUser(sUser ,sPassword);
                   Toast.makeText(getApplicationContext(),"Successfully Update",Toast.LENGTH_SHORT).show();
                   Intent intent= new Intent(Setting.this, MenuPage.class);
                   startActivity(intent);


               }
               else if (sUser==username && sPassword==password){
                   Toast.makeText(getApplicationContext(),"Invalid Username and Password",Toast.LENGTH_SHORT).show();

               }
               else if(dbDataUser != null){
                   Toast.makeText(getApplicationContext(),"Username already exist",Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(),"Invalid Username and Password",Toast.LENGTH_SHORT).show();
               }
            }
        });



    }
    public boolean isValidPassword(String password)
    {
        Pattern passwordPattern;
        Matcher passwordMatcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%]).{6,12}$";
        passwordPattern=Pattern.compile(PASSWORD_PATTERN);
        passwordMatcher=passwordPattern.matcher(password);

        Log.v(TAG,"Create Password:" + passwordMatcher.matches());

        return passwordMatcher.matches();
    }

    public boolean isValidUsername(String userName)
    {
        Pattern userNamePattern;
        Matcher userNameMatcher;

        final String USERNAME_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,12}$";

        userNamePattern=Pattern.compile(USERNAME_PATTERN);
        userNameMatcher=userNamePattern.matcher(userName);

        Log.v(TAG,"Create UserName" + userNameMatcher.matches());

        return userNameMatcher.matches();

    }


}
