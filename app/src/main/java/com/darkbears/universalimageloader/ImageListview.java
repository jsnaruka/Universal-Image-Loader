package com.darkbears.universalimageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

public class ImageListview extends AppCompatActivity {
ListView imageslist;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        imageslist=(ListView) findViewById(R.id.listView);
        adapter=new CustomAdapter(getApplicationContext());

        imageslist.setAdapter(adapter);





    }
}
