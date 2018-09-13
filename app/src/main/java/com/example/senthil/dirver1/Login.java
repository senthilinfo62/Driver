package com.example.senthil.dirver1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
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

import com.example.senthil.dirver1.Activty.ForgotPassword;
import com.example.senthil.dirver1.Activty.Register;
import com.example.senthil.dirver1.Pojo.RrgPojo;
import com.example.senthil.dirver1.Retrofit.APIClient;
import com.example.senthil.dirver1.Retrofit.APIInterface;
import com.example.senthil.dirver1.Utilits.AppConstants;
import com.google.gson.JsonObject;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.internal.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.FormUrlEncoded;

public class Login extends AppCompatActivity {
     @BindView(R.id.email) EditText UserName;
     @BindView(R.id.password) EditText PassWord;
     @BindView(R.id.email_sign_in_button) Button login;
     @BindView(R.id.forgotPassword) TextView forgotPassword;
     @BindView(R.id.Register) TextView Register1;

    APIInterface apiInterface;
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
        Intent i=new Intent(getApplicationContext(), ForgotPassword.class);
        i.putExtra("email",UserName.getText().toString());
        startActivity(i);

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

           serverCall(userName,password);


       }
       
      

    }

    private void serverCall(final String userName, final String password) {

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<RrgPojo> call2 = apiInterface.LoginPost(userName,password);
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(Login.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Loading....");
        progressDoalog.setTitle("Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
        call2.enqueue(new Callback<RrgPojo>() {


            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onResponse(Call<RrgPojo> call, Response<RrgPojo> response) {

                progressDoalog.dismiss();
                if(response.isSuccessful()) {
                   if (response.body().getStatus()==true) {
                        AppConstants.userName=userName;
                        AppConstants.passWord=password;
                        Intent i = new Intent(Login.this, Profile.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }else {
                 Toast.makeText(getApplicationContext(),"Server Failed",Toast.LENGTH_LONG).show();
                }



            }

            @Override
            public void onFailure(Call<RrgPojo> call, Throwable t) {
                Log.e("Error at server",t.toString());

            }
        });

    }


}
