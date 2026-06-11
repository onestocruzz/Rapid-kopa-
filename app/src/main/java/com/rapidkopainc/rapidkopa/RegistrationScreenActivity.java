package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;



import java.util.regex.Pattern;

public class RegistrationScreenActivity extends AppCompatActivity {

    private EditText passEditText;

    private EditText uname;
    private CheckBox checkBox;
    boolean ckd = true;
    ProgressDialog dialog;
    private EditText emailEditText;

    private  String un,email,pass;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);

        this.emailEditText = (EditText) findViewById(R.id.loanamount);
        this.passEditText = (EditText) findViewById(R.id.password);
        this.uname = (EditText) findViewById(R.id.name);
        this.checkBox = (CheckBox) findViewById(R.id.checkbox_id);
    //        dbAdapter = new DBAdapter(this);
    //        dbHelper = new DBHelper(this);
    //        prefManager = new PrefManager(this);
             

        pref = getSharedPreferences("PROJECT_NAME", Context.MODE_PRIVATE);
        editor = pref.edit();

    }
    private void launchWelcomeMessageScreen(){
        Intent intent= new Intent();
        intent.setClass(RegistrationScreenActivity.this, WelcomeMessageScreenActivity.class);
        startActivity(intent);
    }

    private void launchTermsAncConditionsScreen(){

        Intent intent= new Intent();
        intent.setClass(RegistrationScreenActivity.this, TermsAndConditionsScreenActivity.class);
        startActivity(intent);
    }


    public  void credentialsChecker()
    {
     //   Log.i("Credential","\n\nEMAIL\t"+email+"\nPASSWORD\t"+pass);



      //  Log.i("Credential_C","Credentials returned\t"+Boolean.toString(Credentials.loginCredentialsCheck(email,pass)));

        /**/
        //registrationCheck😆😆
        if(Credentials.registrationCredentialsCheck(un,email,pass)){

            launchWelcomeMessageScreen();
        }
        else {
            if (pref.getString("status",null).trim().matches("inactive")){
                launchWelcomeMessageScreen();
            }
            else{
                launchTermsAncConditionsScreen();
            }
        }
    }

    @Override
    protected void onDestroy() {
        AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();

        super.onDestroy();

    }

    public void checkLogin(View arg0) {
        email = this.emailEditText.getText().toString();
        if (!isValidEmail(email)) {
            this.emailEditText.setError("Invalid Email!");
        }
        pass = this.passEditText.getText().toString();
        if (!isValidPassword(pass)) {
            this.passEditText.setError("Weak Password!");
        }

        un = this.uname.getText().toString();
        if (!isValidPassword(un)) {
            this.uname.setError("Incomplete Name!");
        }
        if (!chkBox()) {
            this.checkBox.setError("Agree to our terms!");
        }
        if (isValidEmail(email) && isValidPassword(pass) && chkBox()  && isValidName(un)) {
            this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Registering...", true);
            this.dialog.show();
            AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,() -> showInterAd());
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



    private boolean isValidName(String un) {
        if (un == null || un.length() < 4) {
            return false;
        }
        return true;
    }

    public boolean chkBox() {
        if (this.checkBox.isChecked()) {
            this.ckd = true;
        }
        if (!this.checkBox.isChecked()) {
            this.ckd = false;
        }
        return this.ckd;
    }
    public void showInterAd() {
    
            this.dialog.dismiss();
          credentialsChecker();


        }    
}
