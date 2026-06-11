package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class BriefAboutScreenActivity extends AppCompatActivity {

    private static final String TAG = BriefAboutScreenActivity.class.getSimpleName();
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brief_about);

       }


    public void next(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BriefAboutScreenActivity.this.dialog.dismiss();
                showInterAd();

            }
        }, 1900);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
      
       

    }
    public void showInterAd() {

            Intent intent= new Intent();
            intent.setClass(BriefAboutScreenActivity.this, TJHomeScreenActivity.class);
            startActivity(intent);

    }

}







