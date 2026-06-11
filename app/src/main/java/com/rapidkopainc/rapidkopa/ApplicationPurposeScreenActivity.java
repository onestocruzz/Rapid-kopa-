package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;


public class ApplicationPurposeScreenActivity extends AppCompatActivity {
    ProgressDialog dialog;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_applicationpurpose);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);

    }

    public void next(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Saving .. Please Wait...", true);
        this.dialog.show();
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,() -> {
            showInterAd();

        });

    }
    public void back(View arg0) {
        startActivity(new Intent(this, EducationalLevelScreenActivity.class));
    }
    private boolean isValidName(String un) {
        if (un == null || un.length() < 4) {
            return false;
        }
        return true;
    }
    public void showInterAd() {
            this.dialog.dismiss();
            Intent intent= new Intent();
            intent.putExtra("type", "loans");
            intent.setClass(ApplicationPurposeScreenActivity.this, IncomeDetailsScreenActivity.class);
            startActivity(intent);
        }

    @Override
    protected void onDestroy() {
        AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        super.onDestroy();
      

    }
}
