package com.example.apurva.hindishayari;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Shayari_List extends Fragment {

    RecyclerView recyclerView;

    public Shayari_List() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_shayari__list, container, false);

        recyclerView = v.findViewById(R.id.shayarirecylerview);

       // recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getResources()));

        String[] data=getResources().getStringArray(R.array.sad_shayari);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ShayariListAdapter(data,getContext()));

        return v;
    }

}
