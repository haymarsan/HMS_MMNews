package com.example.mmnews_hms.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mmnews_hms.R;
import com.example.mmnews_hms.adapters.NewsAdapter;
import com.example.mmnews_hms.data.model.INewsModel;
import com.example.mmnews_hms.data.model.NewsModel;
import com.example.mmnews_hms.data.model.UserModel;
import com.example.mmnews_hms.data.vos.NewsVO;
import com.example.mmnews_hms.delegates.NewsItemDelegate;
import com.example.mmnews_hms.views.pods.LoginUserViewPod;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NewsItemDelegate {

    @BindView(R.id.toolbar)
    Toolbar mtoolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    BottomSheetBehavior<NestedScrollView> mBottomSheetBehavior;
    RecyclerView rvNews;
    NewsAdapter newsAdapter;
    NestedScrollView nsvBottomSheet;

    private NewsModel mNewsModel;
    private UserModel mUserModel;

    public static Intent newIntent (Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this); // need to write this one to use butter knife

       // mtoolbar = findViewById(R.id.toolbar); // no need cos of Butter Knife
        setSupportActionBar(mtoolbar);


       // mDrawerLayout = findViewById(R.id.drawer_layout);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });


        // No need cos of Butter knife onClick Listener
  /*      FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                *//*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*//*
            }
        });
*/

        // Recycler view and setAdapter
        rvNews = findViewById(R.id.rv_news);
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        newsAdapter = new NewsAdapter(this); // already implement NewsItemDelegate
        rvNews.setAdapter(newsAdapter);


        // BottmSheetBehavior
        nsvBottomSheet = findViewById(R.id.nsv_bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(nsvBottomSheet);

        mBottomSheetBehavior.setPeekHeight(0);


        //to select each menu in navigation view
        //mNavigationView = findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_lastest_news:
                        Toast.makeText(getApplicationContext(),"Latest News", Toast.LENGTH_SHORT).show();
                        mtoolbar.setTitle("Latest News");
                        break;

                    case R.id.menu_news_just_for_you:
                        Toast.makeText(getApplicationContext(), "News Just for you", Toast.LENGTH_SHORT).show();
                        mtoolbar.setTitle("News Just for you");
                        break;

                    case R.id.menu_favorite_news:
                        Toast.makeText(getApplicationContext(), "Favourite News", Toast.LENGTH_SHORT).show();
                        mtoolbar.setTitle("Favourite News");
                        break;

                }

                for (int index = 0; index < mNavigationView.getMenu().size(); index++){
                    mNavigationView.getMenu().getItem(index).setChecked(false);
                }
                menuItem.setChecked(true);
                return false;
            }
        });



        //Data Bind
        mNewsModel = NewsModel.getObjInstance();


        // Login Data Bind
        mUserModel = UserModel.getInstance();


        if(!mUserModel.isUserLogin()){
            Intent intent = LoginActivity.newIntent(getApplicationContext());
            startActivity(intent);

            return;
        }

        LoginUserViewPod vpLoginUser = (LoginUserViewPod) mNavigationView.getHeaderView(0);
        vpLoginUser.setData(mUserModel.getLoginUser());

        bindNews(true);

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
    public void onTapNewsItem(){

        Intent intent = NewsDetailsActivity.newIntent(getApplicationContext());
        startActivity(intent);

    }

    @OnClick(R.id.fab)
    public void onTapFab(View view){
        if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){

            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        }else {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

    }


    //To get News from Model and show in presenter/Act
    private void bindNews(boolean isForce){

        List<NewsVO> news = mNewsModel.getNews(new INewsModel.NewsDelegate() {
            @Override
            public void onNewsFetchFromNetwork(List<NewsVO> newsList) {
                newsAdapter.setNewData(newsList);
            }

            @Override
            public void onErrorOnNewsFetch(String message) {
                Toast.makeText(getApplicationContext(), "Error on Network Call", Toast.LENGTH_SHORT).show();
            }
        }, isForce);

        if (news != null){
            newsAdapter.setNewData(news);
        }
        }
    }

