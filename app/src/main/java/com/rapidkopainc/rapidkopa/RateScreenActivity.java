package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RateScreenActivity extends AppCompatActivity {
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
    }

    public void next(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Searching for App in playstore...", true);
        this.dialog.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                RateScreenActivity.this.dialog.dismiss();
                RateScreenActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + RateScreenActivity.this.getPackageName())));
            }
        }, 3000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}







