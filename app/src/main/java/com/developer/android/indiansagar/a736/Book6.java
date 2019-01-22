package com.developer.android.indiansagar.a736;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Book6 extends AppCompatActivity {

    private AdView mAdView;

    PDFView book6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book6);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        book6=(PDFView) findViewById(R.id.book6);
        book6.fromAsset("Polymers.pdf").load();
    }
}
