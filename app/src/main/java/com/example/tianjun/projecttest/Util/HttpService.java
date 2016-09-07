package com.example.tianjun.projecttest.Util;

import com.example.tianjun.projecttest.Bean.Home.CategoryBean;
import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.Bean.Home.ListHeadBean;
import com.example.tianjun.projecttest.Bean.Home.TabBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xx on 2016/9/5.
 */
public interface HttpService {
    @GET("tags.php?act=hot_topic_category&debug=true&api_version=1.0")
    Call<TabBean> queryHomeTabData();

    @GET("topic.php?act=list&debug=true&api_version=1.0&from_id=0&key=")
    Call<ListBean> queryHomeListData(@Query("count")int count,@Query("c_id")int id);

    @GET("tags.php?api_version=1.0&debug=true&act=banner&type=2")
    Call<ListHeadBean> queryHomeListHeadData();

    @GET("topic.php?act=topic_cate&debug=true&api_version=1.0")
    Call<CategoryBean> queryHomeCategoryData();
}
