package com.rapidkopainc.rapidkopa;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LoanStatusScreenActivity extends AppCompatActivity {

    ProgressDialog dialog;


    public LoanStatusScreenActivity() {
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loanstatus);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);


    }
    public void back(View arg0) {
        LoanStatusScreenActivity.this.startActivity(new Intent(LoanStatusScreenActivity.this, HomeScreenActivity.class));
    }

    public void reapply(View arg0) {
        dialog = ProgressDialog.show(LoanStatusScreenActivity.this, CommonConfigs.FLAVOR, "Loading...", true);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                LoanStatusScreenActivity.this.dialog.dismiss();
                showInterAd();
                LoanStatusScreenActivity.this.startActivity(new Intent(LoanStatusScreenActivity.this, TermsAndConditionsScreenActivity.class));
            }
        }, 3000);

    }


    @Override
    protected void onDestroy() {

        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        super.onDestroy();
    }
    public void showInterAd() {

            LoanStatusScreenActivity.this.startActivity(new Intent(LoanStatusScreenActivity.this, TermsAndConditionsScreenActivity.class));

    }

}