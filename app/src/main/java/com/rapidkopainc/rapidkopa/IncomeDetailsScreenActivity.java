package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;


public class IncomeDetailsScreenActivity extends AppCompatActivity {
    ProgressDialog dialog;

    private String extra;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_incomedetails);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);
        extra = getIntent().getStringExtra("type");
    }

    public void next(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Saving .. Please Wait...", true);
        this.dialog.show();
       AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this, () -> showInterAd());
    }
    public void back(View arg0) {
        startActivity(new Intent(this, ApplicationPurposeScreenActivity.class));
    }
    public void showInterAd() {
                this.dialog.dismiss();
                Intent intent= new Intent();
                intent.setClass(IncomeDetailsScreenActivity.this, IncomeDetailsScreen1Activity.class);
                startActivity(intent);

        }

    @Override
    protected void onDestroy() {
        AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        super.onDestroy();
      

    }
}
