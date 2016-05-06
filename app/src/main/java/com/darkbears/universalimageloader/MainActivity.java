package com.darkbears.universalimageloader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class MainActivity extends AppCompatActivity {
ImageView pic;
    Button getimage,image_in_list;
    ImageLoader imageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pic=(ImageView)findViewById(R.id.imageView);
        getimage=(Button)findViewById(R.id.button);
        image_in_list=(Button)findViewById(R.id.button2);



        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .build();

        imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);

        image_in_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),ImageListview.class);
                startActivity(in);
            }
        });
        getimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayImageOptions options = new DisplayImageOptions.Builder()
                /*.showImageOnLoading(R.drawable.failed) // resource or drawable
                .showImageForEmptyUri(R.drawable.failed) // resource or drawable
                .showImageOnFail(R.drawable.failed) // resource or drawable*/
                        .delayBeforeLoading(1000)
                        .resetViewBeforeLoading(true)  // default
                        .cacheInMemory(true) // default => false
                        .cacheOnDisk(true) // default => false
                        .build();

                imageLoader.displayImage("http://www.familyfriendpoems.com/images/hero/nature-nature.jpg", pic, options, new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        Toast.makeText(getApplicationContext(), "Loading Started", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                        Toast.makeText(getApplicationContext(), "Loading Failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        Toast.makeText(getApplicationContext(), "Loading Complete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLoadingCancelled(String imageUri, View view) {
                        Toast.makeText(getApplicationContext(), "Loading Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
