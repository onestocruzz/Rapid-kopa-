package com.rapidkopainc.rapidkopa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class InquiriesFormScreenActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener {
    ArrayAdapter adapter;
    Spinner grades;
    TextView textView;
    ProgressDialog dialog;
    Toolbar toolbar;

    int i = 0;
    int x = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiriesform);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle(getResources().getString(R.string.crb_form));

        grades = (Spinner)findViewById(R.id.spinnerCountries);
        textView = (TextView) findViewById(R.id.editTextPhone);

        adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);

        grades.setAdapter(adapter);
        grades.setOnItemSelectedListener(InquiriesFormScreenActivity.this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView spinner_text = (TextView) view;


        textView.setText(grades.getSelectedItem().toString());
    }
    public void next(View arg0) {
        this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "submitting message...",true);
        this.dialog.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                InquiriesFormScreenActivity.this.dialog.dismiss();
                Toast tt = Toast.makeText(InquiriesFormScreenActivity.this,"Message Submitted Successfully...Will Get Back to You Soon..", Toast.LENGTH_LONG);
                tt.setGravity(Gravity.CENTER, 0, 0);
                tt.show();
                InquiriesFormScreenActivity.this.startActivity(new Intent(InquiriesFormScreenActivity.this, HomeScreenActivity.class));
            }
        }, 4000);
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        super.onDestroy();

    }

}
