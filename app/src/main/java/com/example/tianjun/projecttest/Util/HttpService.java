package com.example.tianjun.projecttest.Util;

import com.example.tianjun.projecttest.Bean.Detail.RelativeTopicBean;
import com.example.tianjun.projecttest.Bean.Detail.CommentBean;
import com.example.tianjun.projecttest.Bean.Detail.DetailsBean;
import com.example.tianjun.projecttest.Bean.Home.CategoryBean;
import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.Bean.Home.ListHeadBean;
import com.example.tianjun.projecttest.Bean.Home.TabBean;
import com.example.tianjun.projecttest.Bean.Me.Me_Ranking_Gson;
import com.example.tianjun.projecttest.Bean.Product.BuyShop_Gson;
import com.example.tianjun.projecttest.Bean.Product.BuyShop_Info_Grid_Gson;
import com.example.tianjun.projecttest.Bean.Product.BuyShop_Info_List_Gson;
import com.example.tianjun.projecttest.Bean.Product.BuyShop_Info_Title_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_GridInfo_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Head_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Info_GridLayout_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Info_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Info_ReadMe_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_List_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Tab_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Type_Gson;
import com.example.tianjun.projecttest.Bean.Welcome.WelcomeBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @GET("category.php?api_version=1.0&act=search_category_goods_list&order_price=0&debug=true&client_id=24187&key=")
    Call<Product_List_Gson> openProductListGsonCall(@Query("c_id") String c_id, @Query("page_num") int page_num, @Query("page") int page);

    @GET("category.php?api_version=1.0&act=search_category_list&debug=true")
    Call<Product_Type_Gson> openProductTypeGsonCall();

    @GET("category.php?api_version=1.0&act=search_category_goods_list&order_price=0&page_num=20&page=1&debug=true&client_id=28147")
    Call<Product_GridInfo_Gson> openProductGridInfoGsonCall(@Query("c_id") String c_id, @Query("page") int page);

    @GET("goods.php?act=goods_detail&debug=true&api_version=1.0")
    Call<Product_Info_Gson> openProductInfoGsonCall(@Query("goods_id") String goods_id);

    @GET("topic.php?act=info&debug=true&api_version=1.0")
    Call<DetailsBean> queryDetailsData(@Query("topic_id")String topicID,@Query("user_id")String userID);

    @GET("topic.php?act=remark_list&debug=true&api_version=1.0&from_id=0")
    Call<CommentBean> queryCommentData(@Query("topic_id")String topicID,@Query("count")String count);

    @GET("topic.php?act=related_topics&debug=true&api_version=1.0")
    Call<RelativeTopicBean> queryRalativeTopicData(@Query("topic_id") String topicID);

    @GET("goods.php?act=related_topics&debug=true&api_version=1.0")
    Call<Product_Info_ReadMe_Gson> openProductInfoReadMeGsonCall(@Query("goods_id") String goods_id);

    @GET("goods.php?act=related_goods&debug=true&api_version=1.0")
    Call<Product_Info_GridLayout_Gson> openProductInfoGridLayoutGsonCall(@Query("goods_id") String goods_id);

    @GET("shop.php?act=list&debug=true&api_version=1.0&key=&from_id=&count=10")
    Call<BuyShop_Gson> openBuyShopGsonCall();

    @GET("tags.php?api_version=1.0&debug=true&act=banner&type=3")
    Call<WelcomeBean> queryWelcomeData();

    @GET("shop.php?act=info&debug=true&api_version=1.0&user_id=28147")
    Call<BuyShop_Info_Title_Gson> openBuyShopInfoTitleGsonCall(@Query("shop_id") String shop_id);

    @GET("shop.php?act=search_shop_goods_list&debug=true&api_version=1.0&&client_id=&key=&order_price=4&getcolorid=&page_num=20&page=1")
    Call<BuyShop_Info_Grid_Gson> openBuyShopInfoGridGsonCall(@Query("c_id") String c_id);

    @GET("shop.php?act=relate_topic&debug=true&api_version=1.0&&client_id=&count=20&from_id=0")
    Call<BuyShop_Info_List_Gson> openBuyShopInfoListGsonCall(@Query("shop_id") String shop_id);

    @GET("invite.php?act=rank&debug=true&api_version=1.0")
    Call<Me_Ranking_Gson> openMeRankingGsonCall();


    @GET("share.php?api_version=1.0&act=category_list&debug=true")
    Call<com.example.tianjun.projecttest.Bean.Show.CategoryBean> queryShowCategory();

    @GET("share.php?act=share_list&debug=true&api_version=1.0&key=&from_id=&user_id=")
    Call<com.example.tianjun.projecttest.Bean.Show.ListBean> queryShowList(@Query("category_id")String categoryID,@Query("count")String count,@Query("key")String key);
}
