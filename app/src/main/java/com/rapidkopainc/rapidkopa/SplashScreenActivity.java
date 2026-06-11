package com.rapidkopainc.rapidkopa;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SplashScreenActivity extends AppCompatActivity {

    InternetConnection cd;
    private final int SPLASH_DISPLAY_LENGTH = 2400;
    private Handler mHandler = new Handler();
    private PrefManager prefManager;

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String TAG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pref = getSharedPreferences("PROJECT_NAME", Context.MODE_PRIVATE);
        editor = pref.edit();

        cd = new InternetConnection(this);
        prefManager = new PrefManager(this);
        mHandler.postDelayed(new Runnable() {
        @Override
        public void run() {
            if (cd.isConnected()) {

                        launchGetStarted();

            } else {
                AlertDialog alertDialog = new AlertDialog.Builder(SplashScreenActivity.this).create();
                alertDialog.setTitle("ERROR..!!");
                alertDialog.setMessage("Ensure You are Connected To The Internet");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Connect",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                share();

                            }
                        });
                alertDialog.show();
            }
        }
        }, SPLASH_DISPLAY_LENGTH);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
   DatabaseReference myRef = database.getReference("status");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                pref.edit().remove("status").commit();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                //Toast.makeText(SplashScreenActivity.this, dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
                setAdsOption(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


//till name
        DatabaseReference myTillRef = database.getReference("tillname");

        myTillRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                pref.edit().remove("tillname").commit();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                //Toast.makeText(SplashScreenActivity.this, dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
                setTillname(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
//till number
        DatabaseReference myTillnum = database.getReference("tillnum");

        myTillnum.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                pref.edit().remove("tillnum").commit();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                //Toast.makeText(SplashScreenActivity.this, dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
                setTillnum(dataSnapshot.getValue(Integer.class));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


//bound
        DatabaseReference bound = database.getReference("bound");

        bound.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                pref.edit().remove("bound").commit();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                //Toast.makeText(SplashScreenActivity.this, dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
                setBound(dataSnapshot.getValue(Integer.class));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


//minamount
        DatabaseReference minAmount = database.getReference("minamount");

        minAmount.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                pref.edit().remove("minamount").commit();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                //Toast.makeText(SplashScreenActivity.this, dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
                setMinAmount(dataSnapshot.getValue(Integer.class));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void setAdsOption(String stat) {
        editor.putString("status", stat);
        editor.apply();

    }

    public void setTillname(String tilln) {
        editor.putString("tillname", tilln);
        editor.apply();

    }

    public void setTillnum(int tillnu) {
        editor.putInt("tillnum", tillnu);
        editor.apply();

    }
    public void setBound(int bound) {
        editor.putInt("bound", bound);
        editor.apply();

    }
    public void setMinAmount(int minamount) {
        editor.putInt("minamount", minamount);
        editor.apply();

    }

    private void launchGetStarted() {
        Intent intent= new Intent();
        intent.setClass(SplashScreenActivity.this, LogRegScreenActivity.class);
        startActivity(intent);
        finish();
    }



    private void share() {
        startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
    }

    // 6. Override onDestroy()
    @Override
    public void onDestroy() {

        // 7. Remove any delayed Runnable(s) and prevent them from executing.
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);

        // 8. Eagerly clear mHandler allocated memory
        mHandler = null;

    }
}