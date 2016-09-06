package com.example.tianjun.projecttest.Model.Home;

import com.example.tianjun.projecttest.Bean.Home.TabBean;
import com.example.tianjun.projecttest.Present.Home.IHomePresent;
import com.example.tianjun.projecttest.Util.HttpRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xx on 2016/9/5.
 */
public class HomeModel implements IHomeModel{


    @Override
    public void RequestTabData(final IHomePresent callBack,final int requestCode) {
        HttpRequest.getHttpService().queryHomeTabData().enqueue(new Callback<TabBean>() {
            @Override
            public void onResponse(Call<TabBean> call, Response<TabBean> response) {
                callBack.httpRequestSuccess(response.body(),requestCode);
            }

            @Override
            public void onFailure(Call<TabBean> call, Throwable t) {

            }
        });
    }
}
