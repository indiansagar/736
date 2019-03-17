package com.developer.android.indiansagar.a736;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


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

    private DrawerLayout drawer;
    private ActionBarDrawerToggle abdt;

    static final int REQUEST_PERMISSION_KEY = 1;

    public Button btn_book1, btn_book2, btn_book3, btn_book4, btn_book5, btn_book6, btn_book7, btn_book8, btn_book9, btn_book10, btn_book11, btn_book12, btn_book13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer=(DrawerLayout)findViewById(R.id.drawer);
        abdt = new ActionBarDrawerToggle(this, drawer, R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        drawer.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.share)
                {
                    try {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                        String shareMessage = "\nDownload The Complete 12th Maths NCERT Solution For Free!!!!\n\n";
                        shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                        startActivity(Intent.createChooser(shareIntent, "choose one"));
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Error while Sharing", Toast.LENGTH_SHORT).show();
                    }


                }
                else if(id == R.id.update)
                {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.developer.android.indiansagar.a736"));
                    startActivity(i);

                }
                else if(id == R.id.rate)
                {
                    launchMarket();

                }
                else if(id == R.id.privacypolicy)
                {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://12thncertsolution.blogspot.com/p/privacy-policy.html"));
                    startActivity(i);

                }
                return true;
            }
        });









        loadFBAds();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] PERMISSIONS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            if (!hasPermissions(this, PERMISSIONS)) {
                requestPermissions(PERMISSIONS, REQUEST_PERMISSION_KEY);
            }
        }

        btn_book1 = (Button) findViewById(R.id.book1);
        btn_book2 = (Button) findViewById(R.id.book2);
        btn_book3 = (Button) findViewById(R.id.book3);
        btn_book4 = (Button) findViewById(R.id.book4);
        btn_book5 = (Button) findViewById(R.id.book5);
        btn_book6 = (Button) findViewById(R.id.book6);
        btn_book7 = (Button) findViewById(R.id.book7);
        btn_book8 = (Button) findViewById(R.id.book8);
        btn_book9 = (Button) findViewById(R.id.book9);
        btn_book10 = (Button) findViewById(R.id.book10);
        btn_book11 = (Button) findViewById(R.id.book11);
        btn_book12 = (Button) findViewById(R.id.book12);
        btn_book13 = (Button) findViewById(R.id.book13);

        btn_book1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Relation and Functions.pdf");
                i.putExtra("drive_id","1z-KIVvVj0Ggu2F2Gzp2HLJ8pQhsRia5l");
                startActivity(i);
            }
        });


        btn_book2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","tyet.pdf");
                i.putExtra("drive_id","11QNHHgJUZYuqjGzr5Ew-LBMc8L6Pc2gt");
                startActivity(i);
            }
        });
        btn_book3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Matrices.pdf");
                i.putExtra("drive_id","1-VvAoKW0kytAIj5iGQOQ5HfEcDAiJcks");
                startActivity(i);
            }
        });
        btn_book4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Determinants.pdf");
                i.putExtra("drive_id","1JQ84iePRRJIZBEaFRoT-Mff9l2v0giYK");
                startActivity(i);
            }
        });
        btn_book5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Continuity and Differentiability.pdf");
                i.putExtra("drive_id","1gGwmvmd63URDJLrzO1ukirFAb_jujvuI");
                startActivity(i);
            }
        });
        btn_book6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Application of Derivatives.pdf");
                i.putExtra("drive_id","18Y3pBQE4T2weLO0HyRLha6zYAJROAhDd");
                startActivity(i);
            }
        });
        btn_book7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Integrals.pdf");
                i.putExtra("drive_id","1U9F4zc76ABTW2Pkj9fJkLI697GT6idP8");
                startActivity(i);

            }
        });
        btn_book8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Application of Integrals.pdf");
                i.putExtra("drive_id","1Z1WCjp3AbIATlzTvObBk4gX1fqlb0gJw");
                startActivity(i);
            }
        });
        btn_book9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Differential Equations.pdf");
                i.putExtra("drive_id","1Grxl2uoSCjY4Sop4tYACNXI2_E3zNvHw");
                startActivity(i);
            }
        });
        btn_book10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Vector Algebra.pdf");
                i.putExtra("drive_id","1eeFwYexV438ovRV9B6Vklp_2sei1c3LD");
                startActivity(i);
            }
        });
        btn_book11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Three Dimensional Geometry.pdf");
                i.putExtra("drive_id","1lslFAMHOBUaQjcqf4lN9Jj2TWlzmlNSI");
                startActivity(i);
            }
        });
        btn_book12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Linear Programming.pdf");
                i.putExtra("drive_id","1kSk764cSgAYXrgAOe8WWSW6K_RZip6yg");
                startActivity(i);
            }
        });
        btn_book13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Book.class);
                i.putExtra("book_name","Probability.pdf");
                i.putExtra("drive_id","1JggLHOQ6QhuGcFn0CpXGORl-uWFKRJWD");
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
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



    private void launchMarket() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show();
        }
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

    public static  boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
