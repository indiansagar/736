package com.developer.android.indiansagar.a736;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.facebook.ads.*;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.facebook.ads.*;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Book extends AppCompatActivity {

    PDFView book1;



    private AdView adView;
    private com.facebook.ads.AdView mAdView;
    private com.google.android.gms.ads.InterstitialAd intad;
    private com.facebook.ads.InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        loadFBAds();

        book1 = (PDFView) findViewById(R.id.book1);
        Intent i = getIntent();
        book1.fromAsset(i.getStringExtra("book_name")).load();

    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if(interstitialAd.isAdLoaded()){
            interstitialAd.show();
        }
        else if(intad.isLoaded()) {
            intad.show();
        }
        else {
            super.onBackPressed();
        }
    }

    private void loadFBAds() {

        mAdView = new com.facebook.ads.AdView(this, getString(R.string.fb_banner), AdSize.BANNER_HEIGHT_50);
        final LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        adContainer.addView(mAdView);

        MobileAds.initialize(this,getString(R.string.google_app_id));
        adView=findViewById(R.id.adView);

        intad=new com.google.android.gms.ads.InterstitialAd(this);
        intad.setAdUnitId(getString(R.string.google_int));
        final AdRequest ar1=new AdRequest.Builder().build();

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                AdRequest adrequest=new AdRequest.Builder().build();
                adView.loadAd(adrequest);
                adView.setAdListener(new com.google.android.gms.ads.AdListener(){
                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        adView.setVisibility(View.VISIBLE);
                    }
                });

            }

            @Override
            public void onAdLoaded(Ad ad) {

                adContainer.setVisibility(View.VISIBLE);
                // Ad loaded callback
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        });


        mAdView.loadAd();

        interstitialAd = new com.facebook.ads.InterstitialAd(this,getString(R.string.fb_int));
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                intad.loadAd(ar1);
            }

            @Override
            public void onAdLoaded(Ad ad) {

            }

            @Override
            public void onAdClicked(Ad ad) {
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        });

        interstitialAd.loadAd();


    }
}
