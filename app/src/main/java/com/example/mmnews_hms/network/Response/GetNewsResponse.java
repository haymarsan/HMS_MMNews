package com.example.mmnews_hms.network.Response;

import com.example.mmnews_hms.data.vos.NewsVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetNewsResponse {


    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("mmNews")
    private List<NewsVO> newsList;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<NewsVO> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsVO> newsList) {
        this.newsList = newsList;
    }
}


     /*  "code": 200,
         "message": "success",
         "apiVersion": "v1",
         "page": "2",
         "mmNews":*/