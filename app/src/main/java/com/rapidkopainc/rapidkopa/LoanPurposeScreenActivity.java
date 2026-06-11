package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class LoanPurposeScreenActivity extends AppCompatActivity {
    ProgressDialog dialog;

    private Button button1;
    private EditText passEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loanpurpose);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);

        this.button1 = (Button) findViewById(R.id.button1);
        this.passEditText = (EditText) findViewById(R.id.reason);
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoanPurposeScreenActivity.this._checkLogin();
            }
        });
    }

    @Override
    protected void onDestroy() {
    AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
    AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
    super.onDestroy();

      
       
    }
    public void _checkLogin() {
        String phn = this.passEditText.getText().toString();
        if (!isValidPhone(phn)) {
            this.passEditText.setError("Use short description!");
        }


        if (isValidPhone(phn)){
            this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Recording data...", true);
            this.dialog.show();
            new Handler().postDelayed(() -> {
                LoanPurposeScreenActivity.this.dialog.dismiss();
                LoanPurposeScreenActivity.this.getting();
            }, 2000);
        }
    }
    public void showInterAd() {
            this.dialog.dismiss();
            Intent intent= new Intent();
            intent.setClass(LoanPurposeScreenActivity.this, LoanAmountScreenActivity.class);
            startActivity(intent);
        
    }

    public void getting() {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Data saved...", true);
        this.dialog.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                LoanPurposeScreenActivity.this.dialog.dismiss();
                LoanPurposeScreenActivity.this.fdback();
            }
        }, 2000);
    }

    public void fdback() {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please wait as we finish...", true);
        this.dialog.show();
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,() -> {
            showInterAd();

        });
    }

    private boolean isValidPhone(String phn) {
        if (phn == null || phn.length() < 4 || phn.length() > 15) {
            return false;
        }
        return true;
    }
}
