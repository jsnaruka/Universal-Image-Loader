package com.darkbears.universalimageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by jsnaruka on 06-May-16.
 */
public class CustomAdapter extends BaseAdapter{




    Context ctx;
    ImageLoader imageLoader;
    String[] urls={"http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/256/Number-1-icon.png",
            "http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/256/Number-2-icon.png",
            "http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/256/Number-3-icon.png",
            "http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/256/Number-4-icon.png",
            "http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/256/Number-5-icon.png",
            "http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/256/Number-6-icon.png",
            "http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/256/Number-7-icon.png",
            "http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/256/Number-7-icon.png",
            "http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/256/Number-8-icon.png",
            "http://icons.iconarchive.com/icons/iconarchive/red-orb-alphabet/256/Number-9-icon.png",
            "http://www.xenergie.com/wp-content/uploads/2015/05/nature.jpg",
            "http://www.familyfriendpoems.com/images/hero/nature-nature.jpg",
            "http://img09.deviantart.net/eed6/i/2010/034/e/1/do_you_remember_by_tomatokisses.jpg"};

    public CustomAdapter(Context ctx) {
        this.ctx = ctx;

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(ctx)
                .build();

        imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return urls.length;
    }



    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        // inflate the layout and set data to all views of the row

        ViewHolder holder;
        if( convertView == null ) {
            // for the first time
            LayoutInflater inflator = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.list_adapter, parent, false);
            holder = new ViewHolder();

            holder.dp = (ImageView)convertView.findViewById(R.id.imageView);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();

        }

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .delayBeforeLoading(1000)
                .resetViewBeforeLoading(true)  // default
                .cacheInMemory(true) // default => false
                .cacheOnDisk(true) // default => false
                .build();

        imageLoader.displayImage(urls[position], holder.dp, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                Toast.makeText(ctx, "Loading Started", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                Toast.makeText(ctx, "Loading Failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Toast.makeText(ctx, "Loading Complete", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                Toast.makeText(ctx, "Loading Cancelled", Toast.LENGTH_SHORT).show();
            }

        });

            return convertView;
    }

    class  ViewHolder {


        ImageView dp;
    }
}
