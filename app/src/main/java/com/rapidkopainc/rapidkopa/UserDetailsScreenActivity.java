package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;



public class UserDetailsScreenActivity extends AppCompatActivity {
    ProgressDialog dialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_userdetails);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);

    }

    public void next2(View arg0) {

        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Saving .. Please Wait...", true);
        this.dialog.show();
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,() -> showInterAd());

    }
    public void back(View arg0) {
        startActivity(new Intent(this, PhoneDetailsScreenActivity.class));
    }
    public void showInterAd() {
            this.dialog.dismiss();
            Intent intent= new Intent();
            intent.setClass(UserDetailsScreenActivity.this, EducationalLevelScreenActivity.class);
            startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        super.onDestroy();
      

    }
}
