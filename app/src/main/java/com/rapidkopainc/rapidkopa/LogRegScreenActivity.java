package com.rapidkopainc.rapidkopa;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;



public class LogRegScreenActivity extends AppCompatActivity {


    ProgressDialog dialog;
    SharedPreferences pref;
    int activity = 0;
    int x = 0;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logreg);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);


        pref = getSharedPreferences("PROJECT_NAME", Context.MODE_PRIVATE);

    }





    public void login(View arg0) {
        activity=0;
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this , () -> {


            showInterAd();
        });
    }

    public void register(View arg0) {
        activity=1;
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this , () -> {


            showInterAd();
        });

    }

    
    @Override
    protected void onDestroy() {
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
        super.onDestroy();
    }
    public void showInterAd() {
        LogRegScreenActivity.this.dialog.dismiss();

            if ( activity==0 )
            {
                onLoginClick();
            }
            else if ( activity==1 )
            {
                 onRegisterClick();
            }

    }

   private void onLoginClick (){
        Intent intent= new Intent();
        intent.setClass(LogRegScreenActivity.this, LoginScreenActivity.class);
        startActivity(intent);
    }

   private void onRegisterClick (){
        Intent intent= new Intent();
        intent.setClass(LogRegScreenActivity.this, OtpCodeScreenActivity.class);
        startActivity(intent);
    }

}
