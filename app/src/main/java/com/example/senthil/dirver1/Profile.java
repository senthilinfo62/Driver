package com.example.senthil.dirver1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.senthil.dirver1.Activty.DRSHistory;
import com.example.senthil.dirver1.Activty.DRSList;
import com.example.senthil.dirver1.Activty.Dashboard;
import com.example.senthil.dirver1.Activty.PickupHistory;
import com.example.senthil.dirver1.Activty.PickupList;
import com.example.senthil.dirver1.Activty.ScanDRS;
import com.example.senthil.dirver1.Activty.Scanpickup;
import com.example.senthil.dirver1.Pojo.RrgPojo;
import com.example.senthil.dirver1.Pojo.User_data;
import com.example.senthil.dirver1.Retrofit.APIClient;
import com.example.senthil.dirver1.Retrofit.APIInterface;
import com.example.senthil.dirver1.Utilits.AppConstants;

import java.time.LocalDate;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.userProfile) ImageView imageView;
    @BindView(R.id.userProfileName)TextView profileName;
    @BindView(R.id.userProfileEmail)TextView profileEmail;
    @BindView(R.id.CourierId)TextView courierId;
    @BindView(R.id.VericleNo)TextView vericleNo;
    @BindView(R.id.MobileNo)TextView mobileNo;
    APIInterface apiInterface;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        pref = getSharedPreferences("Hyper", MODE_PRIVATE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView =  navigationView.getHeaderView(0);
        SharedPreferences pref;
        pref = getSharedPreferences("Hyper", MODE_PRIVATE);

        TextView nav_user = hView.findViewById(R.id.username);
        nav_user.setText(pref.getString("UserName",""));
        TextView nav_email = hView.findViewById(R.id.email);
        nav_email.setText(pref.getString("Username",""));
        final ImageView imageView = hView.findViewById(R.id.imageView);

        Servercall();
    }

    private void Servercall() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        String  user = pref.getString("Username", "");
        String   pass = pref.getString("Password", "");
        Call<RrgPojo> call2 = apiInterface.LoginPost(user,pass);
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(Profile.this);
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
                 if(response.body().getStatus()==true) {
                     profileName.setText(response.body().getUser_dataObject().getName());
                     profileEmail.setText(response.body().getUser_dataObject().getEmail());
                     courierId.setText(response.body().getUser_dataObject().getIqama_id());
                     vericleNo.setText(response.body().getUser_dataObject().getVehicle_number());
                     String img=response.body().getUser_dataObject().getProfile_image();
                     Log.e("imf",img+"\n"+"http://www.alitco.co/alitco/cabxy/doctor/assets/images/courier/"+img);

                     mobileNo.setText(response.body().getUser_dataObject().getMobile());

                     Glide.with(Profile.this).load("http://www.alitco.co/alitco/cabxy/doctor/assets/images/courier/"+img).asBitmap().centerCrop().into(new BitmapImageViewTarget(((Profile.this)).imageView) {
                         @Override
                         protected void setResource(Bitmap resource) {
                             RoundedBitmapDrawable circularBitmapDrawable =
                                     RoundedBitmapDrawableFactory.create(Profile.this.getResources(), resource);
                             circularBitmapDrawable.setCircular(true);
                             imageView.setImageDrawable(circularBitmapDrawable);
                         }
                     });
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
            public void onFailure(Call<RrgPojo> call, Throwable t) {
                Log.e("Error at server",t.toString());

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            Intent dash=new Intent(Profile.this,Dashboard.class);
            startActivity(dash);
            finish();

        } else if (id == R.id.nav_profile) {
            Intent profile=new Intent(Profile.this,Profile.class);
            startActivity(profile);

        } else if (id == R.id.nav_DRSList) {
            Intent drsList=new Intent(Profile.this,DRSList.class);
            startActivity(drsList);

        } else if (id == R.id.nav_DRSHistory) {
            Intent drsHistory=new Intent(Profile.this,DRSHistory.class);
            startActivity(drsHistory);

        } else if (id == R.id.nav_scanPickup) {
            Intent scanPickup=new Intent(Profile.this,Scanpickup.class);
            startActivity(scanPickup);

        } else if (id == R.id.nav_scanDrs) {
            Intent scanDrs=new Intent(Profile.this,ScanDRS.class);
            startActivity(scanDrs);

        }else if (id == R.id.nav_pickupList) {
            Intent pickUpList=new Intent(Profile.this,PickupList.class);
            startActivity(pickUpList);
        }else if (id == R.id.nav_pickuphistory) {
            Intent pickHistory=new Intent(Profile.this,PickupHistory.class);
            startActivity(pickHistory);
        }else if (id == R.id.nav_logout) {
            SharedPreferences pref = getSharedPreferences("Hyper", MODE_PRIVATE);
            SharedPreferences.Editor et = pref.edit();
            et.remove("Username");
            et.remove("Password");
            et.commit();
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getUpdateUser(View view) {
        Intent pickHistory=new Intent(Profile.this,EditProfile.class);
        pickHistory.putExtra("name",profileName.getText().toString());
        pickHistory.putExtra("mobile",mobileNo.getText().toString());
        pickHistory.putExtra("verchleNo",vericleNo.getText().toString());
        pickHistory.putExtra("email",profileEmail.getText().toString());

        startActivity(pickHistory);

    }
}
