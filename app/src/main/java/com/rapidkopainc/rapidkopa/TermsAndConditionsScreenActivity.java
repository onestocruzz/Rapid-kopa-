package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.util.Log;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;



public class TermsAndConditionsScreenActivity extends AppCompatActivity {

    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termsandconditions);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);



        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                Log.i("Terms","Back button has been pressed");
               goHome();
            }
        };

getOnBackPressedDispatcher().addCallback(this,
        callback);
    }


    @Override
    protected void onDestroy() {
        AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        super.onDestroy();

    }
    public void proceed(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,() -> {
            TermsAndConditionsScreenActivity.this.dialog.dismiss();
            showInterAd();

        });

    }

    public void goHome() {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        new Handler().postDelayed(() -> {
            TermsAndConditionsScreenActivity.this.dialog.dismiss();
            Intent intent= new Intent();
            intent.setClass(TermsAndConditionsScreenActivity.this, HomeScreenActivity.class);
            startActivity(intent);

        }, 1500);

    }
    public void cancel(View arg0) {

        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);

       goHome();

    }

    public void showInterAd() {
            this.dialog.dismiss();
            Intent intent= new Intent();
            intent.setClass(TermsAndConditionsScreenActivity.this, FirstTimeUserScreenActivity.class);
            startActivity(intent);

    }

}
