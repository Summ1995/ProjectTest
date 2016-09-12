package com.example.tianjun.projecttest.Util;

import com.example.tianjun.projecttest.Bean.Detail.RelativeTopicBean;
import com.example.tianjun.projecttest.Bean.Detail.CommentBean;
import com.example.tianjun.projecttest.Bean.Detail.DetailsBean;
import com.example.tianjun.projecttest.Bean.Home.CategoryBean;
import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.Bean.Home.ListHeadBean;
import com.example.tianjun.projecttest.Bean.Home.TabBean;
import com.example.tianjun.projecttest.Bean.Product.Product_Head_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_List_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Tab_Gson;
import com.example.tianjun.projecttest.Bean.Welcome.WelcomeBean;

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
    @GET("tags.php?api_version=1.0&debug=true&act=banner&type=2")
    Call<ListHeadBean> queryHomeListHeadData11();

    @GET("tags.php?act=hot_goods_category&debug=true&api_version=1.0")
    Call<Product_Tab_Gson> openProductTabGsonCall();

    @GET("tags.php?api_version=1.0&debug=true&act=banner&type=1")
    Call<Product_Head_Gson> openProductHeadGsonCall();

    @GET("category.php?api_version=1.0&act=search_category_goods_list&c_id=0&order_price=0&debug=true&client_id=&key=")
    Call<Product_List_Gson> openProductListGsonCall(@Query("page_num") int page_num, @Query("page") int page);

    @GET("topic.php?act=info&debug=true&api_version=1.0")
    Call<DetailsBean> queryDetailsData(@Query("topic_id")String topicID,@Query("user_id")String userID);

    @GET("topic.php?act=remark_list&debug=true&api_version=1.0&from_id=0")
    Call<CommentBean> queryCommentData(@Query("topic_id")String topicID,@Query("count")String count);

    @GET("topic.php?act=related_topics&debug=true&api_version=1.0")
    Call<RelativeTopicBean> queryRalativeTopicData(@Query("topic_id")String topicID);

    @GET("tags.php?api_version=1.0&debug=true&act=banner&type=3")
    Call<WelcomeBean> queryWelcomeData();
}
