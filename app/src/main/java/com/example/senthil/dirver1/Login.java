package com.example.senthil.dirver1;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.senthil.dirver1.Activty.Register;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.internal.Utils;

public class Login extends AppCompatActivity {
     @BindView(R.id.email) EditText UserName;
     @BindView(R.id.password) EditText PassWord;
     @BindView(R.id.email_sign_in_button) Button login;
     @BindView(R.id.forgotPassword) TextView forgotPassword;
     @BindView(R.id.Register) TextView Register1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }

    public void getRegister(View view) {
      Intent i=new Intent(Login.this,Register.class);
      startActivity(i);
      finish();
    }

    public void getpassWord(View view) {
        Log.e("ForGot PassWord","Click action");
    }

    public void getLogin(View view) {

        String userName=UserName.getText().toString();
        String password=PassWord.getText().toString();
         validate(userName,password);

    }

    private void validate(String userName, String password) {
       if(userName.equalsIgnoreCase("")){
           UserName.setError("Enter UserName");
       }else if(password.equalsIgnoreCase("")){
           PassWord.setError("Enter Password");
       }else{
           if(userName.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin")){
               Intent i=new Intent(Login.this,Profile.class);
               startActivity(i);
               finish();
           }
       }
       
      

    }


}
