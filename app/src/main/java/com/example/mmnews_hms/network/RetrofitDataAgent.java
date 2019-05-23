package com.example.mmnews_hms.network;

import com.example.mmnews_hms.Utils.Const;
import com.example.mmnews_hms.data.vos.NewsVO;
import com.example.mmnews_hms.network.Response.GetNewsResponse;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgent implements NewsDataAgent {

    private static RetrofitDataAgent objInstance;

    private NewsAPI mNewsAPI;

    private RetrofitDataAgent() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        NewsAPI mNewsAPI = retrofit.create(NewsAPI.class);

    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }


    @Override
    public void loadNews(int page, String accessToken, final NewsResponseDelegate newsResponseDelegate) {
        Call<GetNewsResponse> callNewsResponse = mNewsAPI.loadNews(accessToken, page);
        callNewsResponse.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                GetNewsResponse newsResponse = response.body();
                if (newsResponse != null) {
                    if (newsResponse.isResponseSuccess()) {
                        newsResponseDelegate.onSuccess(newsResponse.getNewsList());
                    } else {
                        newsResponseDelegate.onFail(newsResponse.getMessage());
                    }
                } else {
                    newsResponseDelegate.onFail("Response is null");
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                    newsResponseDelegate.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void login(String phone, String password) {

    }

    @Override
    public void register(String phone, String password, String name) {


    }


    public interface NewsResponseDelegate {

        void onSuccess(List<NewsVO> newsList);

        void onFail(String message);

    }

}
