package com.rapidkopainc.rapidkopa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;


public class CRBInfoScreenActivity extends AppCompatActivity {
Toolbar toolbar;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crbinfo);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle(getResources().getString(R.string.crb_info));
        textView=(TextView)findViewById(R.id.tvCountry);
        textView.setText(getResources().getString(R.string.crb_detaik));


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
