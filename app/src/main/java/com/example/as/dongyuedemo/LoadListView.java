package com.example.as.dongyuedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class LoadListView extends ListView implements AbsListView.OnScrollListener {
    View footer;
    int totalItemCount;
    int lastVisibleItem;
    boolean isLoading;
//    ILoadListener iLoadListener;

    public LoadListView(Context context) {
        super(context);
        initView(context);
    }

    public LoadListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public LoadListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }

    private void initView(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
        footer = inflater.inflate(R.layout.folder_layout,null);
        footer.findViewById(R.id.list_load).setVisibility(View.GONE);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (totalItemCount == lastVisibleItem && scrollState == SCROLL_STATE_IDLE){
            if (!isLoading){
                isLoading = true;
                footer.findViewById(R.id.list_load).setVisibility(View.VISIBLE);
                // get more data
//                iLoadListener.onLoad();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        // judge whether reaches the bottom
        this.lastVisibleItem = firstVisibleItem + totalItemCount;
        this.totalItemCount = totalItemCount;
    }

//    // the return interface for getting more data
//    public interface ILoadListener{
//        public void onLoad();
//    }

//    public void loadComplete(){
//        isLoading = false;
//        footer.findViewById(R.id.list_load).setVisibility(View.GONE);
//    }

//    public void setInterface(ILoadListener iLoadListener){
//        this.iLoadListener = iLoadListener;
//    }
}
