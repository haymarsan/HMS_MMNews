package com.example.mmnews_hms.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mmnews_hms.delegates.NewsItemDelegate;

public class NewsViewHolder extends RecyclerView.ViewHolder {


    NewsItemDelegate mDelegate;

    public NewsViewHolder(@NonNull View itemView, @NonNull NewsItemDelegate newsItemDelegate) {
        super(itemView);

        mDelegate = newsItemDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapNewsItem();
            }
        });



    }
}
