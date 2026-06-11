package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class GetStartedScreenActivity extends AppCompatActivity{

    private static final String TAG = GetStartedScreenActivity.class.getSimpleName();
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);

       }


    public void next(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);

        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,new Runnable() {
            @Override
            public void run() {
                GetStartedScreenActivity.this.dialog.show();
                showInterAd();

            }
        });

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

            GetStartedScreenActivity.this.dialog.dismiss();
            Intent intent= new Intent();
            intent.setClass(GetStartedScreenActivity.this, OurOffersScreenActivity.class);
            startActivity(intent);

    }
}







