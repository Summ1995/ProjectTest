package com.example.tianjun.projecttest.View.Home;

import com.example.tianjun.projecttest.Bean.Home.CategoryBean;
import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.Bean.Home.ListHeadBean;
import com.example.tianjun.projecttest.Bean.Home.TabBean;

import java.util.List;

/**
 * Created by xx on 2016/9/5.
 */
public interface IHomeView {
    void getRequestTabBean(List<TabBean.InfoBean> bean);

    void getRequestListBean(List<ListBean.InfoBean> bean);

    void getRequestListHeadBean(List<ListHeadBean.InfoBean.ItemsBean> bean);

    void getRequestCategoryBean(CategoryBean.InfoBean bean);
}
