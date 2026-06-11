package com.rapidkopainc.rapidkopa;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.util.Log;
import android.widget.LinearLayout;

import com.facebook.ads.*;

class  AudienceNetworkInitializeHelper implements  AudienceNetworkAds.InitListener  {
    private static boolean DEBUG = false;




    /**
     * It's recommended to call this method from Application.onCreate().
     * Otherwise you can call it from all Activity.onCreate()
     * methods for Activities that contain ads.
     *
     * @param context Application or Activity.
     */
    static void initialize(Application context) {
        if (!AudienceNetworkAds.isInitialized(context)) {
            if (DEBUG) {
                AdSettings.turnOnSDKDebugger(context);
                AdSettings.setTestMode(true);
                AdSettings.addTestDevice("baa9c0dc-f1b9-4af7-be4c-9d48e8431232");

            }

            AudienceNetworkAds
                    .buildInitSettings(context)
                    .withInitListener(new AudienceNetworkInitializeHelper())
                    .initialize();


        }
    }

    @Override
    public void onInitialized(AudienceNetworkAds.InitResult result) {


        Log.d(AudienceNetworkAds.TAG, result.getMessage());
    }
}

class AudienceNetworkBannerAd{

    private static AdView adView;

    public static void  displayAudienceBannerAd(Activity hostActivity ){

     adView =new AdView(hostActivity, hostActivity.getString(R.string.facebook_bannerad_id), AdSize.BANNER_HEIGHT_50);
     LinearLayout audienceBannerAdContainer = hostActivity.findViewById(R.id.bannerad_container);


     audienceBannerAdContainer.addView(adView);

     adView.loadAd();


    }

    public static void destroyAudienceNetworkBannerAd()
    {
        if (adView != null) {
            adView.destroy();
        }
    }


}

class AudienceNetworkInterstitialAd{



    private static InterstitialAd interstitialAd;
    private static InterstitialAdListener interstitialAdListener;

    private static  Runnable interstitialRunnable = null;
    private static void initializeAudienceNetworkInterstitialAd(Activity hostActivity)
    {
        interstitialAd = new InterstitialAd(hostActivity, hostActivity.getString(R.string.facebook_interstitialad_id));

    }

    private   static void loadAudienceNetworkInterstitialAd(Activity hostActivity,Runnable runnable)
    {
        initializeAudienceNetworkInterstitialAd(hostActivity);

        interstitialRunnable = runnable;

        interstitialAdListener=new InterstitialAdListener() {
            Handler interstitialHandler=new Handler();
            long interstitialDelayMills =500;
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback

            }
            private void handleInterstitialHandler()
            {
                if(AudienceNetworkInterstitialAd.interstitialRunnable == null)
                {
                    return;
                }
                interstitialHandler.postDelayed(AudienceNetworkInterstitialAd.interstitialRunnable,interstitialDelayMills);
            }
            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
             handleInterstitialHandler();

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
             handleInterstitialHandler();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                // Check if interstitialAd has been loaded successfully

                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback


            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback

            }
        };
        interstitialAd.loadAd( interstitialAd.buildLoadAdConfig()
                .withAdListener(interstitialAdListener)
                .build());

    }


    public static  void displayAudienceNetworkInterstitialAd(Activity hostActivity,Runnable runnable)
    {
        loadAudienceNetworkInterstitialAd(hostActivity,runnable);

    }

    public static void destroyAudienceNetworkInterstitialAd()
    {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
    }


}

public class AudienceNetworkHelperClass
{


}