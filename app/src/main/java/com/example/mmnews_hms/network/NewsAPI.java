package com.example.mmnews_hms.network;

import com.example.mmnews_hms.Utils.Const;
import com.example.mmnews_hms.network.Response.GetNewsResponse;
import com.example.mmnews_hms.network.Response.LoginUserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NewsAPI {

    @FormUrlEncoded
    @POST(Const.GET_NEWS)
    Call<GetNewsResponse> loadNews(@Field(Const.PARAM_ACCESS_TOKEN)String accessToken,
                                   @Field(Const.PARAM_PAGE)int page);

    @FormUrlEncoded
    @POST(Const.LOGIN_NEWS)
    Call<LoginUserResponse> login(@Field(Const.PARAM_PHONE_NUMBER) String phoneNo,
                                  @Field(Const.PARAM_PASSWORD) String password);

}
