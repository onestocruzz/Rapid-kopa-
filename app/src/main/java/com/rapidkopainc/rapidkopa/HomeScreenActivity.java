package com.rapidkopainc.rapidkopa;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.android.material.navigation.NavigationView;

public class HomeScreenActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    AlertDialog.Builder builder;
    ProgressDialog dialog;


    int activity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        AudienceNetworkBannerAd.displayAudienceBannerAd(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));

       // setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        final Button button = findViewById(R.id.button_apply);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeScreenActivity.this.dialog = ProgressDialog.show(HomeScreenActivity.this, com.rapidkopainc.rapidkopa.CommonConfigs.FLAVOR, "Please Wait...", true);
                HomeScreenActivity.this.dialog.show();
                activity = 0;
                showInterAd();




            }
        });


        final Button buttonstatus = findViewById(R.id.statuss);
        buttonstatus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                activity = 1;
                HomeScreenActivity.this.dialog = ProgressDialog.show(HomeScreenActivity.this, com.rapidkopainc.rapidkopa.CommonConfigs.FLAVOR, "Please Wait...", true);
                HomeScreenActivity.this.dialog.show();
                showInterAd();
            }
        });


    }
    public void onBackPressed(){
        this.builder = new AlertDialog.Builder(this, 3);
        this.builder.setTitle(getString(R.string.app_name));
        this.builder.setMessage("Please rate us well. Thank you");
        this.builder.setNegativeButton("RATE APP", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                try{

                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("market://details?id=" + HomeScreenActivity.this.getPackageName()));
                    HomeScreenActivity.this.startActivity(intent);

                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + HomeScreenActivity.this.getPackageName())));
                }

                Toast.makeText(HomeScreenActivity.this, "Thank you for your Rating", Toast.LENGTH_SHORT).show();
            }
        });
        this.builder.setPositiveButton("QUIT APP", (dialog, which) -> {
            {
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(a);
            }
        });
        this.builder.create().show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main2_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //this.dialog.show();
        activity = item.getItemId();

     if (activity == R.id.nav_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Download this " + getString(R.string.app_name) + " loanguide and enjoy https://play.google.com/store/apps/details?id=$packageName");
            startActivity(intent);

        } else if (activity == R.id.nav_send) {

            try{
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
            }
            catch (ActivityNotFoundException e){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
            }

            Toast.makeText(this, "Thank you for your Rating", Toast.LENGTH_SHORT).show();

        }
        else {
         this.dialog = ProgressDialog.show(this, CommonConfigs.FLAVOR, "Please Wait...", true);
         showInterAd();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }



    public void showInterAd() {
        AudienceNetworkInterstitialAd.displayAudienceNetworkInterstitialAd(this,()->{
            this.dialog.dismiss();

            switch (activity)
            {
                case 0:
                    HomeScreenActivity.this.startActivity(new Intent( HomeScreenActivity.this, TermsAndConditionsScreenActivity.class));
                    break;
                case 1:
                    HomeScreenActivity.this.startActivity(new Intent( HomeScreenActivity.this, LoanStatusScreenActivity.class));
                    break;
                case R.id.nav_Enquiries_Form:
                    HomeScreenActivity.this.startActivity(new Intent( HomeScreenActivity.this, InquiriesFormScreenActivity.class));
                    break;
                case R.id.nav_About_Us:
                    HomeScreenActivity.this.startActivity(new Intent( HomeScreenActivity.this, AboutCompanyScreenActivity.class));
                    break;
                case R.id.nav_CRB_Info:
                    HomeScreenActivity.this.startActivity(new Intent( HomeScreenActivity.this, CRBInfoScreenActivity.class));
                    break;
                case R.id.nav_CRB_providers:
                HomeScreenActivity.this.startActivity(new Intent( HomeScreenActivity.this, CRBProvidersScreenActivity.class));
                break;
                default:
                    HomeScreenActivity.this.startActivity(new Intent( HomeScreenActivity.this, HomeScreenActivity.class));
                    break;
            }
        });
    }
  

    @Override
    protected void onDestroy() {
        AudienceNetworkInterstitialAd.destroyAudienceNetworkInterstitialAd();
        AudienceNetworkBannerAd.destroyAudienceNetworkBannerAd();
        super.onDestroy();


    }
}
