package com.example.mmnews_hms.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mmnews_hms.data.vos.NewsVO;

public class BaseNewsViewHolder extends BaseViewHolder<NewsVO> {

    public BaseNewsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(NewsVO data) {

    }
}
