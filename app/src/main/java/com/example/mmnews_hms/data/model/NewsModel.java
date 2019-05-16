package com.example.mmnews_hms.data.model;

import com.example.mmnews_hms.data.vos.CommentVO;
import com.example.mmnews_hms.data.vos.FavoriteVO;
import com.example.mmnews_hms.data.vos.NewsVO;
import com.example.mmnews_hms.data.vos.SendToVO;

public class NewsModel implements INewsModel{

    private static NewsModel objInstance;

    private NewsModel (){

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
}