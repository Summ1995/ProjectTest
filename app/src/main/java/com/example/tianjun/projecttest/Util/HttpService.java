package com.example.tianjun.projecttest.Util;

import com.example.tianjun.projecttest.Bean.Home.TabBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by xx on 2016/9/5.
 */
public interface HttpService {
    @GET("tags.php?act=hot_topic_category&debug=true&api_version=1.0")
    Call<TabBean> queryHomeTabData();
}
