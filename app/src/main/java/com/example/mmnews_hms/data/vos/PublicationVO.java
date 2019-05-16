package com.example.mmnews_hms.data.vos;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class PublicationVO {
    private String publicationId;
    private String title;
    private String logo;

    public String getPublicationId() {
        return publicationId;
    }

    public String getTitle() {
        return title;
    }

    public String getLogo() {
        return logo;
    }

    public void setPublicationId(String publicationId) {
        this.publicationId = publicationId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
