package com.developer.android.indiansagar.a736;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;



import com.facebook.ads.*;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity {

    private AdView adView;
    private com.facebook.ads.AdView mAdView;
    private InterstitialAd intad;
    private com.facebook.ads.InterstitialAd interstitialAd;


    public Button btn_book1, btn_book2, btn_book3, btn_book4, btn_book5, btn_book6, btn_book7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFBAds();


        btn_book1 = (Button) findViewById(R.id.book1);
        btn_book2 = (Button) findViewById(R.id.book2);
        btn_book3 = (Button) findViewById(R.id.book3);
        btn_book4 = (Button) findViewById(R.id.book4);
        btn_book5 = (Button) findViewById(R.id.book5);
        btn_book6 = (Button) findViewById(R.id.book6);
        btn_book7 = (Button) findViewById(R.id.book7);

        btn_book1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Haloalkane and Haloarenes.pdf");
                startActivity(i);
            }
        });


        btn_book2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Alcohols, Phenols and Ethers.pdf");
                startActivity(i);
            }
        });
        btn_book3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Aldehyde Ketones.pdf");
                startActivity(i);
            }
        });
        btn_book4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Amines.pdf");
                startActivity(i);
            }
        });
        btn_book5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Biomolecules.pdf");
                startActivity(i);
            }
        });
        btn_book6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Polymers.pdf");
                startActivity(i);
            }
        });
        btn_book7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Chemistry in Everyday Life.pdf");
                startActivity(i);

            }
        });
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
        final ConstraintLayout constraintLayout = findViewById(R.id.cons);

        MobileAds.initialize(this,getString(R.string.google_app_id));
        adView=findViewById(R.id.adView);

        intad=new com.google.android.gms.ads.InterstitialAd(this);
        intad.setAdUnitId(getString(R.string.google_int));
        final AdRequest ar1=new AdRequest.Builder().build();

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e("fb ad",adError.getErrorMessage());
                // Ad error callback
                AdRequest adrequest=new AdRequest.Builder().build();

                adView.loadAd(adrequest);
                adView.setAdListener(new com.google.android.gms.ads.AdListener(){
                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        constraintLayout.setVisibility(View.VISIBLE);
                        adView.setVisibility(View.VISIBLE);
                    }
                });

            }

            @Override
            public void onAdLoaded(Ad ad) {
                constraintLayout.setVisibility(View.VISIBLE);
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
