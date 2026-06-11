package com.rapidkopainc.rapidkopa;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class CRBProvidersScreenActivity extends AppCompatActivity {
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crbproviders);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle(getResources().getString(R.string.crb_prov));

    }

    public void next(View arg0) {
        startActivity(new Intent(this, CRBProvider1Activity.class));
          }
    public void nextb(View arg0){
        startActivity(new Intent(this, CRBProvider2Activity.class));
    }
    public void nexta(View arg0) {
        startActivity(new Intent(this, CRBProvider3Activity.class));
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
