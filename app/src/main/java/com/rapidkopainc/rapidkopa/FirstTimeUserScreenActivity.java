package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FirstTimeUserScreenActivity extends AppCompatActivity {

 
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firsttime);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);
    }
    public void button11 (View arg0){
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,() -> showInterAd());

    }

    public void showInterAd() {
            this.dialog.dismiss();
            Intent intent= new Intent();
            intent.setClass(FirstTimeUserScreenActivity.this, PhoneDetailsScreenActivity.class);
            startActivity(intent);
        
    }

    @Override
    protected void onDestroy() {
        AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        super.onDestroy();

      
       

    }

}
