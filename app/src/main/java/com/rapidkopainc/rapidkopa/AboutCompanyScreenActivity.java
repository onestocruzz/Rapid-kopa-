package com.rapidkopainc.rapidkopa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AboutCompanyScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutcompany);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);
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
