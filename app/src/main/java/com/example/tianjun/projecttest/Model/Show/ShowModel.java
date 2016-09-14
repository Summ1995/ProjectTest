package com.example.tianjun.projecttest.Model.Show;

import com.example.tianjun.projecttest.Bean.Show.CategoryBean;
import com.example.tianjun.projecttest.Bean.Show.ListBean;
import com.example.tianjun.projecttest.Present.Show.IShowPresent;
import com.example.tianjun.projecttest.Util.HttpRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xx on 2016/9/13.
 */
public class ShowModel implements IShowModel{
    @Override
    public void getCategoryDataByHttpRequest(final IShowPresent present,final int requestCode) {
        HttpRequest.getHttpService().queryShowCategory().enqueue(new Callback<CategoryBean>() {
            @Override
            public void onResponse(Call<CategoryBean> call, Response<CategoryBean> response) {
                present.requestSuccess(response.body(),requestCode);
            }

            @Override
            public void onFailure(Call<CategoryBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void getListDataByHttpRequest(String categoryID, int count,final IShowPresent present,final int requestCode) {
        String strCount = String.valueOf(count);
        HttpRequest.getHttpService().queryShowList(categoryID,strCount).enqueue(new Callback<ListBean>() {
            @Override
            public void onResponse(Call<ListBean> call, Response<ListBean> response) {
                present.requestSuccess(response.body(),requestCode);
            }

            @Override
            public void onFailure(Call<ListBean> call, Throwable t) {

            }
        });
    }

}
