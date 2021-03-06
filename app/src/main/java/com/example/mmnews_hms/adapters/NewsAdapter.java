package com.example.mmnews_hms.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mmnews_hms.R;
import com.example.mmnews_hms.data.vos.NewsVO;
import com.example.mmnews_hms.delegates.NewsItemDelegate;
import com.example.mmnews_hms.views.holders.BaseNewsViewHolder;
import com.example.mmnews_hms.views.holders.NewsSmallViewHolder;
import com.example.mmnews_hms.views.holders.NewsViewHolder;

public class NewsAdapter extends BaseRecyclerAdapter<BaseNewsViewHolder, NewsVO> {


    private static final int REGULAR_NEWS_VIEW = 1234;
    private static final int SMALL_NEWS_VIEW = 2345;

    private NewsItemDelegate mNewsItemDelegate;

    public NewsAdapter(NewsItemDelegate newsItemDelegate) {

        mNewsItemDelegate = newsItemDelegate;

    }

    @NonNull
    @Override
    public BaseNewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType){

            case REGULAR_NEWS_VIEW:
                View itemView = inflater.inflate(R.layout.view_item_news, viewGroup, false);
                return new NewsViewHolder(itemView, mNewsItemDelegate);
            case SMALL_NEWS_VIEW:
                View itemViewSmall = inflater.inflate(R.layout.view_item_news_small, viewGroup, false);
                return new NewsSmallViewHolder(itemViewSmall);


        }
        return null;
    }


    // no need to bind in adapter, API data will bind in View Holder
/*
    // Override (dynamic binding), not the method in BaseRecyclerVH (not appropiate for POC)
    @Override
    public void onBindViewHolder(@NonNull BaseNewsViewHolder baseNewsViewHolder, int position) {

    }


    // Override (dynamic binding), not the method in BaseRecyclerVH (not appropiate for POC)
    @Override
    public int getItemCount() {
        return 12;
    }
*/


    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0){
            return REGULAR_NEWS_VIEW;
        }else{
            return SMALL_NEWS_VIEW;
        }
    }
}
