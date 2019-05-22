package com.example.mmnews_hms.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class NewsVO {

/*
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "news_id_pk")
    private long newsIdPK;
*/


    @SerializedName("news-id")
    private String newsId;


    @SerializedName("brief")
    private String brief;


    @SerializedName("details")
    private String details;

    @SerializedName("images")
    private List<String> images;


    @SerializedName("posted-date")
    private String postedDate;


    @SerializedName("publication")
    private PublicationVO publication;


    @SerializedName("favorites")
    private List<FavoriteVO> favorites;


    @SerializedName("comments")
    private List<CommentVO> comments;


    @SerializedName("sent-tos")
    private List<SendToVO> sendTos;


    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetails() {
        return details;
    }


    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<FavoriteVO> getFavorites() {
        return favorites;
    }

    public List<CommentVO> getComments() {
        if (comments == null)
            return new ArrayList<>();
        return comments;
    }

    public List<SendToVO> getSendTos() {
        return sendTos;
    }


    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public void setPublication(PublicationVO publication) {
        this.publication = publication;
    }

    public void setFavorites(List<FavoriteVO> favorites) {
        this.favorites = favorites;
    }

    public void setComments(List<CommentVO> comments) {
        this.comments = comments;
    }

    public void setSendTos(List<SendToVO> sendTos) {
        this.sendTos = sendTos;
    }
}
