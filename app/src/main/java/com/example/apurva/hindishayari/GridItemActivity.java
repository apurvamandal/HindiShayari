package com.example.apurva.hindishayari;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GridItemActivity extends AppCompatActivity {

    TextView name;
    ImageView image;
    android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);
//        name=findViewById(R.id.griddata);
//        image=findViewById(R.id.imageView);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        if (name.equalsIgnoreCase("apple")){

            fm=getSupportFragmentManager();
            ft=fm.beginTransaction();
            ft.replace(R.id.second_layout, new Shayari_List());
            ft.commit();
        }
//        name.setText(intent.getStringExtra("name"));
//        image.setImageResource(intent.getIntExtra("image",0));

    }
}
