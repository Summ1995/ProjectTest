package com.example.tianjun.projecttest.Present.Home;

import com.example.tianjun.projecttest.View.Home.IHomeView;

/**
 * Created by xx on 2016/9/5.
 */
public interface IHomePresent {
    void requestTabData(int requestCode);

    void requestListData(int count,int id,int requestCode);

    void requestListHeadData(int requestCode);

    void requestCategoryData(int requestCode);

    void httpRequestSuccess(Object object,int requestCode);
}
