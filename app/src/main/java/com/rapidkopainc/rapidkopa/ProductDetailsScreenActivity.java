package com.rapidkopainc.rapidkopa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ProductDetailsScreenActivity extends AppCompatActivity {
    private TextView txtPhoneName;
    private MaterialButton btnProceed;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phones_details);
        txtPhoneName = findViewById(R.id.txtPhoneName);
        btnProceed = findViewById(R.id.btnProceed);

        String phoneName = getIntent().getStringExtra("phoneName");
        txtPhoneName.setText(phoneName);


    }
}