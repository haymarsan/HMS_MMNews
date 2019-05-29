package com.example.mmnews_hms;

import android.app.Application;
import android.content.Context;

import com.example.mmnews_hms.data.model.UserModel;

public class NewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UserModel.initUserModel(getApplicationContext());
    }
}
