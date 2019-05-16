package com.example.mmnews_hms.data.vos;

import com.google.gson.annotations.SerializedName;

public class FavoriteVO {


    private String favoriteId;
    private String favoriteDate;
    private ActedUserVO actedUser;


    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getFavoriteDate() {
        return favoriteDate;
    }

    public void setFavoriteDate(String favoriteDate) {
        this.favoriteDate = favoriteDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public void setActedUser(ActedUserVO actedUser) {
        this.actedUser = actedUser;
    }
}
