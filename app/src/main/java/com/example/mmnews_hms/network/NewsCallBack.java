package com.example.mmnews_hms.network;

import com.example.mmnews_hms.delegates.BaseNetworkDelegate;
import com.example.mmnews_hms.network.Response.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsCallBack<T extends BaseResponse, W extends BaseNetworkDelegate> implements Callback<T> {

    W networkDelegate;

    public NewsCallBack(W networkDelegate) {
        this.networkDelegate = networkDelegate;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T newsResponse = response.body();
        if (newsResponse == null){
            networkDelegate.onFail("Response is Null");
        }else {
            if (!newsResponse.isResponseSuccess()){
                networkDelegate.onFail(newsResponse.getMessage());
                return;
            }
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        networkDelegate.onFail(t.getMessage());
    }
}
