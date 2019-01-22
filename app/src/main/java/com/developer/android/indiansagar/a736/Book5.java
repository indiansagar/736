package com.developer.android.indiansagar.a736;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Book5 extends AppCompatActivity {

    private AdView mAdView;

    PDFView book5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book5);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        book5=(PDFView) findViewById(R.id.book5);
        book5.fromAsset("Biomolecules.pdf").load();
    }
}
