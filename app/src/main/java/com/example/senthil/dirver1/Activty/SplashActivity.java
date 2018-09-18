package com.example.senthil.dirver1.Activty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.senthil.dirver1.Login;
import com.example.senthil.dirver1.Profile;
import com.example.senthil.dirver1.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        new Timer().schedule(new TimerTask(){
            public void run() {
                pref = getSharedPreferences("Hyper", MODE_PRIVATE);

                authenticate();
            }
        }, 2000);
    }

    private void authenticate() {
        String  user = pref.getString("Username", "");
        String   pass = pref.getString("Password", "");
        if(!user.equalsIgnoreCase("")&&!user.equalsIgnoreCase(null)){
            if(!pass.equalsIgnoreCase("")&&!pass.equalsIgnoreCase(null)){
                Intent i = new Intent(SplashActivity.this, Profile.class);
                startActivity(i);
                finish();
            }
        }else{
            Intent i = new Intent(SplashActivity.this, Login.class);
            startActivity(i);
            finish();
        }
    }

}
