package com.example.as.dongyuedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.as.dongyuedemo.service.JsonService;
import com.example.as.dongyuedemo.tool.NetworkTool;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity{
    private static final String TAG = "ActivityAdapter:";
    private static final String dataURL = "http://tongqu.me/index.php/api/act/type?=2";
    ArrayList<ItemEntity> item_list = new ArrayList<ItemEntity>();

    ActivityAdapter adapter;
    LoadListView listview;

    private Handler handler = new Handler(){

        public void handleMessage(Message msg){
            Log.d(TAG, msg.toString());
            if (msg.what == 1){
                ActivityAdapter adapter = (ActivityAdapter) msg.obj;
                Log.d(TAG, adapter.toString());
                listview.setAdapter(adapter);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        listview = (LoadListView) findViewById(R.id.listview);
        Log.d(TAG, "start");
        new Thread(){
            public void run(){
                try{
                    List<Act> list = JsonService.getActs(new NetworkTool().getContentFromUrl(dataURL));
                    Log.d(TAG, list.get(0).toString());
                    for(Act info : list){
                        ItemEntity item = new ItemEntity();
                        item.setName(info.getName());
                        item.setPoster(info.getPoster());
                        String desc = "活动时间：" + info.getStart_time() + "~" + info.getEnd_time() + "\n" +
                                      "报名时间：" + info.getSign_start_time() + "~" + info.getSign_end_time() + "\n" +
                                      "主办方：" + info.getSource()+ "\n" +
                                      "地点：" + info.getLocation() + "\n";

                        item.setDes(desc);
                        item_list.add(item);
                    }
                    Log.d(TAG, item_list.get(0).getName() + item_list.get(0).getDes() + item_list.get(0).getPoster() );
//                    listview.setInterface(MyActivity.this);
                    ActivityAdapter adapter = new ActivityAdapter(MyActivity.this, item_list);
                    Message msg = new Message();
                    msg.what = 1;
                    msg.obj = adapter;
                    handler.sendMessage(msg);
                }catch(Exception e){
                    Log.e(TAG, e.toString());
                }
            }
        }.start();
    }

//    @Override
//    public void onLoad() {
//        listview.loadComplete();
//    }
}
