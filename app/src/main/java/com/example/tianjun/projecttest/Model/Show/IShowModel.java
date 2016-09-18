package com.example.tianjun.projecttest.Model.Show;

import com.example.tianjun.projecttest.Present.Show.IShowPresent;

/**
 * Created by xx on 2016/9/13.
 */
public interface IShowModel {
    void getCategoryDataByHttpRequest(IShowPresent present,int requestCode);

    void getListDataByHttpRequest(String categoryID,int count,String key,IShowPresent present,int requestCode);
}
