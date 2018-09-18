package com.example.senthil.dirver1.Activty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.senthil.dirver1.Login;
import com.example.senthil.dirver1.Pojo.DRSListData;
import com.example.senthil.dirver1.Pojo.ForgetPojo;
import com.example.senthil.dirver1.Pojo.RrgPojo;
import com.example.senthil.dirver1.Profile;
import com.example.senthil.dirver1.R;
import com.example.senthil.dirver1.Retrofit.APIClient;
import com.example.senthil.dirver1.Retrofit.APIInterface;
import com.example.senthil.dirver1.Utilits.AppConstants;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeliveryUpdate extends AppCompatActivity {
    @BindView(R.id.trackID)EditText TrackID;
    @BindView(R.id.shipementDetails)Spinner shipementDetails;

    SharedPreferences pref;
    APIInterface apiInterface;
String delDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        DRSListData en=new DRSListData();
        if (extras != null) {
            en = (DRSListData) getIntent().getSerializableExtra("Data"); //Obtaining data
        }
     TrackID.setText(en.getTrack_id());
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.DeliveryStatus, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shipementDetails.setAdapter(adapter);
        shipementDetails.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                delDetails=shipementDetails.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void GetDerlieryUpdate(View view) {
        String trackId=TrackID.getText().toString();
        serverCall(trackId,delDetails);
    }

    private void serverCall(String trackId, String delDetails) {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ForgetPojo> call2 = apiInterface.updateDeliveryStatus(trackId,delDetails);
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(DeliveryUpdate.this);
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
                        Intent i=new Intent(DeliveryUpdate.this,DRSList.class);
                        startActivity(i);
                        finish();
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
