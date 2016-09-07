package com.example.tianjun.projecttest.Model.Home;

import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.Bean.Home.ListHeadBean;
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

    @Override
    public void RequestListData(int count, int id,final IHomePresent callBack,final int requestCode) {
        HttpRequest.getHttpService().queryHomeListData(count,id).enqueue(new Callback<ListBean>() {
            @Override
            public void onResponse(Call<ListBean> call, Response<ListBean> response) {
                callBack.httpRequestSuccess(response.body(),requestCode);
            }

            @Override
            public void onFailure(Call<ListBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void RequestListHeadData(final IHomePresent callBack,final int requestCode) {
        HttpRequest.getHttpService().queryHomeListHeadData().enqueue(new Callback<ListHeadBean>() {
            @Override
            public void onResponse(Call<ListHeadBean> call, Response<ListHeadBean> response) {
                callBack.httpRequestSuccess(response.body(),requestCode);
            }

            @Override
            public void onFailure(Call<ListHeadBean> call, Throwable t) {

            }
        });
    }
}
