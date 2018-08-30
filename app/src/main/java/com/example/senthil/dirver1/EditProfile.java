package com.example.senthil.dirver1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.senthil.dirver1.Activty.DRSHistory;
import com.example.senthil.dirver1.Activty.DRSList;
import com.example.senthil.dirver1.Activty.Dashboard;
import com.example.senthil.dirver1.Activty.PickupHistory;
import com.example.senthil.dirver1.Activty.PickupList;
import com.example.senthil.dirver1.Activty.ScanDRS;
import com.example.senthil.dirver1.Activty.Scanpickup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditProfile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.editUserName)TextView editUserName;
    @BindView(R.id.editMobileNo)TextView editMobileNo;
    @BindView(R.id.editvechileNo)TextView editVechileNo;
    @BindView(R.id.editEmail)TextView editEmail;
    @BindView(R.id.editpassword)EditText editPassword;
    @BindView(R.id.editConfirmPassword)EditText editConfirmPassword;
    @BindView(R.id.editbtn)Button updateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_profile, menu);
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
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_dashboard) {
            Intent dash=new Intent(EditProfile.this,Dashboard.class);
            startActivity(dash);
            finish();

        } else if (id == R.id.nav_profile) {
            Intent profile=new Intent(EditProfile.this,Profile.class);
            startActivity(profile);

        } else if (id == R.id.nav_DRSList) {
            Intent drsList=new Intent(EditProfile.this,DRSList.class);
            startActivity(drsList);

        } else if (id == R.id.nav_DRSHistory) {
            Intent drsHistory=new Intent(EditProfile.this,DRSHistory.class);
            startActivity(drsHistory);

        } else if (id == R.id.nav_scanPickup) {
            Intent scanPickup=new Intent(EditProfile.this,Scanpickup.class);
            startActivity(scanPickup);

        } else if (id == R.id.nav_scanDrs) {
            Intent scanDrs=new Intent(EditProfile.this,ScanDRS.class);
            startActivity(scanDrs);

        }else if (id == R.id.nav_pickupList) {
            Intent pickUpList=new Intent(EditProfile.this,PickupList.class);
            startActivity(pickUpList);
        }else if (id == R.id.nav_pickuphistory) {
            Intent pickHistory=new Intent(EditProfile.this,PickupHistory.class);
            startActivity(pickHistory);
        }else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getUpdatePassword(View view) {

    }
}
