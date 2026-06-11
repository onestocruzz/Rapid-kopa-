package com.rapidkopainc.rapidkopa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;

public class CRBProvider2Activity extends AppCompatActivity {
    Toolbar toolbar;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crbprovider2);

        toolbar = findViewById(R.id.toolbar1);
        toolbar.setTitle(getResources().getString(R.string.crb_prov2));
        textView=(TextView)findViewById(R.id.tvCountry);
        textView.setText(getResources().getString(R.string.crbb_prov2));



    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
