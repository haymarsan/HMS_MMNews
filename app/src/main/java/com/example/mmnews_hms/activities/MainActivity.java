package com.example.mmnews_hms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mmnews_hms.R;
import com.example.mmnews_hms.adapters.NewsAdapter;
import com.example.mmnews_hms.delegates.NewsItemDelegate;

public class MainActivity extends AppCompatActivity implements NewsItemDelegate {


    RecyclerView rvNews;
    NewsAdapter newsAdapter;
    NestedScrollView nsvBottomSheet;
    BottomSheetBehavior<NestedScrollView> mBottomSheetBehavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){

                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                }else {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }


                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });


        // Recycler view and setAdapter
        rvNews = findViewById(R.id.rv_news);
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        newsAdapter = new NewsAdapter(this); // already implement NewsItemDelegate
        rvNews.setAdapter(newsAdapter);


        // BottmSheetBehavior
        nsvBottomSheet = findViewById(R.id.nsv_bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(nsvBottomSheet);

        mBottomSheetBehavior.setPeekHeight(0);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapNewsItem() {

        Intent intent = NewsDetailsActivity.newIntent(getApplicationContext());
        startActivity(intent);
    }
}
