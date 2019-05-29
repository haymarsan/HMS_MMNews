package com.example.mmnews_hms.data.model;

import com.example.mmnews_hms.data.vos.LoginUserVO;
import com.example.mmnews_hms.delegates.LoginDelegate;

public interface IUserModel {

    void login(String phone, String password, LoginDelegate loginDelegate);


    LoginUserVO getLoginUser();


    boolean isUserLogin();

}
