package com.example.senthil.dirver1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;

public class Profile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.userProfile) ImageView imageView;
    @BindView(R.id.userProfileName)TextView profileName;
    @BindView(R.id.userProfileEmail)TextView profileEmail;
    @BindView(R.id.CourierId)TextView courierId;
    @BindView(R.id.VericleNo)TextView vericleNo;
    @BindView(R.id.MobileNo)TextView mobileNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getUpdateUser(View view) {
        Intent pickHistory=new Intent(Profile.this,EditProfile.class);
        startActivity(pickHistory);

    }
}
