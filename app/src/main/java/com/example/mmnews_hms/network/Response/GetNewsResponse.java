package com.example.mmnews_hms.network.Response;

import com.example.mmnews_hms.data.vos.NewsVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetNewsResponse extends BaseResponse{


    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int page;

    @SerializedName("mmNews")
    private List<NewsVO> newsList;



    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
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