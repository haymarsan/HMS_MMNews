package com.example.mmnews_hms.data.model;

import com.example.mmnews_hms.data.vos.LoginUserVO;
import com.example.mmnews_hms.delegates.LoginDelegate;
import com.example.mmnews_hms.network.NewsDataAgent;
import com.example.mmnews_hms.network.RetrofitDataAgent;


public class UserModel extends BaseModel implements IUserModel{



    private static UserModel objInstance;

    private NewsDataAgent mDataAgent;

    private LoginUserVO mloginUser;

    private UserModel(){

        mDataAgent = RetrofitDataAgent.getInstance();

    }

    public static UserModel getInstance() {
        if (objInstance == null){
            objInstance = new UserModel();
        }
        return objInstance;
    }

    @Override
    public void login(String phone, String password, final LoginDelegate loginDelegate) {
            mDataAgent.login(phone, password, new LoginDelegate() {
                @Override
                public void onSuccess(LoginUserVO loginUser) {
                    mloginUser = loginUser;
                    loginDelegate.onSuccess(loginUser);
                }

                @Override
                public void onFail(String message) {
                        loginDelegate.onFail(message);
                }
            });
    }

    @Override
    public LoginUserVO getLoginUser() {
        return null;
    }
}
