package com.example.mmnews_hms.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mmnews_hms.R;
import com.example.mmnews_hms.data.vos.NewsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseNewsViewHolder extends BaseViewHolder<NewsVO> {


    @BindView(R.id.tv_brief_news)
    TextView tvBriedNews;

    public BaseNewsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(NewsVO data) {

        tvBriedNews.setText(data.getBrief());

    }
}
