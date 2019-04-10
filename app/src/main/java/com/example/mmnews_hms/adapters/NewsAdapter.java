package com.example.mmnews_hms.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mmnews_hms.R;
import com.example.mmnews_hms.delegates.NewsItemDelegate;
import com.example.mmnews_hms.views.holders.NewsViewHolder;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private NewsItemDelegate mNewsItemDelegate;

    public NewsAdapter(NewsItemDelegate newsItemDelegate) {

        mNewsItemDelegate = newsItemDelegate;

    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.view_item_news, viewGroup, false);
        return new NewsViewHolder(itemView, mNewsItemDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 12;
    }
}
