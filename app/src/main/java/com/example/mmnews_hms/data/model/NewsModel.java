package com.example.mmnews_hms.data.model;

import android.support.annotation.Nullable;

import com.example.mmnews_hms.Utils.Const;
import com.example.mmnews_hms.data.vos.CommentVO;
import com.example.mmnews_hms.data.vos.FavoriteVO;
import com.example.mmnews_hms.data.vos.NewsVO;
import com.example.mmnews_hms.data.vos.SendToVO;
import com.example.mmnews_hms.delegates.GetNewsDelegate;
import com.example.mmnews_hms.network.NewsDataAgent;
import com.example.mmnews_hms.network.RetrofitDataAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsModel extends BaseModel implements INewsModel{

    private static NewsModel objInstance;

    private NewsDataAgent mNewsDataAgent;

    // in Memory Data Repository
    private Map<String, NewsVO> mNews;

    private NewsModel (){
        mNews = new HashMap<>();

        mNewsDataAgent = RetrofitDataAgent.getInstance();

    }

    public static NewsModel getObjInstance() {

        if (objInstance == null){
            objInstance = new NewsModel();
        }
        return objInstance;
    }

    @Override
    public void addComment(NewsVO news, CommentVO comment) {

    }

    @Override
    public void addFavourite(NewsVO news, FavoriteVO favorite) {

    }

    @Override
    public void sendNewsTo(NewsVO news, SendToVO sendTo) {

    }

    @Override
    public @Nullable
    List<NewsVO> getNews(final NewsDelegate newsDelegate, boolean isForce) {
        if (mNews.isEmpty() || isForce) {
            mNewsDataAgent.loadNews(1,
                    Const.ACCESS_TOKEN,
                    new GetNewsDelegate() {
                        @Override
                        public void onSuccess(List<NewsVO> newsList) {
                            for (NewsVO news : newsList) {
                                mNews.put(news.getNewsId(), news);
                            }
                            newsDelegate.onNewsFetchFromNetwork(new ArrayList<

                                    >(mNews.values()));
                        }

                        @Override
                        public void onFail(String msg) {
                            newsDelegate.onErrorOnNewsFetch(msg);
                        }
                    });
        } else {
            return new ArrayList<>(mNews.values());
        }

        return null;
    }
}

/*
    @Override
    public @Nullable
    List<NewsVO> getNews(final NewsDelegate newsDelegate, boolean isForce) {
        if (mNews.isEmpty() || isForce){
            mNewsDataAgent.loadNews(1, Const.ACCESS_TOKEN,
                    new RetrofitDataAgent.NewsResponseDelegate() {
                        @Override
                        public void onSuccess(List<NewsVO> newsList) {
                            for(NewsVO news: newsList){
                                mNews.put(news.getNewsId(), news);
                            }
                            newsDelegate.onNewsFetchFromNetwork(new ArrayList<>(mNews.values()) );
                        }

                        @Override
                        public void onFail(String message) {
                            newsDelegate.onErrorOnNewsFetch(message);
                        }
                    });
        }else {
            return new ArrayList<>(mNews.values());
        }
        return null;
    }

*/


