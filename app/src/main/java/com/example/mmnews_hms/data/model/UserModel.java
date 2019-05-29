package com.example.mmnews_hms.data.model;

import android.content.Context;
import android.util.Log;

import com.example.mmnews_hms.data.vos.LoginUserVO;
import com.example.mmnews_hms.delegates.LoginDelegate;
import com.example.mmnews_hms.network.NewsDataAgent;
import com.example.mmnews_hms.network.RetrofitDataAgent;
import com.example.mmnews_hms.persistence.NewsAppDB;


public class UserModel extends BaseModel implements IUserModel{

    private static UserModel objInstance;

    private NewsDataAgent mDataAgent;

   private long mLoginUser;

    private NewsAppDB mNewsDB;

    private UserModel(Context context){

        mDataAgent = RetrofitDataAgent.getInstance();
        mNewsDB = NewsAppDB.getDatabase(context);

    }

    public static void initUserModel(Context context){
            objInstance = new UserModel(context);
    }

    public static UserModel getInstance() {
        if (objInstance == null){
            //objInstance = new UserModel();
            throw new RuntimeException("UserModel should have been initialized before using it.");
        }
        return objInstance;
    }

    @Override
    public void login(String phone, String password, final LoginDelegate loginDelegate) {
            mDataAgent.login(phone, password, new LoginDelegate() {
                @Override
                public void onSuccess(LoginUserVO loginUser) {
                  mLoginUser =  mNewsDB.loginUseDao().insertLoginUser(loginUser);
                    Log.d("Login User", "uerID"+mLoginUser);
                   // mLoginUser = loginUser;
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
        LoginUserVO loginUser = mNewsDB.loginUseDao().getLoginUser();
        return loginUser;
    }

    @Override
    public boolean isUserLogin() {
        return mNewsDB.loginUseDao().getLoginUser() != null;
    }


}
