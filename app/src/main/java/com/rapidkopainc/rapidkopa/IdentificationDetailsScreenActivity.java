package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;



public class IdentificationDetailsScreenActivity extends AppCompatActivity {
    ProgressDialog dialog;
    Toolbar mToolbar;
    TextView textView;
    private EditText nd_;
    private EditText uphone;



    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar1);
        textView = (TextView) findViewById(R.id.tvCountry);


        this.button1 = (Button) findViewById(R.id.request_loan);
        this.uphone = (EditText) findViewById(R.id.phone);
        this.nd_ = (EditText) findViewById(R.id.nd);
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                IdentificationDetailsScreenActivity.this._checkLogin();
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
        String phn = this.uphone.getText().toString();
        if (!isValidPhone(phn)) {
            this.uphone.setError("Incorrect Mobile number!");
        }

        String nd = this.nd_.getText().toString();
        if (!isValidID(nd)) {
            this.nd_.setError("Invalid National ID!");
        }


        if (isValidPhone(phn)  && isValidID(nd)) {
            this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Verifying details...", true);
            this.dialog.show();
            new Handler().postDelayed(() -> {
                IdentificationDetailsScreenActivity.this.dialog.dismiss();
                IdentificationDetailsScreenActivity.this.fdback();
            }, 2000);
        }
    }


    public void fdback() {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please wait just a moment...", true);
        this.dialog.show();
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,() -> showInterAd());
    }

    private boolean isValidPhone(String phn) {
        if (phn == null || phn.length() < 10 || phn.length() > 15) {
            return false;
        }
        return true;
    }

    private boolean isValidID(String nd) {
        if (nd == null || nd.length() < 1 || nd.length() > 20) {
            return false;
        }
        return true;
    }
    public void showInterAd() {
            this.dialog.dismiss();
            Intent intent= new Intent();
            intent.setClass(IdentificationDetailsScreenActivity.this, LoanPurposeScreenActivity.class);
            startActivity(intent);
   
    }

}
