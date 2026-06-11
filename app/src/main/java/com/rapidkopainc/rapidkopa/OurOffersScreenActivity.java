package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;



public class OurOffersScreenActivity extends AppCompatActivity {


    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ouroffers);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);


    }

    public void next(View arg0) {

        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,new Runnable() {
            @Override
            public void run() {

                showInterAd();
            }
        }
        );

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onDestroy() {
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
        super.onDestroy();
    }
    public void showInterAd() {
            OurOffersScreenActivity.this.dialog.dismiss();
            Intent intent= new Intent();
            intent.setClass(OurOffersScreenActivity.this, LogRegScreenActivity.class);
            startActivity(intent);
        }


}







