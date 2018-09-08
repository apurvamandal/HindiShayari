package com.lalit.apurva.hindishayari;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.text.emoji.EmojiCompat;
import android.support.text.emoji.bundled.BundledEmojiCompatConfig;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class GridItemActivity extends AppCompatActivity {

    TextView name;
    ImageView image;
    android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction ft;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);
//        name=findViewById(R.id.griddata);
//        image=findViewById(R.id.imageView);

        //interstitial add loadind code
        String adcod=getResources().getString(R.string.interstitialVideoAd);
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId(adcod);
        interstitialAd.loadAd(new AdRequest.Builder().build());


        //perform task on cut button of interstitial ads

//        interstitialAd.setAdListener(new AdListener(){
//            @Override
//            public void onAdClosed() {
//                super.onAdClosed();
//                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
//
//            }
//        });

        //get the info from main activity such as which button is clicked
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");


        //set the data to transfer info from fragment to activity
        Bundle bundle=new Bundle();
        bundle.putString("name_key",name);
        Shayari_List shayari_list=new Shayari_List();
        shayari_list.setArguments(bundle);

        //attach  the fragment to activity

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.second_layout, shayari_list);
        ft.commit();

//        name.setText(intent.getStringExtra("name"));
//        image.setImageResource(intent.getIntExtra("image",0));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }

    }
}
