package com.example.tianjun.projecttest.View.Show;

import com.example.tianjun.projecttest.Bean.Show.CategoryBean;
import com.example.tianjun.projecttest.Bean.Show.ListBean;

import java.util.List;

/**
 * Created by xx on 2016/9/13.
 */
public interface IShowView {
    void getCategoryData(List<CategoryBean.InfoBean> beanList);

    void getListData(List<ListBean.InfoBean> beanList);
}
