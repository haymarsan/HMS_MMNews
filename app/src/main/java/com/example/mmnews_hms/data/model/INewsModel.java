package com.example.mmnews_hms.data.model;

import com.example.mmnews_hms.data.vos.CommentVO;
import com.example.mmnews_hms.data.vos.FavoriteVO;
import com.example.mmnews_hms.data.vos.NewsVO;
import com.example.mmnews_hms.data.vos.SendToVO;

import java.util.List;

public interface INewsModel {

    void addComment(NewsVO news, CommentVO comment);
    void addFavourite (NewsVO news, FavoriteVO favorite);
    void sendNewsTo (NewsVO news, SendToVO sendTo);


    //Get News
    List<NewsVO> getNews(NewsDelegate newsDelegate, boolean isForce);

     interface NewsDelegate{

        void onNewsFetchFromNetwork (List<NewsVO> newsList);
        void onErrorOnNewsFetch (String message);
    }

}
