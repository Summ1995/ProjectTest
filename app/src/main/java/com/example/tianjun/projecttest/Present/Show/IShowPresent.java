package com.example.tianjun.projecttest.Present.Show;

/**
 * Created by xx on 2016/9/13.
 */
public interface IShowPresent {
    void requestCategoryData(int requestCode);

    void requestListData(String categoryID,int count,int requestCode);

    void requestSuccess(Object object,int requestCode);
}
