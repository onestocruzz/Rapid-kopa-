package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class TJHomeScreenActivity extends AppCompatActivity {
    private static final String TAG = TJHomeScreenActivity.class.getSimpleName();
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tjhomescreen);
        
        //findviews


       }


    public void next(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TJHomeScreenActivity.this.dialog.dismiss();
                showInterAd(1);

            }
        }, 1900);

    }

    public void next1(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TJHomeScreenActivity.this.dialog.dismiss();
                showInterAd(2);

            }
        }, 1900);

    }
    public void next2(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
        this.dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TJHomeScreenActivity.this.dialog.dismiss();
                showInterAd(3);

            }
        }, 1900);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


    }


    public void showInterAd(int destination) {

            Intent intent= new Intent();
            switch (destination){
                case 1:
                    Log.i("Nav","Failed to navigate");
                    startActivity(new Intent( TJHomeScreenActivity.this, ProductCategoryScreenActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(TJHomeScreenActivity.this, ProductsScreenActivity.class));
                break;
                case 3:
                    startActivity(new Intent(TJHomeScreenActivity.this,AboutCompanyScreenActivity1.class));

                    break;
                default:
                    Log.i("Nav","Failed to navigate");
                    break;
            }


    }

}






