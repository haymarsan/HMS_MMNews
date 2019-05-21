package com.example.mmnews_hms.network;

public interface NewsDataAgent {

    void loadNews (String page, String accessToken);
    void login (String phone, String password);
    void register (String phone, String password, String name);



}
