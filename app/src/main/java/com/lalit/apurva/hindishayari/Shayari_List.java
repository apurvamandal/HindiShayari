package com.lalit.apurva.hindishayari;


import android.os.Bundle;
import android.support.text.emoji.EmojiCompat;
import android.support.text.emoji.bundled.BundledEmojiCompatConfig;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Shayari_List extends Fragment {

    RecyclerView recyclerView;

    String data[];
    String category_name;
    public Shayari_List() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_shayari__list, container, false);

        AdView mAdView=v.findViewById(R.id.bannerAd_second);

        //request ad to admob server
        AdRequest adRequest = new AdRequest.Builder().build();

        //add ad to Adview object
        mAdView.loadAd(adRequest);

        recyclerView = v.findViewById(R.id.shayarirecylerview);

       // recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getResources()));

        category_name=getArguments().getString("name_key").toString();

        if (category_name.equalsIgnoreCase("0")){
           data=getResources().getStringArray(R.array.dard_shayari);
        }
        else if(category_name.equalsIgnoreCase("1")){
            data=getResources().getStringArray(R.array.funny_shayari);
        }
        else if (category_name.equalsIgnoreCase("2")){
            data=getResources().getStringArray(R.array.love_shayari);
        }
        else if (category_name.equalsIgnoreCase("3")){
            data=getResources().getStringArray(R.array.birthday_shayari);
        }
        else {
            data=new String[2];
            data[0]="data not";
            data[1]="found";

        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ShayariListAdapter(data,getContext()));

        return v;
    }

}
