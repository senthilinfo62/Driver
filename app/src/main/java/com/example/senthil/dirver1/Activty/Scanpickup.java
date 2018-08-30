package com.example.senthil.dirver1.Activty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.senthil.dirver1.Profile;
import com.example.senthil.dirver1.R;

public class Scanpickup extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanpickup);
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
            Intent dash=new Intent(Scanpickup.this,Dashboard.class);
            startActivity(dash);
            finish();

        } else if (id == R.id.nav_profile) {
            Intent profile=new Intent(Scanpickup.this,Profile.class);
            startActivity(profile);

        } else if (id == R.id.nav_DRSList) {
            Intent drsList=new Intent(Scanpickup.this,DRSList.class);
            startActivity(drsList);

        } else if (id == R.id.nav_DRSHistory) {
            Intent drsHistory=new Intent(Scanpickup.this,DRSHistory.class);
            startActivity(drsHistory);

        } else if (id == R.id.nav_scanPickup) {
            Intent scanPickup=new Intent(Scanpickup.this,Scanpickup.class);
            startActivity(scanPickup);

        } else if (id == R.id.nav_scanDrs) {
            Intent scanDrs=new Intent(Scanpickup.this,ScanDRS.class);
            startActivity(scanDrs);

        }else if (id == R.id.nav_pickupList) {
            Intent pickUpList=new Intent(Scanpickup.this,PickupList.class);
            startActivity(pickUpList);
        }else if (id == R.id.nav_pickuphistory) {
            Intent pickHistory=new Intent(Scanpickup.this,PickupHistory.class);
            startActivity(pickHistory);
        }else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}