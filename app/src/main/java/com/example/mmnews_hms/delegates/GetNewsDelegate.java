package com.example.mmnews_hms.delegates;

import com.example.mmnews_hms.data.vos.NewsVO;

import java.util.List;

public interface GetNewsDelegate extends BaseNetworkDelegate {

    void onSuccess(List<NewsVO> newsList);


}
