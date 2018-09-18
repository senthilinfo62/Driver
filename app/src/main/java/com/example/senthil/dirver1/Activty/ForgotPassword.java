package com.example.senthil.dirver1.Activty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.senthil.dirver1.Login;
import com.example.senthil.dirver1.Pojo.ForGotPojo;
import com.example.senthil.dirver1.Pojo.ForgetPojo;
import com.example.senthil.dirver1.Pojo.RrgPojo;
import com.example.senthil.dirver1.Profile;
import com.example.senthil.dirver1.R;
import com.example.senthil.dirver1.Retrofit.APIClient;
import com.example.senthil.dirver1.Retrofit.APIInterface;
import com.example.senthil.dirver1.Utilits.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends AppCompatActivity {

@BindView(R.id.forgotEmail)EditText Emailid;
@BindView(R.id.forgotPassword)EditText password;
@BindView(R.id.forgotconfirmPassword)EditText confirmPassword;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        String sessionId= getIntent().getStringExtra("email");
        Emailid.setText(sessionId);

    }

    public void getForGotPassword(View view) {
        ForGotPojo forGotPojo=new ForGotPojo();
        forGotPojo.setEmailid(Emailid.getText().toString());
        forGotPojo.setPassword(password.getText().toString());
        forGotPojo.setConfirmpassword(confirmPassword.getText().toString());
        if(forGotPojo.getPassword().equalsIgnoreCase(forGotPojo.getConfirmpassword())){
            forGotPojo.setFinalpassword(confirmPassword.getText().toString());
            serverCall(forGotPojo.getEmailid(),forGotPojo.getFinalpassword());

        }else{
            Toast.makeText(getApplicationContext(),"Password Mismatch",Toast.LENGTH_SHORT).show();
        }
    }

    private void serverCall(String emailid, String finalpassword) {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ForgetPojo> call2 = apiInterface.ForgotPost(emailid,finalpassword);
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(ForgotPassword.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Loading....");
        progressDoalog.setTitle("Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
        call2.enqueue(new Callback<ForgetPojo>() {


            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onResponse(Call<ForgetPojo> call, Response<ForgetPojo> response) {

                progressDoalog.dismiss();
                if(response.isSuccessful()) {
                    if(response.body().getStatus()==true){
                        Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),Login.class);
                        startActivity(i);

                    }else{
                        Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }else {
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(getApplicationContext(), "not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(getApplicationContext(), "server broken", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(getApplicationContext(), "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }



            }

            @Override
            public void onFailure(Call<ForgetPojo> call, Throwable t) {
                Log.e("Error at server",t.toString());

            }
        });

    }
}
