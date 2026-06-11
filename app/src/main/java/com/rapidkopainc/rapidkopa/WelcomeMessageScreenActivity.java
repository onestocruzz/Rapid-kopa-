package com.rapidkopainc.rapidkopa;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeMessageScreenActivity extends AppCompatActivity {

    private static final String TAG = WelcomeMessageScreenActivity.class.getSimpleName();
    ProgressDialog dialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_message);

       }


    public void next(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WelcomeMessageScreenActivity.this.dialog.dismiss();
                showInterAd();

            }
        }, 1900);

    }

    @Override
    public void onBackPressed(){
        this.builder = new AlertDialog.Builder(this, 3);
        this.builder.setTitle(getString(R.string.app_name));
        this.builder.setMessage("Please rate us well. Thank you");
        this.builder.setNegativeButton("RATE APP", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                try{

                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("market://details?id=" + WelcomeMessageScreenActivity.this.getPackageName()));
                    WelcomeMessageScreenActivity.this.startActivity(intent);

                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + WelcomeMessageScreenActivity.this.getPackageName())));
                }

                Toast.makeText(WelcomeMessageScreenActivity.this, "Thank you for your Rating", Toast.LENGTH_SHORT).show();
            }
        });
        this.builder.setPositiveButton("QUIT APP", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                {
                    Intent a = new Intent(Intent.ACTION_MAIN);
                    a.addCategory(Intent.CATEGORY_HOME);
                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(a);
                }
            }
        });
        this.builder.create().show();

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void showInterAd() {

            Intent intent= new Intent();
            intent.setClass(WelcomeMessageScreenActivity.this, BriefAboutScreenActivity.class);
            startActivity(intent);

    }

}







