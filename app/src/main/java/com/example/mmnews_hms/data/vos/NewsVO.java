package com.example.mmnews_hms.data.vos;

import java.util.List;


public class NewsVO {

    private String newsId;
    private String brief;
    private String details;
    private List<String> images;
    private String postedDate;
    private PublicationVO publication;
    private List<FavoriteVO> favorites;
    private List<CommentVO> comments;
    private List<SendToVO> sendTos;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public void setPublication(PublicationVO publication) {
        this.publication = publication;
    }

    public List<FavoriteVO> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<FavoriteVO> favorites) {
        this.favorites = favorites;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public void setComments(List<CommentVO> comments) {
        this.comments = comments;
    }

    public List<SendToVO> getSendTos() {
        return sendTos;
    }

    public void setSendTos(List<SendToVO> sendTos) {
        this.sendTos = sendTos;
    }
}
