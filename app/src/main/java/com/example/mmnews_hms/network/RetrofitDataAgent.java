package com.example.mmnews_hms.network;

import com.example.mmnews_hms.Utils.Const;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgent implements NewsDataAgent {

    private static RetrofitDataAgent objInstance;

    private RetrofitDataAgent (){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsAPI mNewsAPI = retrofit.create(NewsAPI.class);

    }

    public static RetrofitDataAgent getObjInstance() {
        if (objInstance == null){
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadNews(String page, String accessToken) {

    }

    @Override
    public void login(String phone, String password) {

    }

    @Override
    public void register(String phone, String password, String name) {

    }
}
