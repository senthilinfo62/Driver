package com.example.senthil.dirver1.Activty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.senthil.dirver1.Adapter.DRSAdapter;
import com.example.senthil.dirver1.Adapter.PickupAdapter;
import com.example.senthil.dirver1.Desgin.SimpleDividerItemDecoration;
import com.example.senthil.dirver1.Login;
import com.example.senthil.dirver1.Pojo.DRSListPOjo;
import com.example.senthil.dirver1.Pojo.PickupPojo;
import com.example.senthil.dirver1.Profile;
import com.example.senthil.dirver1.R;
import com.example.senthil.dirver1.Retrofit.APIClient;
import com.example.senthil.dirver1.Retrofit.APIInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PickupList extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    APIInterface apiInterface;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private PickupAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);


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
        serverCall();
    }

    private void serverCall() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        String lanuage="en",divicetype="2";
        Call<PickupPojo> call2 = apiInterface.PickupList(lanuage,divicetype);
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(PickupList.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Loading....");
        progressDoalog.setTitle("Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
        call2.enqueue(new Callback<PickupPojo>() {


            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onResponse(Call<PickupPojo> call, Response<PickupPojo> response) {

                progressDoalog.dismiss();
                if(response.isSuccessful()) {
                    if (response.body().isStatus()==true) {
                        Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        mAdapter = new PickupAdapter(response.body().getPickup_data(),PickupList.this);
                        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(mLayoutManager);

                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(mAdapter);




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
            public void onFailure(Call<PickupPojo> call, Throwable t) {
                Log.e("Error at server",t.toString());

            }
        });
    }

   /* @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_dashboard) {
            Intent dash=new Intent(PickupList.this,Dashboard.class);
            startActivity(dash);
            finish();

        } else if (id == R.id.nav_profile) {
            Intent profile=new Intent(PickupList.this,Profile.class);
            startActivity(profile);

        } else if (id == R.id.nav_DRSList) {
            Intent drsList=new Intent(PickupList.this,DRSList.class);
            startActivity(drsList);

        } else if (id == R.id.nav_DRSHistory) {
            Intent drsHistory=new Intent(PickupList.this,DRSHistory.class);
            startActivity(drsHistory);

        } else if (id == R.id.nav_scanPickup) {
            Intent scanPickup=new Intent(PickupList.this,Scanpickup.class);
            startActivity(scanPickup);

        } else if (id == R.id.nav_scanDrs) {
            Intent scanDrs=new Intent(PickupList.this,ScanDRS.class);
            startActivity(scanDrs);

        }else if (id == R.id.nav_pickupList) {
            Intent pickUpList=new Intent(PickupList.this,PickupList.class);
            startActivity(pickUpList);
        }else if (id == R.id.nav_pickuphistory) {
            Intent pickHistory=new Intent(PickupList.this,PickupHistory.class);
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
}
