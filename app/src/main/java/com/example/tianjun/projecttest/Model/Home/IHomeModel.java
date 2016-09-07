package com.example.tianjun.projecttest.Model.Home;

import com.example.tianjun.projecttest.Present.Home.IHomePresent;

/**
 * Created by xx on 2016/9/5.
 */
public interface IHomeModel {
    void RequestTabData(IHomePresent callBack,int requestCode);

    void RequestListData(int count,int id,IHomePresent callBack,int requestCode);

    void RequestListHeadData(IHomePresent callBack,int requestCode);

    void RequestCategoryData(IHomePresent callBack,int requestCode);
}
