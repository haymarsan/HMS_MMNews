package com.example.mmnews_hms.delegates;

import com.example.mmnews_hms.data.vos.LoginUserVO;

public interface LoginDelegate extends BaseNetworkDelegate {


    void onSuccess (LoginUserVO loginUser);


}
