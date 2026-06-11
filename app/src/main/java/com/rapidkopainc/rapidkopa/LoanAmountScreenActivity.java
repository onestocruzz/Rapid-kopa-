package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class LoanAmountScreenActivity extends AppCompatActivity {
    private Button button1;
    ProgressDialog dialog;
    private EditText emailEditText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loanamount);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);
        
        this.emailEditText = (EditText) findViewById(R.id.name);
        this.button1 = (Button) findViewById(R.id.request_loan);


        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoanAmountScreenActivity.this._checkLogin();

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

        String email = this.emailEditText.getText().toString();
        if (!isValidEmail(email)) {
            this.emailEditText.setError("Request atleast Ksh.500");
        }


        if (isValidEmail(email) ) {
            this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Requesting Loan...", true);
            this.dialog.show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    LoanAmountScreenActivity.this.dialog.dismiss();
                    LoanAmountScreenActivity.this.getting();
                }
            }, 3000);
        }
    }

    public void getting() {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please wait just a moment...", true);

        this.dialog.show();
        new Handler().postDelayed(() -> {
            LoanAmountScreenActivity.this.dialog.dismiss();
            LoanAmountScreenActivity.this.fdback();
        }, 1000);
    }

    public void fdback() {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Request Submitted...", true);
        this.dialog.show();
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,() -> {

                showInterAd();

        });
    }




    private boolean isValidEmail(String email) {
        if (email == null || email.length() < 3) {
            return false;
        }
        return true;
    }
    public void showInterAd() {
            this.dialog.dismiss();
            Intent intent= new Intent();
            intent.setClass(LoanAmountScreenActivity.this, CommitmentScreenActivity.class);
            startActivity(intent);
        }

}
