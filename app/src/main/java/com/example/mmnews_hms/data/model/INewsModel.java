package com.example.mmnews_hms.data.model;

import com.example.mmnews_hms.data.vos.CommentVO;
import com.example.mmnews_hms.data.vos.FavoriteVO;
import com.example.mmnews_hms.data.vos.NewsVO;
import com.example.mmnews_hms.data.vos.SendToVO;

public interface INewsModel {

    void addComment(NewsVO news, CommentVO comment);
    void addFavourite (NewsVO news, FavoriteVO favorite);
    void sendNewsTo (NewsVO news, SendToVO sendTo);






}
