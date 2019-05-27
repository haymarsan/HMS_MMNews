package com.example.mmnews_hms.network.Response;

import com.example.mmnews_hms.data.vos.LoginUserVO;
import com.google.gson.annotations.SerializedName;

public class LoginUserResponse extends BaseResponse {

    @SerializedName("login_user")
    private LoginUserVO loginUser;


    public LoginUserVO getLoginUser() {
        return loginUser;
    }


}


/*
 "code": 200,
         "message": "Login succcess",
         "login_user": {  // Object
         "userId": 6,
         "name": "Phyo Phone Myint",
         "email": "phyophonemyint.dw2@gmail.com",
         "phoneNo": "+959783499912",
         "profileUrl": "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAArwAAAAJDY3ZWI0ZTljLWI5OGItNDYwMC1hYzliLTA4Nzc5OGFmNWJjZQ.jpg",
         "coverUrl": "https://frontiermyanmar.net/sites/frontiermyanmar.net/files/styles/content_full_width/public/jtms-pso-12.jpg"*/
