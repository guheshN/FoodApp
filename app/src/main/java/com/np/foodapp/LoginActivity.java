package com.np.foodapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnTouchListener{

    private static final String TAG = "LoginActivity.java";
    private TextView tv_NewUser;

    MyDBHandler dbHandler = new MyDBHandler(this,null,null,2);


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //set image in layout
        ImageView app_icon = findViewById(R.id.app_Icon);
        app_icon.setImageResource(R.drawable.app_icon);

        tv_NewUser = (TextView) findViewById(R.id.textView_Newuser);
        tv_NewUser.setOnTouchListener(this);
    }


    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouch(View v, MotionEvent event)
    {
        Log.v(TAG,"Touch Start");
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        return true;
    }

    public void onClick(View v)
    {
        final EditText etPassword = findViewById(R.id.editText_Password);
        final EditText etUsername = findViewById(R.id.editText_Username);

        String user = etUsername.getText().toString();
        String pass = etPassword.getText().toString();

        Log.v(TAG,"Login with:" + etUsername.getText().toString() + "'" + etPassword.getText().toString());
        //if(isValidUsername(etUsername.getText().toString()) && isValidPassword(etPassword.getText().toString()))
        if (isValidUser(user, pass))
        {
            UserData userData = dbHandler.findUser(user);
            Intent intent= new Intent(LoginActivity.this, CourtRV.class);
            intent.putExtra("userid",Integer.toString(userData.getUserID()));
            Toast.makeText(this, "Valid User", Toast.LENGTH_LONG).show();
            startActivity(intent);

        }
        else if(!isValidUser(user, pass))
        {
            Toast.makeText(LoginActivity.this,"Invalid User",Toast.LENGTH_LONG).show();
        }

    }

    public boolean isValidUser(String userName,String password){
        UserData dbData= dbHandler.findUser(userName);
        Log.v(TAG, "Running Checks... ..."+dbData.getMyUserName()+": "+dbData.getMyPassword()
                +"vs"+userName+": "+password);
        if(dbData != null &&dbData.getMyUserName().equals(userName)&&dbData.getMyPassword().equals(password)){
            return true;
        }
        else{
           return false;

        }
    }

}