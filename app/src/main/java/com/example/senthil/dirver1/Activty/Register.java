package com.example.senthil.dirver1.Activty;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.senthil.dirver1.Profile;
import com.example.senthil.dirver1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Register extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.firstName)EditText firstName;
    @BindView(R.id.lastName)EditText lastName;
    @BindView(R.id.gender)Spinner gender;
    @BindView(R.id.dob)EditText bob;
    @BindView(R.id.imgdob)ImageButton imageButton;
    @BindView(R.id.email)EditText emailId;
    @BindView(R.id.contrycode)EditText countryCode;
    @BindView(R.id.phone)EditText phone;
    @BindView(R.id.language)Spinner language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
        String[] Gender=getResources().getStringArray(R.array.Gender);
        String[] Language=getResources().getStringArray(R.array.Language);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(aa);
        ArrayAdapter aaa = new ArrayAdapter(Register.this,android.R.layout.simple_spinner_item,Language);
        aaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        language.setAdapter(aaa);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            Intent dash=new Intent(Register.this,Dashboard.class);
            startActivity(dash);
            finish();

        } else if (id == R.id.nav_profile) {
            Intent profile=new Intent(Register.this,Profile.class);
            startActivity(profile);

        } else if (id == R.id.nav_DRSList) {
            Intent drsList=new Intent(Register.this,DRSList.class);
            startActivity(drsList);

        } else if (id == R.id.nav_DRSHistory) {
            Intent drsHistory=new Intent(Register.this,DRSHistory.class);
            startActivity(drsHistory);

        } else if (id == R.id.nav_scanPickup) {
            Intent scanPickup=new Intent(Register.this,Scanpickup.class);
            startActivity(scanPickup);

        } else if (id == R.id.nav_scanDrs) {
            Intent scanDrs=new Intent(Register.this,ScanDRS.class);
            startActivity(scanDrs);

        }else if (id == R.id.nav_pickupList) {
            Intent pickUpList=new Intent(Register.this,PickupList.class);
            startActivity(pickUpList);
        }else if (id == R.id.nav_pickuphistory) {
            Intent pickHistory=new Intent(Register.this,PickupHistory.class);
            startActivity(pickHistory);
        }else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getRegisteration(View view) {

    }

    public void getDob(View view) {
    }
}
