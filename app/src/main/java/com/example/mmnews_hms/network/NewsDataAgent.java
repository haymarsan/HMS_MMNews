package com.example.mmnews_hms.network;

import com.example.mmnews_hms.delegates.GetNewsDelegate;
import com.example.mmnews_hms.delegates.LoginDelegate;

public interface NewsDataAgent {

    void loadNews (int page, String accessToken, GetNewsDelegate newsResponseDelegate);
    void login (String phone, String password, LoginDelegate loginDelegate);
    void register (String phone, String password, String name);



}
