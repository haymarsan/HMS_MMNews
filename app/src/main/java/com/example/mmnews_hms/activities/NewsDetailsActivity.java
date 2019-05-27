package com.example.mmnews_hms.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mmnews_hms.R;
import com.example.mmnews_hms.adapters.NewsDetailsImageAdapter;

public class NewsDetailsActivity extends BaseActivity {

    ViewPager viewPager;
    NewsDetailsImageAdapter newsDetailsImageAdapter;


    public static Intent newIntent(Context context) {

        Intent intent = new Intent(context, NewsDetailsActivity.class);
        return intent;

    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);


        viewPager = findViewById(R.id.vp_news_details_image);
        newsDetailsImageAdapter = new NewsDetailsImageAdapter();
        viewPager.setAdapter(newsDetailsImageAdapter);
    }
}
