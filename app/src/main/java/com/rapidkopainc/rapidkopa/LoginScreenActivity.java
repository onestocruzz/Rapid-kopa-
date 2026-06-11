package com.rapidkopainc.rapidkopa;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import java.util.regex.Pattern;

public class LoginScreenActivity extends AppCompatActivity {

    ProgressDialog dialog;

    SharedPreferences pref;
    SharedPreferences.Editor editor;


    //email and pass
    String email, pass;
    private EditText emailEditText;
    private EditText passEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);
        pref = getSharedPreferences("PROJECT_NAME", Context.MODE_PRIVATE);
        editor = pref.edit();


        this.emailEditText = (EditText) findViewById(R.id.loanamount);
        this.passEditText = (EditText) findViewById(R.id.password);


    }




    protected void onDestroy() {
        AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        super.onDestroy();
    }

private void launchWelcomeMessageScreen(){
    Intent intent= new Intent();
    intent.setClass(LoginScreenActivity.this,WelcomeMessageScreenActivity.class);
    startActivity(intent);
}

private void launchHomeScreen(){

    Intent intent= new Intent();
    intent.setClass(LoginScreenActivity.this, HomeScreenActivity.class);
    startActivity(intent);
}

public  void credentialsChecker()
{
   // Log.i("Credential","\n\nEMAIL\t"+email+"\nPASSWORD\t"+pass);



  //  Log.i("Credential_C","Credentials returned\t"+Boolean.toString(Credentials.loginCredentialsCheck(email,pass)));

    /**/
    //loginCheck😆😆
    if(Credentials.loginCredentialsCheck(email,pass)){

        launchWelcomeMessageScreen();
    }
    else {
        if (pref.getString("status",null).trim().matches("inactive")){
            launchWelcomeMessageScreen();
        }
        else{
            launchHomeScreen();
        }
    }
}

    public void showInterAd() {
        LoginScreenActivity.this.dialog.dismiss();

        credentialsChecker();


    }

    public void registerMember(View arg0) {

        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please wait...", true);
        this.dialog.show();
        new Handler().postDelayed(() -> {
            LoginScreenActivity.this.dialog.dismiss();
            if (pref.getString("status",null).trim().matches("inactive")){
                Intent intent= new Intent();
                intent.setClass(LoginScreenActivity.this,RegistrationScreenActivity.class);
                startActivity(intent);
            }
            else{
                Intent intent= new Intent();
                intent.setClass(LoginScreenActivity.this, OtpCodeScreenActivity.class);
                startActivity(intent);
            }

        }, 1600);
    }
    public void checkLogin(View arg0) {

        email = this.emailEditText.getText().toString();
        if (!isValidEmail(email)) {
            this.emailEditText.setError("Invalid Email");
        }
        pass = this.passEditText.getText().toString();
        if (!isValidPassword(pass)) {
            this.passEditText.setError("Incorrect details try again");
        }
        if (isValidEmail(email) && isValidPassword(pass)) {
            this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Authenticating...", true);
            this.dialog.show();

            AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,()-> {

                    showInterAd();


            });
        }
    }

    private boolean isValidEmail(String email) {
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(email).matches();
    }
    private boolean isValidPassword(String pass) {
        if (pass == null || pass.length() < 4) {
            return false;
        }
        return true;
    }
}
