package com.example.mmnews_hms.delegates;

import com.example.mmnews_hms.data.vos.LoginUserVO;

public interface LoginDelegate {


    void onSuccess (LoginUserVO loginUser);
    void onFail (String message);

}
