package com.example.senthil.dirver1.Activty;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.bumptech.glide.Priority;
import com.example.senthil.dirver1.Login;
import com.example.senthil.dirver1.Pojo.RegisterPoJo;
import com.example.senthil.dirver1.Pojo.RegisterationPojo;
import com.example.senthil.dirver1.Profile;
import com.example.senthil.dirver1.R;
import com.example.senthil.dirver1.Retrofit.APIClient;
import com.example.senthil.dirver1.Retrofit.APIInterface;
import com.example.senthil.dirver1.Utilits.NetworkState;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.name)EditText regName;
    @BindView(R.id.country)EditText regCountry;
    @BindView(R.id.state)EditText regState;
    @BindView(R.id.code)EditText regCode;
    @BindView(R.id.mobileNo) EditText regMobile;
    @BindView(R.id.email)EditText regEmail;
    @BindView(R.id.iqamaId)EditText regIqamaId;
    @BindView(R.id.uploadIqamaId)TextView regUpladIqmaID;
            @BindView(R.id.lincence)TextView regLicence;
            @BindView(R.id.vehicle_type)EditText regVehicleType;
            @BindView(R.id.supplier)EditText regSupplier;
            @BindView(R.id.date)TextView date;
            @BindView(R.id.reg_password)EditText regPassword;
            @BindView(R.id.vehicle_number)EditText RegVehicleNumber;
            @BindView(R.id.profile)TextView profilepath;

            String fileName="Profile.png";


    APIInterface apiInterface;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    private ProgressDialog pDialog;
    NetworkState myNet;
    NoInternetDialog noInternetDialog;
    RegisterPoJo registerPoJo=new RegisterPoJo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        noInternetDialog = new NoInternetDialog.Builder(Register.this).build();
        myNet=new NetworkState(Register.this);
        AndroidNetworking.initialize(getApplicationContext());
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

    public void getRegisteration(View view) {
        RegisterPoJo registerPoJo =new RegisterPoJo();
        registerPoJo.setRegName(regName.getText().toString());
        registerPoJo.setRegCountry(regCountry.getText().toString());
        registerPoJo.setRegState(regState.getText().toString());
        registerPoJo.setRegCode(regCode.getText().toString());
        registerPoJo.setRegMobile(regMobile.getText().toString());
        registerPoJo.setRegEmail(regEmail.getText().toString());
        registerPoJo.setRegIqamaId(regIqamaId.getText().toString());
        registerPoJo.setRegUpladIqmaID(regUpladIqmaID.getText().toString());
        registerPoJo.setRegLicence(regLicence.getText().toString());
        registerPoJo.setRegVehicleType(regVehicleType.getText().toString());
        registerPoJo.setRegSupplier(regSupplier.getText().toString());
        registerPoJo.setDate(date.getText().toString());
        registerPoJo.setProfilepath(profilepath.getText().toString());
        registerPoJo.setRegVehicleNumber(RegVehicleNumber.getText().toString());
        registerPoJo.setRegPassword(regPassword.getText().toString());
       Gson gson = new Gson();
        String json = gson.toJson(registerPoJo);
        Log.e("Json",json);
        ServerCall(json);

    }


    private void ServerCall(String json) {

        apiInterface = APIClient.getClient().create(APIInterface.class);
       /* Call<RegisterationPojo> call2 = apiInterface.RegisterPost( json.getRegName(),json.getRegCountry(),json.getRegState(),json.getRegCode(),
                json.getRegMobile(),json.getRegEmail(),json.getRegIqamaId(),json.getRegUpladIqmaID(),json.getRegLicence(),
                json.getRegVehicleType(),json.getRegSupplier(),json.getDate(),json.getRegPassword(),json.getRegVehicleNumber(),
                json.getProfilepath());*/

        Call<RegisterationPojo> call2 = apiInterface.RegisterPost1(json);
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(Register.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Loading....");
        progressDoalog.setTitle("Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
        call2.enqueue(new Callback<RegisterationPojo>() {


            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onResponse(Call<RegisterationPojo> call, Response<RegisterationPojo> response) {

                progressDoalog.dismiss();
                if(response.isSuccessful()) {
                    if (response.body().isStatus() == true) {
                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }else{
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
            public void onFailure(Call< RegisterationPojo> call, Throwable t) {
                Log.e("Error at server",t.toString());

            }
        });

    }




    public void getIQMAImage(View view) {
        selectImage();
        regUpladIqmaID.setText(fileName);
    }

    private void selectImage() {
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };



        AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);

        builder.setTitle("Add Photo!");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take Photo"))

                { Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");

                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));

                    startActivityForResult(intent, 1);

                }

                else if (options[item].equals("Choose from Gallery"))

                {

                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(intent, 2);



                }

                else if (options[item].equals("Cancel")) {

                    dialog.dismiss();

                }

            }

        });

        builder.show();
    }

    public void getProfileImg(View view) {
       // selectImage();
        profilepath.setText(fileName);
    }

    public void getDateofjoin(View view) {
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(Register.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        date.setText((month + 1) + "/" +day + "/" + year);
                    }
                }, year, month, dayOfMonth);

        datePickerDialog.show();
    }


    public void getLincenceImage(View view) {
        //selectImage();

        regLicence.setText(fileName);
    }

    @SuppressLint("LongLogTag")
    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == 1) {

                File f = new File(Environment.getExternalStorageDirectory().toString());

                for (File temp : f.listFiles()) {

                    if (temp.getName().equals("temp.jpg")) {

                        f = temp;

                        break;

                    }

                }

                try {

                    Bitmap bitmap;

                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();



                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),

                            bitmapOptions);







                    String path = android.os.Environment

                            .getExternalStorageDirectory()

                            + File.separator

                            + "Phoenix" + File.separator + "default";

                    f.delete();

                    OutputStream outFile = null;

                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    fileName=file.getName();

                    try {

                        outFile = new FileOutputStream(file);

                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);

                        outFile.flush();

                        outFile.close();

                       /* AndroidNetworking.upload(url)
                                .addMultipartFile("image",bitmap)
                                .addMultipartParameter("key","value")
                                .setTag("uploadTest")
                                .setPriority(Priority.HIGH)
                                .build()
                                .setUploadProgressListener(new UploadProgressListener() {
                                    @Override
                                    public void onProgress(long bytesUploaded, long totalBytes) {
                                        // do anything with progress
                                    }
                                })
                                .getAsJSONObject(new JSONObjectRequestListener() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        // do anything with response
                                    }
                                    @Override
                                    public void onError(ANError error) {
                                        // handle error
                                    }
                                });*/

                    } catch (FileNotFoundException e) {

                        e.printStackTrace();

                    } catch (IOException e) {

                        e.printStackTrace();

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

                } catch (Exception e) {

                    e.printStackTrace();

                }

            } else if (requestCode == 2) {



                Uri selectedImage = data.getData();

                String[] filePath = { MediaStore.Images.Media.DATA };

                Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);

                c.moveToFirst();

                int columnIndex = c.getColumnIndex(filePath[0]);

                String picturePath = c.getString(columnIndex);

                c.close();

                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));

                Log.w("path of image from gallery......******************.........", picturePath+"");

              /*  AndroidNetworking.upload(url)
                        .addMultipartFile("image",thumbnail)
                        .addMultipartParameter("key","value")
                        .setTag("uploadTest")
                        .setPriority(Priority.HIGH)
                        .build()
                        .setUploadProgressListener(new UploadProgressListener() {
                            @Override
                            public void onProgress(long bytesUploaded, long totalBytes) {
                                // do anything with progress
                            }
                        })
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // do anything with response
                            }
                            @Override
                            public void onError(ANError error) {
                                // handle error
                            }
                        });*/

            }

        }

    }
}
