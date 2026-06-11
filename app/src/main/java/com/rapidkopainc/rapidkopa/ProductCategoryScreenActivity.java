package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class ProductCategoryScreenActivity extends AppCompatActivity {

    private static final String TAG = ProductCategoryScreenActivity.class.getSimpleName();
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productcategoriesscreen);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}







