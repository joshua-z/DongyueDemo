package com.example.as.dongyuedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ActivityAdapter extends BaseAdapter {
    ArrayList<ItemEntity> item_list;
    LayoutInflater inflater;
    static String TAG = "ActivityAdapter:";

    public ActivityAdapter(Context context, ArrayList<ItemEntity> item_list){
        this.item_list = item_list;
        this.inflater = LayoutInflater.from(context);
    }

    public void onDataChange(ArrayList<ItemEntity> item_list){
        this.item_list = item_list;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return item_list.size();
    }

    @Override
    public Object getItem(int position) {
        return item_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewContainer{
        TextView name_tv;
        TextView dec_tv;
        ImageView poster_iv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemEntity entity = item_list.get(position);
        ViewContainer container;
        if (convertView == null){
            container = new ViewContainer();
            convertView = inflater.inflate(R.layout.item_layout, null);
            container.name_tv = (TextView) convertView.findViewById(R.id.item_name);
            container.dec_tv = (TextView) convertView.findViewById(R.id.item_des);
            container.poster_iv = (ImageView) convertView.findViewById(R.id.item_poster);
            convertView.setTag(container);
        }else{
            container = (ViewContainer) convertView.getTag();
        }
        container.name_tv.setText(entity.getName());
        container.dec_tv.setText(entity.getDes());
        DownLoadImage tmp;
        tmp = new DownLoadImage(container.poster_iv);
        tmp.execute(entity.getPoster());

        return convertView;
    }

}
