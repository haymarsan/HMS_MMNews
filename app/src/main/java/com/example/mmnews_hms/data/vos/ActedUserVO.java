package com.example.mmnews_hms.data.vos;

import com.google.gson.annotations.SerializedName;

public class ActedUserVO {

    private String userId;
    private String userName;
    private String profileImage;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}