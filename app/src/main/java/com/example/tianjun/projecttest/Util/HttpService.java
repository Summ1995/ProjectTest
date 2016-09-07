package com.example.tianjun.projecttest.Util;

import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.Bean.Home.ListHeadBean;
import com.example.tianjun.projecttest.Bean.Home.TabBean;
import com.example.tianjun.projecttest.Bean.Product.Product_Head_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_List_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Tab_Gson;

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

    @GET("tags.php?api_version=1.0&debug=true&act=banner&type=2")
    Call<ListHeadBean> queryHomeListHeadData11();

    @GET("tags.php?act=hot_goods_category&debug=true&api_version=1.0")
    Call<Product_Tab_Gson> openProductTabGsonCall();
    @GET("tags.php?api_version=1.0&debug=true&act=banner&type=1")
    Call<Product_Head_Gson> openProductHeadGsonCall();

    @GET("category.php")
    Call<Product_List_Gson> openProductListGsonCall(@Query("api_version") String api_version,
                                                    @Query("act") String act, @Query("c_id") int c_id,
                                                    @Query("order_price") int order_price,
                                                    @Query("page_num") int page_num,
                                                    @Query("page") int page,
                                                    @Query("debug") boolean debug,
                                                    @Query("client_id") String client_id,
                                                    @Query("key") String key);
}
