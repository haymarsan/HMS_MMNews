package com.example.mmnews_hms.network;

public interface NewsDataAgent {

    void loadNews (int page, String accessToken, RetrofitDataAgent.NewsResponseDelegate newsResponseDelegate);
    void login (String phone, String password);
    void register (String phone, String password, String name);



}
